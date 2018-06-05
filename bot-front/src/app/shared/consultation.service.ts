import {Injectable} from '@angular/core';
import {Subject} from 'rxjs/Subject';
import {ScheduleList} from '../model/ScheduleList';
import {HttpClient, HttpParams} from '@angular/common/http';
import {UserAuthService} from './user-auth.service';

@Injectable()
export class ConsultationService {
  public consultationSubject = new Subject<ScheduleList>();

  constructor(private httpClient: HttpClient, private userService: UserAuthService) {}
  private endpointPrefix = 'http://localhost:8080/';
  private endpointConsultation = 'getConsultationByNameAndSurname';


  public getConsultationByNameAndSurname(name: string, surname: string) {
    // let params;
    // if (this.userService.getUserRole() === 'Student') {
    //   params = new HttpParams().set('index', this.userService.getUserIndex());
    //   this.httpClient.get(this.endpointPrefix + this.endpointConsultation, {params})
    //     .subscribe((data: ScheduleList) => {
    //       this.consultationSubject.next(data);
    //
    //     });
    // }
  }

}
