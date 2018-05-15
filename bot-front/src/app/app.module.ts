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
import {Schedule} from './shared/Schedule';
import {User} from './shared/User';
import {Group} from './shared/group';
import {Subject} from './shared/subject';
import {Room} from './shared/room';
import {Specialization} from './shared/specialization';


@NgModule({
  declarations: [
    AppComponent,
    AuthComponent
  ],
  imports: [
    BrowserModule,
    ChatModule,
    FormsModule,
    AppRouteModule,
    HttpClientModule
  ],
  providers: [UserAuthService, ScheduleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
