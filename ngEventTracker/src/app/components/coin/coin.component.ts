import { CoinService } from 'src/app/services/coin.service';
import { Component, OnInit } from '@angular/core';
import { Coin } from 'src/app/models/coin';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-coin',
  templateUrl: './coin.component.html',
  styleUrls: ['./coin.component.css']
})
export class CoinComponent implements OnInit {
  coins: Coin[] = [];
  coin: Coin = null;

  constructor(
    private coinSvc: CoinService,
    private currentRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.loadCoins();
  }

  loadCoins() {
    this.coinSvc.index().subscribe(
      data => {
        this.coins = data;
      },
      error => {
        console.error(
          'CoinComponent.loadCoins(): Error getting list of all coins'
        );
        console.error(error);
      }
    );
  }
  /////// Will make coin an admin page after spring security is implemented
  /////// Moved other methods to portfilio component ts so users can
  /////// have access to their coins through their portfolio
}
