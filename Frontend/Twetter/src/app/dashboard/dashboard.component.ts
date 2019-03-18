import { Component, OnInit } from '@angular/core';
import { Twit } from 'app/models/twit';
import { User } from 'app/models/user';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  ngOnInit(): void {
  }

  constructor() { }

  getTwits(): Twit[] {
    const twit = new Twit();
    twit.content = 'Test content with a much longer string to test things like overflow and how an actual twit would be displayed.';

    const user = new User();
    user.username = 'Bart';
    twit.user = user;

    return [twit];
  }
}
