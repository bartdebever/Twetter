import { Injectable } from '@angular/core';
import { Twit } from '../models/twit';
import { User } from '../models/user';

@Injectable()
export class TwitService {
  private twits: Twit[];

  constructor() {
    this.twits = this.createTwits();
  }

  public getTwits(): Twit[] {
    return this.twits;
  }

  public addTwit(text: string): void {
    const twit = new Twit();
    twit.content = text;
    twit.user = this.getUser();
    twit.postedAt = new Date();
    this.twits.push(twit);
    this.sortTwits();
  }

  public removeTwit(twit: Twit): void {

  }

  private createTwits(): Twit[] {
    const array = new Array();
    const twit = new Twit();
    twit.postedAt = new Date();
    twit.content = 'This is a really long text cause I really like expressing myself in the most long way as possible and go on and on and on and on.';
    twit.user = this.getUser();
    array.push(twit);

    return array;
  }

  private getUser(): User {
    const user = new User();
    user.username = 'Bart';
    return user;
  }

  private sortTwits(): void {
    this.twits.sort((a, b) => {
      if (a.postedAt > b.postedAt) {
        return -1;
      }

      if (a.postedAt < b.postedAt) {
        return 1;
      }

      return 0;
    })
  }
}
