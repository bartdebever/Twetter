import { Injectable } from '@angular/core';
import { Twit } from '../models/twit';
import { User } from '../models/user';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TwitService {
  constructor(private httpClient: HttpClient) {
  }

  public getTwits(): Observable<Twit[]> {
    return this.httpClient.get<Twit[]>(`${environment.baseUrl}/twits`);
  }

  public addTwit(text: string): void {
    const twit = new Twit();
    twit.content = text;
  }

  public removeTwit(twit: Twit): void {

  }
}
