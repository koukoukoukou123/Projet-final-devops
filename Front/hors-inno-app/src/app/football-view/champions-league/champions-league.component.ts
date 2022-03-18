import { Component, OnInit } from '@angular/core';
import { IequipeInfo } from './../../Model/info-equipe';
import { FootballService } from './../football.service';
import { NgForm } from '@angular/forms';
import { IequipeInfoadd } from 'src/app/Model/info-equipe-add';
import { Router } from '@angular/router';
import { Location} from '@angular/common';
import { Iteam } from 'src/app/Model/team';

@Component({
  selector: 'app-champions-league',
  templateUrl: './champions-league.component.html',
  styleUrls: ['./champions-league.component.css']
})
export class ChampionsLeagueComponent implements OnInit {

  equipes: IequipeInfo[] = new Array();
  teams: Iteam[] = new Array();
  equipe: IequipeInfo;
  equipeToAdd: IequipeInfoadd;
  constructor(private FootballService: FootballService, public router: Router, public location: Location) { }

  ngOnInit() {
    this.getClassement();
  }
  getClassement() {
    this.FootballService.getclassement().subscribe(result =>
      result.forEach(element => {
        if (element.championship.championshipName === 'championLeague') {
          this.equipes.push(element);
        }
      })
    );
  }

  onFormSubmit(equipe: NgForm) {
    this.equipeToAdd = equipe.value;
    this.equipeToAdd.championship = 'championLeague';
    console.log(this.equipeToAdd);
    this.FootballService.addTeam(this.equipeToAdd).subscribe(result =>
      console.log(result));
    this.router.navigate([this.router.url]);
    this.refresh();
  }
  resthThform(equipe: NgForm) {
    equipe.resetForm();
  }

  refresh(): void {
    this.router.navigateByUrl('/football-view', { skipLocationChange: true }).then(() => {
      console.log(decodeURI(this.location.path()));
      this.router.navigate([decodeURI(this.location.path())]);
    });
  }
}
