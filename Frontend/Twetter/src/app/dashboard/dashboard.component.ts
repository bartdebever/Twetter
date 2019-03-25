import { Component, OnInit } from '@angular/core';
import * as Chartist from 'chartist';
import { SearchbarComponent } from '../components/searchbar/searchbar.component';
import { TwitViewerComponent } from '../components/twit-viewer/twit-viewer.component';
import { Twit } from 'app/models/twit';
import { User } from 'app/models/user';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  ngOnInit(): void {
  }

  constructor() { }

  getTwits(): Twit[] {
    const array = new Array();
    const twit = new Twit();
    twit.content = 'This is a really long text cause I really like expressing myself in the most long way as possible and go on and on and on and on.';
    twit.user = this.getUser();
    array.push(twit);

    return array;
  }

  getUser(): User {
    const user = new User();
    user.username = 'Bart';
    return user;
  }
}