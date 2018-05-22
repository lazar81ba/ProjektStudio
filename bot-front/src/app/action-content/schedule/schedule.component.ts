import {Component, Input, OnInit} from '@angular/core';
import {ScheduleService} from '../../shared/schedule.service';
import {Subject} from 'rxjs/Subject';
import {Schedule} from '../../model/Schedule';

@Component({
  selector: 'schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {
  @Input() schedules: Schedule[];

  constructor() { }
  ngOnInit() {
  }

}
