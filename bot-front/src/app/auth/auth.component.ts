import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {UserAuthService} from '../shared/user-auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

  authorized: boolean;
  error = false;

  constructor(private userAuthService: UserAuthService, private router: Router) { }

  ngOnInit() {
  }

  onSignIn(f: NgForm) {
      const index = f.value.index;
      const pass = f.value.password;
      this.userAuthService.authorize(index, pass);
      if (this.userAuthService.isAuthorized()) {
        this.router.navigate(['/bot']);
      } else {
        this.error = true;
      }
  }
}
