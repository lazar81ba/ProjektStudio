import {CanActivate, Router} from '@angular/router';
import {Injectable} from '@angular/core';
import {UserAuthService} from '../shared/user-auth.service';

@Injectable()
export class AuthGuardService implements CanActivate {
  constructor(public auth: UserAuthService, public router: Router) {}
  canActivate(): boolean {
    if (!this.auth.isAuthorized()) {
      this.router.navigate(['login']);
      return false;
    }
    return true;
  }
}
