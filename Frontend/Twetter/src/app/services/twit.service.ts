import { Injectable } from '@angular/core';
import { Twit } from '../models/twit';
import { User } from '../models/user';

@Injectable()
export class TwitService {
  public getTwits(): Twit[] {
    const array = new Array();
    const twit = new Twit();
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
}
