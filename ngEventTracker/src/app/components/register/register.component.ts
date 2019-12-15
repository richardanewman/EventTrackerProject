import { ProfileService } from './../../services/profile.service';
import { Router } from '@angular/router';
import { AccountService } from 'src/app/services/account.service';
import { Component, OnInit } from '@angular/core';
import { Account } from 'src/app/models/account';
import { Profile } from 'src/app/models/profile';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  newAccount: Account = new Account();
  newProfile: Profile = new Profile();

  constructor(
    private acctSvc: AccountService,
    private router: Router,
    private profSvc: ProfileService
  ) { }

  ngOnInit() {
  }

  register(newAccount: Account, newProfile: Profile) {
    this.acctSvc.create(newAccount, newProfile).subscribe(
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
