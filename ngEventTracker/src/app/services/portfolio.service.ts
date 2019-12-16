
import { catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Portfolio } from 'src/app/models/portfolio';
import { throwError } from 'rxjs';
import { NgForm } from '@angular/forms';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PortfolioService {

  portfolios: Portfolio[] = [];

  // baseUrl = 'http://localhost:8099/';
  private url = environment.baseUrl + 'api/portfolio';
  private baseUrl = environment.baseUrl;

  constructor(
    private http: HttpClient
  ) { }

  index() {
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.get<Portfolio[]>(this.url + 's', httpOptions).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError('PortfolioServices.index(): Error getting all portfolios');
      })
    );
  }
  showPortfolio(id: string) {
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.get<Portfolio>(this.url + '/' + id, httpOptions).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError('PorfolioService.showPortfolio(): Error getting portfolio by id');
      })
    );
  }

  create(userID: number, createForm: NgForm) {
    const newPortfolio = {
      portfolioName: createForm.value.name
    };
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With': 'XMLHttpRequest',
        'Content-type': 'application/json'
      })
    };
    return this.http.post<Portfolio>(`${this.baseUrl}api/profile/${userID}/portfolio`, newPortfolio, httpOptions).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError('PortfolioService.create(): Error creating new portfolio');
      })
    );
  }

  update(portfolio: Portfolio) {
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With': 'XMLHttpRequest',
        'Content-type': 'application/json'
      })
    };
    return this.http.put(`${this.baseUrl}api/profile/${portfolio.user.id}/portfolio`, portfolio, httpOptions).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError('PortfolioService.update(): Error updating portfolio');
      })
    );
  }

  destroy(portfolio: Portfolio) {
    const httpOptions = {
      headers: new HttpHeaders({
        'X-Requested-With': 'XMLHttpRequest'
      })
    };
    return this.http.delete(`${this.baseUrl}api/profile/${portfolio.user.id}/portfolio/${portfolio.id}`, httpOptions).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError('PortfolioService.destroy(): Error deleting portfolio by user id and portfolio id');
      })
    );
  }
}
