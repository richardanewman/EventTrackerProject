import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Portfolio } from 'src/app/models/portfolio';
import { PortfolioService } from 'src/app/services/portfolio.service';
import { ProfileService } from 'src/app/services/profile.service';

@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.css']
})
export class PortfolioComponent implements OnInit {
  portfolios: Portfolio[] = [];
  port = null;
  userID = null;
  editPort: Portfolio = null;
  bool = false;

  constructor(
    private portSvc: PortfolioService,
    private currentRoute: ActivatedRoute,
    private router: Router,
    private proSvc: ProfileService
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
            this.userID = this.port.user.id;
            console.log(this.userID);
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
  createPortfolio(createForm: NgForm) {
    this.portSvc.create(createForm, this.userID).subscribe(
      data => {
        this.router.navigateByUrl('/portfolio');
      },
      error => {
        console.error(
          'PortfolioComponent.createPortfolio(): Error creating new portfolio'
        );
        console.error(error);
      }
    );
  }
  showCreateForm() {
    this.bool = true;
  }
  disableTable() {
    this.port = null;
  }

  setEditPortfolio() {
    this.editPort = Object.assign({}, this.port);
  }

  updatePortfolio(portfolio: Portfolio) {
    this.portSvc.update(portfolio).subscribe(
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
  deletePortfolio(pid: number) {
    this.portSvc.destroy(this.userID, pid).subscribe(
      success => {
        this.router.navigateByUrl('/portfolio');
        this.loadPortfolios();
      },
      failure => {
        console.error('PortfolioComponent.deletePortfolio(): Error deleting portfolio');
        console.error(failure);
      }
    );
  }
}
