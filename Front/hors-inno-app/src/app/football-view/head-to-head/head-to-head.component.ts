import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { IheadToHead } from 'src/app/Model/headToHead';
import { FootballService } from './../football.service';
import { Iteam } from 'src/app/Model/team';
import { IHeadvsHead } from 'src/app/Model/headToHeadRes';
import { ImatchResult } from 'src/app/Model/matchResult';
@Component({
  selector: 'app-head-to-head',
  templateUrl: './head-to-head.component.html',
  styleUrls: ['./head-to-head.component.css']
})
export class HeadToHeadComponent implements OnInit {
  teams: Iteam[];
  affichageTableau: boolean;
  affichageChoix: boolean;
  headtoheadres: IHeadvsHead;
  fVsH: ImatchResult[];
  hVs: ImatchResult[];
  fVs: ImatchResult[];
  private headtohead: IheadToHead;
  constructor(private FootballService: FootballService) { }

  ngOnInit() {
    this.affichageChoix = false;
    this.affichageTableau = false;
    this.getteams();
  }

  onFormSubmit(myform: NgForm) {
    this.affichageTableau = false;
    this.affichageChoix = false;
    this.headtohead = myform.value;
    console.log(this.headtohead);
    if (this.headtohead.equipe1 === this.headtohead.equipe2) {
      this.affichageChoix = true;
    } else {
      this.FootballService.getheadToHead(this.headtohead).subscribe(result => {
        console.log(result);
        this.headtoheadres = result;
        if (this.headtoheadres != null) {
          this.fVsH = this.headtoheadres.firstTeam_VS_secondTeam;
          this.fVs = this.headtoheadres.firstTeam_lastResults;
          this.hVs = this.headtoheadres.secondTeam_lastResults;
        }
        console.log(this.headtoheadres);
        this.affichageTableau = true;
        console.log(this.affichageTableau);
      }
      );
    }}
  resthThform(myform: NgForm) {
    myform.resetForm();
  }
  getteams() {
    this.FootballService.getTeams().subscribe(result => {
      this.teams = result;
    }

    );
  }
}
