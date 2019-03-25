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
  ngOnInit(): void {
  }

  constructor(private twitService: TwitService) {
  }

  getTwits(): Twit[] {
    return this.twitService.getTwits();
  }

  createTwit(text: string): void {
    this.twitService.addTwit(text);
  }
}
