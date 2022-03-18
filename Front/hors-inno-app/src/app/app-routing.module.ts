import { ChampionsLeagueComponent } from './football-view/champions-league/champions-league.component';
import { LaLiguaComponent } from './football-view/la-ligua/la-ligua.component';
import { Ligue2Component } from './football-view/ligue2/ligue2.component';
import { Ligue1Component } from './football-view/ligue1/ligue1.component';
import { HeadToHeadComponent } from './football-view/head-to-head/head-to-head.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeViewComponent } from './home-view/home-view.component';
import { FootballViewComponent } from './football-view/football-view.component';
import { HandballViewComponent } from './handball-view/handball-view.component';
import { BasketballViewComponent } from './basketball-view/basketball-view.component';
import { RugbyViewComponent } from './rugby-view/rugby-view.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './guards/auth.guard';
import {NotFoundComponent} from './not-found/not-found.component';
const routes: Routes = [
  { path: 'home-view', component: HomeViewComponent, canActivate: [AuthGuard] },
  { path: '', component: HomeViewComponent, canActivate: [AuthGuard] },
  {
    path: 'football-view', component: FootballViewComponent, canActivate: [AuthGuard], children: [
      { path: 'head-to-head', component: HeadToHeadComponent },
      { path: 'ligue-1', component: Ligue1Component },
      { path: 'ligue-2', component: Ligue2Component },
      { path: 'la-ligua', component: LaLiguaComponent },
      { path: 'champions-league', component: ChampionsLeagueComponent }
    ]
  },

  { path: 'basketball-view', component: BasketballViewComponent, canActivate: [AuthGuard] },
  { path: 'handball-view', component: HandballViewComponent, canActivate: [AuthGuard] },
  { path: 'rugby-view', component: RugbyViewComponent, canActivate: [AuthGuard] },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'not-found', component: NotFoundComponent },
      // otherwise redirect to 404-Page
  { path: '**', redirectTo: 'not-found' } //Quand vous entrez un chemin dans la barre de navigation qui 
                                        // n'est pas directement pris en charge par votre application, 
                                        // vous êtes redirigé vers  /not-found  et donc le component 404.
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
