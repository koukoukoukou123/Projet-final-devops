import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

import { AuthenticationService } from '../services/authentication.service';

@Injectable({ providedIn: 'root' })
/**
 * the AuthGuard prevents unauthenticated users from accessing a route 
 * by implementing the CanActivate interface and defining custom rules in the canActivate() method.
 */
export class AuthGuard implements CanActivate {
    constructor(
        private router: Router,
        private authenticationService: AuthenticationService
    ) {}
    /**
     * canActivate() method specifies the parameters (ActivatedRouteSnapshot, RouterStateSnapshot),
     * These 2 parameters are required to implement the CanActivate interface.
     */  
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        //gets the value of the current user by accessing the authenticationService.currentUserValue property.
        const currentUser = this.authenticationService.currentUserValue;
        // If the user is authentified/logged in
        if (currentUser) {
            // authorised so return true
            return true;
        }
        // Else if the user is not logged in returns false  to cancel navigation to the current route.
        // not logged in so redirect to login page with the return url
        this.router.navigate(['/login'], { queryParams: { returnUrl: state.url }});
        return false;
    }
}