import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AccountService } from 'src/app/services/account.service';
import { Account } from 'src/app/models/account';

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
    console.log('in account ts init');
    this.loadAccounts();
    console.log('after load accounts');
    console.log(this.acct);
    console.log(this.currentRoute.url);
    if (!this.acct && this.currentRoute.snapshot.paramMap.get('id')) {
      console.log('in if onInit');
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
    console.log('in updateAccount()');
    console.log(account);
    this.acctSvc.update(account).subscribe(
      data => {
        console.log('inside call to update in acctSvc');
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
        console.log('AccountComponent.deleteAccount(): Error deleting account');
        console.log(failure);
      }
    );
  }
}
