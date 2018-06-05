import {AfterViewInit, Component, Input, OnChanges, OnInit, ViewChild} from '@angular/core';
import {ScheduleService} from '../../shared/schedule.service';
import {Subject} from 'rxjs/Subject';
import {Schedule} from '../../model/Schedule';
import { jqxSchedulerComponent } from 'jqwidgets-framework/jqwidgets-ts/angular_jqxscheduler';


@Component({
  selector: 'schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements  AfterViewInit , OnChanges {
  @ViewChild('scheduler') myScheduler: jqxSchedulerComponent;
  @Input() schedules: Schedule[] = [];
  @Input() update = false;


  date: any = new jqx.date(new Date());

  source: any =
    {
      dataType: 'array',
      dataFields: [
        { name: 'id', type: 'string' },
        { name: 'description', type: 'string' },
        { name: 'location', type: 'string' },
        { name: 'subject', type: 'string' },
        { name: 'calendar', type: 'string' },
        { name: 'start', type: 'date' },
        { name: 'end', type: 'date' }
      ],
      id: 'id',
      localData: this.generateAppointments()
    };
  dataAdapter: any = new jqx.dataAdapter(this.source);

  resources: any =
    {
      colorScheme: 'scheme05',
      dataField: 'calendar',
      source: new jqx.dataAdapter(this.source)
    };

  appointmentDataFields: any =
    {
      from: 'start',
      to: 'end',
      id: 'id',
      description: 'description',
      location: 'place',
      subject: 'subject',
      resourceId: 'calendar',
    };

  views: any[] =
    [
      {type: 'dayView', showWeekends: false, timeRuler: { scaleStartHour: 7, scaleEndHour: 22 } },
      {type: 'weekView', showWeekends: false, timeRuler: { scaleStartHour: 7, scaleEndHour: 22 } },
      {type: 'monthView', showWeekends: true, timeRuler: { scaleStartHour: 7, scaleEndHour: 22 } },
      {type: 'agendaView' }
    ];


  ngOnChanges() {
    if (this.update) {
      this.updateScheduler();
    }
  }

  updateScheduler() {
    this.myScheduler.beginAppointmentsUpdate();
    this.source.localData = this.generateAppointments();
    if (this.schedules[0] != null) {
      this.myScheduler.attrDate = new jqx.date(new Date(this.schedules[0].dateStart));
    } else {
      this.myScheduler.attrDate = new jqx.date(new Date());
    }
    this.dataAdapter = new jqx.dataAdapter(this.source) ;

    this.myScheduler.endAppointmentsUpdate();
  }

  ngAfterViewInit() {
    this.updateScheduler();
  }

  generateAppointments() {
    const appointments = new Array();
    let i = 1;
    for (const schedule of this.schedules) {
      const appointment = {
        id: i.toString(),
        description: schedule.subject.description ,
        location: '',
        subject: schedule.subject.name,
        calendar: schedule.room.name + ' ' + schedule.room.building + ' ' + schedule.room.level,
        start: schedule.dateStart,
        end: schedule.dateEnd,
        resizable: false,
        draggable: false,
        readOnly: false
      };
      appointments.push(appointment);
      i++;
    }

    return appointments;
  }


  onTest3() {

  }

  onTest4() {

  }
}
