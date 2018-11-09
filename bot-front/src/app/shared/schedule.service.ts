import {Injectable} from '@angular/core';
import {UserAuthService} from './user-auth.service';
import {HttpClient, HttpParams} from '@angular/common/http';
import index from '@angular/cli/lib/cli';
import {ScheduleList} from '../model/ScheduleList';
import {Subject} from 'rxjs/Subject';
import { environment } from '../../environments/environment';


@Injectable()
export class ScheduleService {

  public scheduleSubject = new Subject<ScheduleList>();

  constructor(private httpClient: HttpClient, private userService: UserAuthService) {}

  private endpointPrefix = environment.apiHost + '/';
  private endpointStudents = 'students/';
  private endpointEmployees = 'employees/';
  private endpointSchedule = '/schedule';

  public getSchedule() {
     // let params;
    if (this.userService.getUserRole() === 'Student') {
      // params = new HttpParams().set('index', this.userService.getUserIndex());
      this.httpClient.get(this.endpointPrefix + this.endpointStudents + this.userService.getUserIndex() + this.endpointSchedule)
        .subscribe((data: ScheduleList) => {
          this.scheduleSubject.next(data);

        });
      }
    if (this.userService.getUserRole() === 'Teacher') {
      // params = new HttpParams().set('index', this.userService.getUserIndex());
      this.httpClient.get(this.endpointPrefix + this.endpointEmployees + this.userService.getUserIndex() + this.endpointSchedule)
        .subscribe((data: ScheduleList) => {
          this.scheduleSubject.next(data);
        });
    }
  }

  public getScheduleForWeek(date: string) {
    let params;
    if (this.userService.getUserRole() === 'Student') {
      params = new HttpParams().set('date', date);
      this.httpClient.get(this.endpointPrefix + this.endpointStudents + this.userService.getUserIndex() + this.endpointSchedule + '/week',
                      {params})
        .subscribe((data: ScheduleList) => {
          this.scheduleSubject.next(data);
        });
    }

    if (this.userService.getUserRole() === 'Teacher') {
      params = new HttpParams().set('date', date);
      this.httpClient.get(this.endpointPrefix + this.endpointEmployees + this.userService.getUserIndex() + this.endpointSchedule + '/week',
                      {params})
        .subscribe((data: ScheduleList) => {
          this.scheduleSubject.next(data);
        });
    }
  }

  public getScheduleForDay(date: string) {
    let params;
    if (this.userService.getUserRole() === 'Student') {
      params = new HttpParams().set('date', date);
      this.httpClient.get(this.endpointPrefix + this.endpointStudents + this.userService.getUserIndex() + this.endpointSchedule + '/day',
              {params})
        .subscribe((data: ScheduleList) => {
          this.scheduleSubject.next(data);
        });
    }

    if (this.userService.getUserRole() === 'Teacher') {
      params = new HttpParams().set('date', date);
      this.httpClient.get(this.endpointPrefix + this.endpointEmployees + this.userService.getUserIndex() + this.endpointSchedule + '/day',
        {params})
        .subscribe((data: ScheduleList) => {
          this.scheduleSubject.next(data);
        });
    }
  }

}
