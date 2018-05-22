import {UserAuthService} from './user-auth.service';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Subject} from '../model/subject';
import {Score} from '../model/Score';
import {Injectable} from '@angular/core';
import {map} from 'rxjs/operators';

@Injectable()
export class SubjectService {
  private endpointPrefix = 'http://localhost:8080/';
  private endpointSubjects = 'subjects/';


  constructor(private httpClient: HttpClient, private userService: UserAuthService) {}

  public getSubjectByNameObservable(name: string) {
    return this.httpClient.get(this.endpointPrefix + this.endpointSubjects + name);
  }

}
