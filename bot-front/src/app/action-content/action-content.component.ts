import { Component, OnInit } from '@angular/core';
import {ScheduleList} from '../model/ScheduleList';
import {Score} from '../model/Score';
import {ScheduleService} from '../shared/schedule.service';
import {ScoresService} from '../shared/scores.service';
import {Subject} from 'rxjs/Subject';
import {Schedule} from '../model/Schedule';

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
  ngOnInit() {
    this.scoreService.scoresSubject.subscribe(
      (data: Score[]) => {
        this.currentAction = 'scores' ;
        this.scores = data;
    });
    this.scheduleService.scheduleSubject.subscribe(
      (data: ScheduleList) => {
        this.currentAction = 'schedule' ;
        this.schedules = data.scheduleList;
      });
  }

}
