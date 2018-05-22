import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/scan';
import { ChatService } from '../chat.service';
import {Message} from '../../model/Message';
import {ScheduleService} from '../../shared/schedule.service';
import {Score} from '../../model/Score';
import {ScoresService} from '../../shared/scores.service';

@Component({
  selector: 'chat-dialog',
  templateUrl: './chat-dialog.component.html',
  styleUrls: ['./chat-dialog.component.css']
})
export class ChatDialogComponent implements OnInit {

  messages: Observable<Message[]>;
  formValue: string;

  constructor(public chat: ChatService, private scheduleService: ScheduleService, private scoreService: ScoresService) { }

  ngOnInit() {
    // appends to array after each new message is added to feedSource
    this.messages = this.chat.conversation.asObservable()
      .scan((acc, val) => acc.concat(val) );
    const botMessage = new Message('Hi, what can I help you?', 'bot');
    this.chat.update(botMessage);  }

  sendMessage() {
    this.chat.converse(this.formValue);
    this.formValue = '';
  }

  onTest() {
    this.scheduleService.getScheduleForStudent();
  }

  onTest2() {
    this.scoreService.getScoresBySubject(1);
  }
}
