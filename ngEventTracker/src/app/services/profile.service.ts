import { environment } from 'src/environments/environment';
import { catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Profile } from 'src/app/models/profile';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {


  // baseUrl = 'http://localhost:8099/';
  private url = environment.baseUrl + 'api/profile';


  constructor(
    private http: HttpClient
  ) { }

  index() {
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.get<Profile[]>(this.url + 's', httpOptions).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError('ProfileService.index(): Error getting profile[]');
      })
    );
  }
  showProfile(id: string) {
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.get<Profile>(this.url + '/' + id, httpOptions).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError('ProfileService.showProfile(): Error getting profile by id');
      })
    );
  }
  update(profile: Profile) {
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With': 'XMLHttpRequest',
        'Content-type': 'application/json'
      })
    };
    return this.http.put(`${this.url}/${profile.id}`, profile, httpOptions).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError('ProfileService.update(): Error updating profile');
      })
    );
  }
}
