import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-twit-compose',
  templateUrl: './twit-compose.component.html',
  styleUrls: ['./twit-compose.component.scss']
})
export class TwitComposeComponent implements OnInit {
  @Output() composed: EventEmitter<any> = new EventEmitter();
  constructor() { }

  ngOnInit() {
  }

  sendTwit() {
    const input = document.getElementById('twit-input') as HTMLInputElement;
    this.composed.emit(input.value);
  }
}
