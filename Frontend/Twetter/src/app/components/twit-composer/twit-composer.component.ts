import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-twit-composer',
  templateUrl: './twit-composer.component.html',
  styleUrls: ['./twit-composer.component.scss']
})
export class TwitComposerComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  postTwit() {
    const input = document.getElementById('twit-input') as HTMLInputElement;
    console.log(input.value);
    // Send input to the backend to create a new Twit.
  }
}
