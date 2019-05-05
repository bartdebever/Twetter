import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  isSubmitting: boolean = false;
  form: FormGroup;
  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
  }

  protected login(): void {
    const userNameInput: HTMLInputElement = document.getElementById('username-input');
    const passwordInput: HTMLInputElement = document.getElementById('password-input');
    const password = passwordInput.value;
    const username = userNameInput.value;
    this.httpClient.post<string>(environment.baseUrl + '/authorization/',
      { username: username, password: password}).subscribe(token => {
        console.log(token);
        localStorage.setItem('token', token.token)
      });
  }

}
