import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { AuthenticationService } from './services/authentication.service';
import { User } from './Model/user.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
title = 'Sogeti Sport';
//The currentUser property is used to show/hide the nav when the user is logged in/out. 
currentUser: User;

/**
 * The AuthentificationService is integrated by creating its instance in the arguments of the constructor())
 * AppComponent uses the authentication service:
 * -to know the current logged in status and 
 * -to implement logout
 * => therefore: The constructor() method subscribes to the this.authenticationService.currentUser observable 
    and updates the currentUser when the user logs in/out.
 */
  constructor(
    private router: Router,
    private authenticationService: AuthenticationService
    ) {
      this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
    }
/**  
 * The logout() method calls this.authenticationService.logout(); to log the user out, then redirects to the login page.
 */
logout() {
  this.authenticationService.logout();
  this.router.navigate(['/login']);
  }

onHome() {
  this.router.navigate(['home-view']);
}
onFootball() {
  this.router.navigate(['football-view']);
}
onBasketball() {
  this.router.navigate(['basketball-view']);
}
onHandball() {
  this.router.navigate(['handball-view']);
}
onRugby() {
  this.router.navigate(['rugby-view']);
}
}
