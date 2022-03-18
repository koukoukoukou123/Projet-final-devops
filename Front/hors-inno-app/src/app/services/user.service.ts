import { User } from '../Model/user.model';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Router} from '@angular/router';

@Injectable({ providedIn: 'root' })
export class UserService {
  private appUrl = 'http://localhost:8080/sport/users';
    httpOptions = {
    headers: new HttpHeaders({'Content-type': 'application/json' })
  };
    constructor(private http: HttpClient, private router: Router) { }
// Retrieve the list of all users from our database
    getAll() {
        return this.http.get<User[]>(`${this.appUrl}`);
    }
// Retrieve a user from our database based on his username
    getByUsername(username: string) {
        return this.http.get(`${this.appUrl}/${username}`);
    }
// Add a new user to our database
    register(user: User) {
        // return this.http.post(`${appUrl}/adduser`, user);
        return this.http.post(this.appUrl + '/adduser', user, this.httpOptions);
    }
// Delete a user from our database, based on his username
    delete(username: string) {
      return this.http.delete(`${this.appUrl}/deleteuser/${username}`);
    }
}