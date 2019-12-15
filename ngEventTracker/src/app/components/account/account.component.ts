import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Account } from 'src/app/models/account';
import { AccountService } from 'src/app/services/account.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  accounts: Account[] = [];

  acct = null;

  editAccount: Account = null;

  constructor(
    private acctSvc: AccountService,
    private currentRoute: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.loadAccounts();
    if (!this.acct && this.currentRoute.snapshot.paramMap.get('id')) {
      return this.acctSvc
        .showAccount(this.currentRoute.snapshot.paramMap.get('id'))
        .subscribe(
          data => {
            this.acct = data;
          },
          err => {
            console.error(err);
            this.router.navigateByUrl('not-found');
          }
        );
    }
  }

  loadAccounts() {
    this.acctSvc.index().subscribe(
      data => {
        this.accounts = data;
      },
      err => {
        console.error('Error in loadAccounts()');
        console.error(err);
      }
    );
  }
  disableTable() {
    this.acct = null;
  }

  setEditAccount() {
    this.editAccount = Object.assign({}, this.acct);
  }
  updateAccount(account: Account) {
    this.acctSvc.update(account).subscribe(
      data => {
        this.loadAccounts();
        this.editAccount = null;
        this.acct = null;
      },
      err => {
        console.error('Error in updateAccount()');
        console.error(err);
      }
    );
  }
  deleteAccount(id: number) {
    this.acctSvc.destroy(id).subscribe(
      success => {
        this.loadAccounts();
      },
      failure => {
        console.error('AccountComponent.deleteAccount(): Error deleting account');
        console.error(failure);
      }
    );
  }
}
