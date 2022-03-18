import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from '../Model/user.model';

@Injectable({ providedIn: 'root' })
/**
 * The authentication service is used to login & logout of the Angular app,..
 *...it notifies other components when the user logs in & out,..
 *...and allows access the currently logged in user.
 */
export class AuthenticationService {
    private appUrl='http://localhost:8080/sport/users';
    //RxJS Subjects and Observables are used to store the current user object..
    //..and notify other components when the user logs in and out of the app:
    // => Angular components can subscribe() to the public currentUser: Observable property to be notified of changes,..
    //....and notifications are sent when the this.currentUserSubject.next() method is called in the login() and logout() methods, passing the argument to each subscriber. 
    //The RxJS BehaviorSubject is a special type of Subject that keeps hold of the current value...
    //...and emits it to any new subscribers as soon as they subscribe,...
    //... while regular Subjects don't store the current value and only emit values that are published after a subscription is created. 
    private currentUserSubject: BehaviorSubject<User>;
    //The public currentUser property is then set to this.currentUserSubject.asObservable();...
    //...which allows other components to subscribe to the currentUser Observable... 
    //...but doesn't allow them to publish to the currentUserSubject,...
    //...this is so logging in and out of the app can only be done via the authentication service.
    public currentUser: Observable<User>;
/**
 * The constructor() of the service initialises the currentUserSubject with the currentUser object from localStorage 
 * ...which enables the user to stay logged in between page refreshes or after the browser is closed. 
 */
    constructor(private http: HttpClient) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
        this.currentUser = this.currentUserSubject.asObservable();
    }
/**
 * The currentUserValue getter allows other components an easy way to get the value of...
 * ...the currently logged in user without having to subscribe to the currentUser Observable.
 */
    public get currentUserValue(): User {
        return this.currentUserSubject.value;
    }
/**
 * The login() method sends the user credentials to the API via an HTTP POST request for authentication
 */
    login(username: string, password: string) {
        return this.http.post<any>(`${this.appUrl}/connexion`, { username, password })
            .pipe(map(user => {
                // If successful the user object including a JWT auth token are stored in localStorage...
                // ...to keep the user logged in between page refreshes:
                // login successful if there's a jwt token in the response
                if (user) {
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify(user));
                    // The user object is then published to all subscribers with the call to this.currentUserSubject.next(user);
                    this.currentUserSubject.next(user);
                }

                return user;
            }));
    }
/**
 * The logout() method removes the current user object from local storage and publishes null to 
 * the currentUserSubject to notify all subscribers that the user has logged out.
 */
    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
        this.currentUserSubject.next(null);
    }
}