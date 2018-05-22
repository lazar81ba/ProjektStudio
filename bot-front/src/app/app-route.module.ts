import {RouterModule, Routes} from '@angular/router';
import {AuthComponent} from './auth/auth.component';
import {NgModule} from '@angular/core';
import {ChatDialogComponent} from './chat/chat-dialog/chat-dialog.component';
import {AuthGuardService} from './auth/auth-guard.service';


const appRoutes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full'},
  { path: 'login', component: AuthComponent },
  { path: 'bot', component: ChatDialogComponent, canActivate: [AuthGuardService]},
  { path: '**', redirectTo: '/login' }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRouteModule {

}
