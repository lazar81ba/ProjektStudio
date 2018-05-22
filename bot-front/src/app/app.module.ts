import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import {ChatModule} from './chat/chat.module';
import { AuthComponent } from './auth/auth.component';
import {FormsModule} from '@angular/forms';
import {AppRouteModule} from './app-route.module';
import {UserAuthService} from './shared/user-auth.service';
import {ScheduleService} from './shared/schedule.service';
import {AuthGuardService} from './auth/auth-guard.service';
import {ScoresService} from './shared/scores.service';
import {ActionContentComponent} from './action-content/action-content.component';
import {ScoresComponent} from './action-content/scores/scores.component';
import {ScheduleComponent} from './action-content/schedule/schedule.component';
import {SubjectService} from './shared/subject.service';


@NgModule({
  declarations: [
    AppComponent,
    AuthComponent,
    ActionContentComponent,
    ScoresComponent,
    ScheduleComponent
  ],
  imports: [
    BrowserModule,
    ChatModule,
    FormsModule,
    AppRouteModule,
    HttpClientModule
  ],
  providers: [UserAuthService, ScheduleService, AuthGuardService, ScoresService, SubjectService],
  bootstrap: [AppComponent]
})
export class AppModule { }
