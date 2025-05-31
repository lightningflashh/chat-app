import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../interfaces/user';
import { environment } from '../../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = environment.apiUrl + environment.apiVersion + 'users/login';

  constructor(
    private http: HttpClient
  ) { }

  login(user: User): Observable<User> {
    return this.http.post<User>(this.apiUrl, user)
  }

  saveToLocalStorage(user: User) {
    localStorage.setItem('user', JSON.stringify({
      username: user.username,
      avatarUrl: user.avatarUrl,
    }));
  }
}
