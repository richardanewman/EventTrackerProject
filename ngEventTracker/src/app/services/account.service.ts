import { Profile } from 'src/app/models/profile';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Account } from 'src/app/models/account';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  accounts: Account[] = [];


  baseUrl = 'http://localhost:8099/';
  url = this.baseUrl + 'api/account';

  constructor(
    private http: HttpClient
    ) { }

  index() {
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.get<Account[]>(this.url + 's', httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('AccountService.index(): Error retrieving accounts');
      })
    );
  }
  showAccount(id: string) {
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.get<Account>(this.url + '/' + id, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('AccountService.showAccount(): Error retrieving account by id');
      })
    );
  }
  create(acct: Account, prof: Profile) {
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With': 'XMLHttpRequest',
        'Content-type': 'application/json'
      })
    };
    const newUserObj = {
      user: {
        firstName: prof.firstName,
        lastName: prof.lastName
      },
      username: acct.username,
      email: acct.email,
      password: acct.password
    };
    return this.http.post<Account>(this.url, newUserObj, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('AccountService.create(); Error creating new account');
      })
    );
  }

  update(account: Account) {
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With': 'XMLHttpRequest',
        'Content-type': 'application/json'
      })
    };
    return this.http.put(`${this.url}/${account.id}`, account, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('AccountService.update(): Error updating user account');
      })
    );
  }

  destroy(id: number) {
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.delete(`${this.url}/${id}`, httpOptions).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('AccountService.destroy(): Error deleting account');
      })
    );
  }

}
