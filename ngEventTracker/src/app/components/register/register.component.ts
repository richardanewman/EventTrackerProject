import { Router } from '@angular/router';
import { AccountService } from 'src/app/services/account.service';
import { Component, OnInit } from '@angular/core';
import { Account } from 'src/app/models/account';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  newAccount: Account = new Account();

  constructor(
    private acctSvc: AccountService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  register(newAccount: Account) {
    this.acctSvc.create(newAccount).subscribe(
      data => {
        this.router.navigateByUrl('/account');
      },
      error => {
        console.error('RegisterComponent.register(): Error creating new user');
        console.error(error);
        }
    );
  }
}
