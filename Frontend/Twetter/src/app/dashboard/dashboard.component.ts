import { Component, OnInit } from '@angular/core';
import * as Chartist from 'chartist';
import { SearchbarComponent } from '../components/searchbar/searchbar.component';
import { TwitViewerComponent } from '../components/twit-viewer/twit-viewer.component';
import { Twit } from 'app/models/twit';
import { User } from 'app/models/user';
import { TwitService } from 'app/services/twit.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})

export class DashboardComponent implements OnInit {

  loading: boolean = false;
  twits: Twit[];

  ngOnInit(): void {
    this.getTwits()
  }

  constructor(private twitService: TwitService) {
  }

  getTwits() {
    this.twitService.getTwits().subscribe(twits => {
      this.twits = twits;
      this.loading = false;
    });
  }

  createTwit(text: string): void {
    console.log(text);
    this.twitService.addTwit(text).subscribe(_ => {
      return;
    });
  }
}
