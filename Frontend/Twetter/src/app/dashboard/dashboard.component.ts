import { Component, OnInit } from '@angular/core';
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

  getTwit(): Twit {
    const twit = new Twit();
    twit.content = 'Test conent';

    const user = new User();
    user.username = 'Test User';
    twit.user = user;

    return twit;
  }
}
