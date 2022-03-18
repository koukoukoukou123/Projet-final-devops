import { IequipeInfoadd } from './../Model/info-equipe-add';
import { IheadToHead } from './../Model/headToHead';
import { Ichampionship } from '../Model/championship';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { IequipeInfo } from '../Model/info-equipe';
import { Observable } from 'rxjs';
import { Iteam } from '../Model/team';
import { IHeadvsHead } from '../Model/headToHeadRes';

@Injectable({
  providedIn: 'root'
})
export class FootballService {
  url = 'http://localhost:8080/sport';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-type': 'application/json'})
  };
  constructor(private http: HttpClient) { }

  getclassement(): Observable<IequipeInfo[]> {
    return this.http.post<IequipeInfo[]>(this.url + '/participation', this.httpOptions);
  }

  getchampionship(): Observable<Ichampionship[]> {
    return this.http.post<Ichampionship[]>(this.url + '/championship', this.httpOptions);
  }

  getTeams(): Observable<Iteam[]> {
    return this.http.post<Iteam[]>(this.url + '/team', this.httpOptions);
  }

  addTeam( equipeAdd: IequipeInfoadd ): Observable<string> {
    console.log(equipeAdd);
    return this.http.put<string>(this.url + '/addteam', equipeAdd , this.httpOptions);
  }

  getheadToHead(headtohead: IheadToHead ): Observable<IHeadvsHead> {
    return this.http.post<IHeadvsHead>(this.url + '/testapi', headtohead, this.httpOptions);
  }

}
