import {AfterViewChecked, AfterViewInit, Injectable, OnInit} from '@angular/core';

import { ApiAiClient } from 'api-ai-javascript';

import { Observable } from 'rxjs/Observable';
import {Subject as subjectRxjs}  from 'rxjs/Subject';

import { BehaviorSubject } from 'rxjs/BehaviorSubject';
import { environment } from '../../environments/environment';
import {Message} from '../model/Message';
import {UserAuthService} from '../shared/user-auth.service';
import {ScheduleService} from '../shared/schedule.service';
import {Subject} from '../model/subject';
import {SubjectService} from '../shared/subject.service';
import {ScoresService} from '../shared/scores.service';

// Message class for displaying messages in the component


@Injectable()
export class ChatService {

  readonly token = environment.dialogflow.angularBot;
  readonly client = new ApiAiClient({ accessToken: this.token });

  conversation = new BehaviorSubject<Message[]>([]);

  private conversationSubject = new subjectRxjs<any>();
  private res: any;

  constructor(private userAuthService: UserAuthService, private scheduleService: ScheduleService, private subjectService: SubjectService, private scoreService: ScoresService) {}

  // Sends and receives messages via DialogFlow
  converse(msg: string) {
    const userMessage = new Message(msg, 'user');
    this.update(userMessage);

    return this.client.textRequest(msg)
      .then(res => {
        this.res = res;
        if (!(typeof res.result['parameters'] === 'undefined')) {
          let role = null;
          if (!(typeof res.result['parameters']['Role'] === 'undefined')) {
            role = res.result['parameters']['Role'];
          }
          if (!this.authorizeRole(role)) {
            this.stopConversation();
          } else {
            this.processAction();
          }
        } else {
          this.update(new Message('Cannot understand what you said', 'bot'));
        }
      });
  }

  private authorizeRole(role: string): boolean {
    if (role !== null && role !== 'Both') {
      return role === this.userAuthService.getUserRole();
    }
    return true;
  }

  private stopConversation() {
    this.client.textRequest('stop');
    this.update(new Message('You are not authorized for this operation. Try me different way.', 'bot'));
  }


  private processAction() {
    let actionType;
    if (!(typeof this.res.result['parameters']['ActionType'] === 'undefined')) {
      actionType = this.res.result['parameters']['ActionType'];
    }
    if (actionType === 'Schedule') {
      this.processScheduleAction();
    } else if (actionType === 'ScoreForStudent' || actionType === 'ScoreForEmployee') {
      this.processScoreAction();
    } else if (actionType === 'Consultation') {
     this.processConsultationAction();
    } else {
      this.update(this.prepareBotMessage());
    }
  }


  private processScheduleAction() {
    if (!(typeof this.res.result['parameters']['date-time'] === 'undefined')) {
      const date = this.res.result['parameters']['date-time'];
      if ( date !== '') {
        const dates: string[] = date.split('/', 2);
        if (dates.length === 2) {
          this.scheduleService.getScheduleForWeek(dates[0]);
        } else if (dates.length === 1) {
          this.scheduleService.getScheduleForDay(dates[0]);
        }
        this.update(this.prepareBotMessage());
      } else {
        this.update(this.prepareBotMessage());
      }
    } else {
      this.update(this.prepareBotMessage());
    }
  }

  private processScoreAction() {

    if (!(typeof this.res.result['parameters']['Subject'] === 'undefined')) {
      const subject = this.res.result['parameters']['Subject'];
      if (subject !== '') {
        const subjectObservable =  this.subjectService.getSubjectByNameObservable(subject);
        subjectObservable.subscribe((subjectFromDB: Subject[]) => {
          if (subjectFromDB !== null) {
            this.scoreService.getScoresBySubject(subjectFromDB[0].id);
            this.update(this.prepareBotMessage());
          } else if (subjectFromDB === null) {
            this.client.textRequest('stop');
            this.update(new Message('Cannot find Subject in out Database', 'bot'));
            return;
          }
        });
      } else {
        this.update(this.prepareBotMessage());
      }
    } else {
      this.update(this.prepareBotMessage());
    }
  }


  private processConsultationAction() {
    if (!(typeof this.res.result['parameters']['TeacherName'] === 'undefined')) {
      const teacherName: string = this.res.result['parameters']['TeacherName'] ;
      if (teacherName !== '') {
        const teacherNameAndSurname = teacherName.split(' ');
        if (teacherNameAndSurname.length === 2) {
          this.scheduleService.getConsultationByNameAndSurname(teacherNameAndSurname[0], teacherNameAndSurname[1]);
        } else {
          this.update(new Message('You probably typed only name or surname.', 'bot'));
        }
      } else {
        this.update(new Message('You probably typed something wrong', 'bot'));
      }
    }
    this.update(this.prepareBotMessage());
  }

  // Adds message to source
  update(msg: Message) {
    this.conversation.next([msg]);
  }

  private prepareBotMessage(): Message {
    const speech = this.res.result.fulfillment.speech;
    return new Message(speech, 'bot');
  }

}
