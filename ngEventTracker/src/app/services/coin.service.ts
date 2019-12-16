import { catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Coin } from 'src/app/models/coin';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CoinService {

  baseUrl = 'http://localhost:8099/';
  url = this.baseUrl + 'api/coin';

  constructor(
    private http: HttpClient
  ) { }

  index() {
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.get<Coin[]>(this.url + 's', httpOptions).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError('CoinService.index(). Error getting all coins');
      })
    );
  }
  create(pid: number, newCoin: Coin) {
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With': 'XMLHttpRequest',
        'Content-type': 'application/json'
      })
    };
    return this.http.post<Coin>(`${this.baseUrl}api/portfolio/${pid}/coin`, newCoin, httpOptions).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError('CoinService.create(): Error creating new coin');
      })
    );
  }
  update(pid: number, coin: Coin) {
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With': 'XMLHttpRequest',
        'Content-type': 'application/json'
      })
    };
    return this.http.put(`${this.baseUrl}api/portfolio/${pid}/coin/${coin.id}`, coin, httpOptions).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError('CoinService.update(): Error updating coin.');
      })
    );
  }
  destroy(pid: number, cid: number) {
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.delete(`${this.baseUrl}api/portfolio/${pid}/coin/${cid}`, httpOptions).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError('CoinService.destroy(): Error deleting coin.');
      })
    )
  }
}
