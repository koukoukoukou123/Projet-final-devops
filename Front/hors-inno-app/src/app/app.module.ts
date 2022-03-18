// Modules
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { OrderModule } from 'ngx-order-pipe';
import { MatDialogModule } from '@angular/material';
// The ReactiveFormsModule contains the components, services etc required to build reactive forms.
import { ReactiveFormsModule } from '@angular/forms';
// Components
import { AppComponent } from './app.component';
import { SideBarComponent } from './football-view/side-bar/side-bar.component';
import { HomeViewComponent } from './home-view/home-view.component';
import { FootballViewComponent } from './football-view/football-view.component';
import { BasketballViewComponent } from './basketball-view/basketball-view.component';
import { RugbyViewComponent } from './rugby-view/rugby-view.component';
import { HandballViewComponent } from './handball-view/handball-view.component';
import { Ligue1Component } from './football-view/ligue1/ligue1.component';
import { Ligue2Component } from './football-view/ligue2/ligue2.component';
import { LaLiguaComponent } from './football-view/la-ligua/la-ligua.component';
import { ChampionsLeagueComponent } from './football-view/champions-league/champions-league.component';
import { HeadToHeadComponent } from './football-view/head-to-head/head-to-head.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AlertComponent } from './alert/alert.component';
import { ErrorDialogComponent } from './error-dialog/errordialog.component';
// Services
import { AuthenticationService } from './services/authentication.service';
// import { AlertService } from './services/alert.service';
import { UserService } from './services/user.service';
import { NotFoundComponent } from './not-found/not-found.component';
// import { httpInterceptorProviders} from './auth/auth-interceptor';
import { ErrorDialogService } from './error-dialog/errordialog.service';

import { HttpConfigInterceptor} from './interceptors/httpconfig.interceptor';


@NgModule({
  declarations: [
    AppComponent,
    HomeViewComponent,
    FootballViewComponent,
    BasketballViewComponent,
    RugbyViewComponent,
    HandballViewComponent,
    SideBarComponent,
    Ligue1Component,
    Ligue2Component,
    LaLiguaComponent,
    ChampionsLeagueComponent,
    HeadToHeadComponent,
    LoginComponent,
    RegisterComponent,
    AlertComponent,
    NotFoundComponent,
    ErrorDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    OrderModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatDialogModule
  ],
  providers: [
    AuthenticationService, 
    // AlertService,
    UserService,
    ErrorDialogService,
    { provide: HTTP_INTERCEPTORS, useClass: HttpConfigInterceptor, multi: true }
  ],
  entryComponents: [ErrorDialogComponent],
  bootstrap: [AppComponent],
})
export class AppModule { }
