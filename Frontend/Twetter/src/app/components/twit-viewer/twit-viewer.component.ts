import { Component, OnInit, Input } from '@angular/core';
import { Twit } from 'app/models/twit';
import { User } from 'app/models/user';
import { TwitService } from 'app/services/twit.service';

@Component({
  selector: 'app-twit-viewer',
  templateUrl: './twit-viewer.component.html',
  styleUrls: ['./twit-viewer.component.scss']
})
export class TwitViewerComponent implements OnInit {
  @Input('data') data: Twit;
  constructor() { }

  ngOnInit() {
  }

}
