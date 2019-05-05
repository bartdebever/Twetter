import { Injectable } from '@angular/core';
import { Twit } from '../models/twit';
import { User } from '../models/user';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment';
import { BaseService } from './base.service';

@Injectable({
  providedIn: 'root'
})
export class TwitService extends BaseService {
  constructor(private httpClient: HttpClient) {
    super(httpClient);

  }

  public getTwits(): Observable<Twit[]> {
    return this.httpClient.get<Twit[]>(`${environment.baseUrl}/twits`);
  }

  public addTwit(text: string): Observable<any> {
    const twit = new Twit();
    twit.content = text;
    return this.httpClient.post(`${environment.baseUrl}/twits`, twit, { headers: this.defaultHeaders});
  }

  public removeTwit(twit: Twit): void {

  }
}
