import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {UserAuthService} from './user-auth.service';
import {Score} from '../model/Score';
import {Subject} from 'rxjs/Subject';

@Injectable()
export class ScoresService {
  private endpointPrefix = 'http://localhost:8080/';
  private endpointStudentScoresBySubject = 'getStudentScoresBySubject';
  private endpointScoresBySubject = 'getScoresBySubject';

  public scoresSubject = new Subject<Score[]>();

  constructor(private httpClient: HttpClient, private userService: UserAuthService) {}

  public getScoresBySubject(id: number) {
    let params;
    if (this.userService.getUserRole() === 'Student') {
      params = new HttpParams().set('index', this.userService.getUserIndex()).set('subjectId', id.toString());
      this.httpClient.get(this.endpointPrefix + this.endpointStudentScoresBySubject, {params})
        .subscribe((data: Score[]) => {
          this.scoresSubject.next(data);
        });
    }
    if (this.userService.getUserRole() === 'Teacher') {
      params = new HttpParams().set('subjectId', id.toString());
      this.httpClient.get(this.endpointPrefix + this.endpointScoresBySubject, {params})
        .subscribe((data: Score[]) => {
          this.scoresSubject.next(data);
        });
    }
  }

}
