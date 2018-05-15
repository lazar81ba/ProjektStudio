import {Injectable} from '@angular/core';
import {UserAuthService} from './user-auth.service';
import {HttpClient, HttpParams} from '@angular/common/http';
import index from '@angular/cli/lib/cli';
import {ScheduleList} from './ScheduleList';

@Injectable()
export class ScheduleService {

  constructor(private httpClient: HttpClient, private userService: UserAuthService) {}

  private endpointPrefix = 'http://localhost:8080/';
  private endpontStudentForWeek = 'getStudentScheduleForWeek';
  private endpointStudentForDay = 'getStudentScheduleForDay';
  private endpointStudent = 'getStudentSchedule';
  private endpontEmployeeForWeek = 'getEmployeeScheduleForWeek';
  private endpointEmployeeForDay = 'getEmployeeStudentScheduleForDay';
  private endpointEmployee = 'getEmployeeStudentSchedule';


  public getScheduleForStudent() {
    const params = new HttpParams().set('index', '253233');
    this.httpClient.get(this.endpointPrefix + this.endpointStudent, {params})
      .subscribe((data: ScheduleList) => {
      console.log(data);
      console.log(data.scheduleList[1].dateEnd);
    });
  }


}
