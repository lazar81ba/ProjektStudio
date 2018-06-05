import {Injectable} from '@angular/core';
import {UserAuthService} from './user-auth.service';
import {HttpClient, HttpParams} from '@angular/common/http';
import index from '@angular/cli/lib/cli';
import {ScheduleList} from '../model/ScheduleList';
import {Subject} from 'rxjs/Subject';

@Injectable()
export class ScheduleService {

  public scheduleSubject = new Subject<ScheduleList>();

  constructor(private httpClient: HttpClient, private userService: UserAuthService) {}

  private endpointPrefix = 'http://localhost:8080/';
  private endpointStudentForWeek = 'getStudentScheduleForWeek';
  private endpointStudentForDay = 'getStudentScheduleForDay';
  private endpointStudent = 'getStudentSchedule';
  private endpontEmployeeForWeek = 'getEmployeeScheduleForWeek';
  private endpointEmployeeForDay = 'getEmployeeScheduleForDay';
  private endpointEmployee = 'getEmployeeSchedule';


  public getScheduleForStudent() {
    let params;
    if (this.userService.getUserRole() === 'Student') {
      params = new HttpParams().set('index', this.userService.getUserIndex());
      this.httpClient.get(this.endpointPrefix + this.endpointStudent, {params})
        .subscribe((data: ScheduleList) => {
          this.scheduleSubject.next(data);

        });
      }
    if (this.userService.getUserRole() === 'Teacher') {
      params = new HttpParams().set('index', this.userService.getUserIndex());
      this.httpClient.get(this.endpointPrefix + this.endpointEmployee, {params})
        .subscribe((data: ScheduleList) => {
          this.scheduleSubject.next(data);
        });
    }
  }

  public getScheduleForWeek(date: string) {
    let params;
    if (this.userService.getUserRole() === 'Student') {
      params = new HttpParams().set('index', this.userService.getUserIndex()).set('date', date);
      this.httpClient.get(this.endpointPrefix + this.endpointStudentForWeek, {params})
        .subscribe((data: ScheduleList) => {
          this.scheduleSubject.next(data);
        });
    }

    if (this.userService.getUserRole() === 'Teacher') {
      params = new HttpParams().set('universityNick', this.userService.getUserIndex()).set('date', date);
      this.httpClient.get(this.endpointPrefix + this.endpontEmployeeForWeek, {params})
        .subscribe((data: ScheduleList) => {
          this.scheduleSubject.next(data);
        });
    }
  }

  public getScheduleForDay(date: string) {
    let params;
    if (this.userService.getUserRole() === 'Student') {
      params = new HttpParams().set('index', this.userService.getUserIndex()).set('date', date);
      this.httpClient.get(this.endpointPrefix + this.endpointStudentForDay, {params})
        .subscribe((data: ScheduleList) => {
          this.scheduleSubject.next(data);
        });
    }

    if (this.userService.getUserRole() === 'Teacher') {
      params = new HttpParams().set('universityNick', this.userService.getUserIndex()).set('date', date);
      this.httpClient.get(this.endpointPrefix + this.endpointEmployeeForDay, {params})
        .subscribe((data: ScheduleList) => {
          this.scheduleSubject.next(data);
        });
    }
  }

}
