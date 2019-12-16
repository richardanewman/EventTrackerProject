import { CoinService } from './../../services/coin.service';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Portfolio } from 'src/app/models/portfolio';
import { PortfolioService } from 'src/app/services/portfolio.service';
import { Coin } from 'src/app/models/coin';

@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.css']
})
export class PortfolioComponent implements OnInit {
  portfolios: Portfolio[] = [];
  port = null;
  editPort: Portfolio = null;
  newCoin: Coin = new Coin();
  selectedCoin = null;
  portId = null;
  updatePort = null;
  new = false;

  constructor(
    private portSvc: PortfolioService,
    private currentRoute: ActivatedRoute,
    private router: Router,
    private coinSvc: CoinService
  ) {}

  ngOnInit() {
    this.loadPortfolios();
    if (!this.port && this.currentRoute.snapshot.paramMap.get('id')) {
      console.log('in oninit if statement');
      return this.portSvc
        .showPortfolio(this.currentRoute.snapshot.paramMap.get('id'))
        .subscribe(
          data => {
            this.port = data;
          },
          error => {
            console.error(error);
            this.router.navigateByUrl('not-found');
          }
        );
    }
  }

  loadPortfolios() {
    this.portSvc.index().subscribe(
      data => {
        this.portfolios = data;
      },
      error => {
        console.error(
          'PortfolioComponent.index(): Error getting all portfolios'
        );
        console.error(error);
      }
    );
  }
  createPortfolio(uid: number, createForm: NgForm) {
    this.portSvc.create(uid, createForm).subscribe(
      data => {
        this.loadPortfolios();
        this.editPort = null;
        this.port = null;
        this.new = false;
      },
      error => {
        console.error('PortfolioComponent.createPortfolio(): Error creating new portfolio');
        console.error(error);
      }
    );
  }

  updatePortfolio() {
    this.portSvc.update(this.editPort).subscribe(
      data => {
        this.loadPortfolios();
        this.editPort = null;
        this.port = null;
      },
      err => {
        console.error('Error in updatePortfolio()');
        console.error(err);
      }
    );
  }
  deletePortfolio() {
    this.portSvc.destroy(this.editPort).subscribe(
      success => {
        this.loadPortfolios();
        this.editPort = null;
        this.port = null;
      },
      failure => {
        console.error('PortfolioComponent.deletePortfolio(): Error deleting portfolio');
        console.error(failure);
      }
    );
  }

//////// Coins ///////////////////////////

  createCoin(pid: number) {
    this.coinSvc.create(pid, this.newCoin).subscribe(
      data => {
        return this.portSvc
        .showPortfolio(pid + '')
        .subscribe(
          moreData => {
            this.port = moreData;
            this.editPort = null;
            this.portId = null;
          },
          error => {
            console.error(error);
            this.router.navigateByUrl('not-found');
          }
        );
      },
      error => {
        console.error('CoinComponent.createCoin(): Error creating coin');
        console.error(error);
      }
    );
  }
  updateCoin(pid: number) {
    this.coinSvc.update(pid, this.selectedCoin).subscribe(
      data => {
        return this.portSvc
        .showPortfolio(pid + '')
        .subscribe(
          moreData => {
            this.port = moreData;
            this.selectedCoin = null;
            this.editPort = null;
            this.updatePort = null;
            this.portId = null;
          },
          error => {
            console.error(error);
            this.router.navigateByUrl('not-found');
          }
        );
      },
      error => {
        console.error('CoinComponent.createCoin(): Error creating coin');
        console.error(error);
      }
    );
  }
  deleteCoin(pid: number) {
    this.coinSvc.destroy(pid, this.selectedCoin.id).subscribe(
      data => {
        return this.portSvc
        .showPortfolio(pid + '')
        .subscribe(
          moreData => {
            this.port = moreData;
            this.selectedCoin = null;
            this.editPort = null;
            this.updatePort = null;
            this.portId = null;
          },
          error => {
            console.error(error);
            this.router.navigateByUrl('not-found');
          }
        );
      },
      error => {
        console.error('PortfolioComponent.deleteCoin(): Error deleting coin');
        console.error(error);
      }
    );
  }

}
