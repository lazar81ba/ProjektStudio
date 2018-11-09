import {UserAuthService} from './user-auth.service';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Subject} from '../model/subject';
import {Score} from '../model/Score';
import {Injectable} from '@angular/core';
import {map} from 'rxjs/operators';
import { environment } from '../../environments/environment';


@Injectable()
export class SubjectService {
  private endpointPrefix = environment.apiHost + '/subjects';


  constructor(private httpClient: HttpClient, private userService: UserAuthService) {}

  public getSubjectByNameObservable(name: string) {
    const params = new HttpParams().set('name', name);
    return this.httpClient.get(this.endpointPrefix, {params});
  }

}
