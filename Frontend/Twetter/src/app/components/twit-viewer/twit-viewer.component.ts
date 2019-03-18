import { Component, OnInit, Input } from '@angular/core';
import { Twit } from 'app/models/twit';

@Component({
  selector: 'app-twit-viewer',
  templateUrl: './twit-viewer.component.html',
  styleUrls: ['./twit-viewer.component.scss']
})
export class TwitViewerComponent implements OnInit {
  @Input('twit') twit: Twit;
  constructor() { }

  ngOnInit() {
    console.log(this.twit);
  }

}
