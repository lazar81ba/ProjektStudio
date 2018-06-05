import {Component, OnInit, ViewChild} from '@angular/core';
import {ScheduleList} from '../model/ScheduleList';
import {Score} from '../model/Score';
import {ScheduleService} from '../shared/schedule.service';
import {ScoresService} from '../shared/scores.service';
import {Subject} from 'rxjs/Subject';
import {Schedule} from '../model/Schedule';
import {jqxSchedulerComponent} from 'jqwidgets-framework/jqwidgets-ts/angular_jqxscheduler';
import {ScheduleComponent} from './schedule/schedule.component';

@Component({
  selector: 'action-content',
  templateUrl: './action-content.component.html',
  styleUrls: ['./action-content.component.css']
})
export class ActionContentComponent implements OnInit {

  constructor(private scoreService: ScoresService, private scheduleService: ScheduleService) {}
  public scores: Score[] = null;
  public schedules: Schedule[] = null;

  public currentAction: string = null;
  public updateComponent = false;
  public consultation = false;

  ngOnInit() {
    this.scoreService.scoresSubject.subscribe(
      (data: Score[]) => {
        if (this.currentAction === 'scores') {
          this.updateComponent = true;
        } else {
          this.currentAction = 'scores';
          this.updateComponent = false;
        }
        this.scores = data;
    });
    this.scheduleService.scheduleSubject.subscribe(
      (data: ScheduleList) => {
        if (this.currentAction === 'schedule') {
          this.updateComponent = true;
        } else {
          this.currentAction = 'schedule';
          this.updateComponent = false;
        }
        this.consultation= false;
        this.schedules = data.scheduleList;
      });
  }

}
