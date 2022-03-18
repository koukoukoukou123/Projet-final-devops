import { FootballService } from './../football.service';
import { Component, OnInit } from '@angular/core';
import { Ichampionship } from 'src/app/Model/championship';


@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent implements OnInit {
championships: Ichampionship[];
  constructor(private FootballService: FootballService) { }

  ngOnInit() {
// this.getChampionship();
  }
getChampionship() {
  this.FootballService.getchampionship().subscribe(result =>
    this.championships = result
);

}
}
