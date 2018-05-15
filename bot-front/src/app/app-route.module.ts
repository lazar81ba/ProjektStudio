import {RouterModule, Routes} from '@angular/router';
import {AuthComponent} from './auth/auth.component';
import {NgModule} from '@angular/core';
import {ChatDialogComponent} from './chat/chat-dialog/chat-dialog.component';

const appRoutes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full'},
  { path: 'login', component: AuthComponent },
  { path: 'bot', component: ChatDialogComponent},
  { path: '**', redirectTo: '/login' }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRouteModule {

}
