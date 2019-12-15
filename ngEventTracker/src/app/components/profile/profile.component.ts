import { ProfileService } from 'src/app/services/profile.service';
import { Component, OnInit } from '@angular/core';
import { Profile } from 'src/app/models/profile';
import { ActivatedRoute, Router } from '@angular/router';
import { PortfolioService } from 'src/app/services/portfolio.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  profiles: Profile[] = [];
  pro: Profile = null;
  editProfile: Profile = null;
  portProfile: Profile = null;

  constructor(
    private proSvc: ProfileService,
    private currentRoute: ActivatedRoute,
    private portSvc: PortfolioService,
    private router: Router
  ) { }

  ngOnInit() {
    this.loadProfiles();
    if (!this.pro && this.currentRoute.snapshot.paramMap.get('id')) {
      return this.proSvc
        .showProfile(this.currentRoute.snapshot.paramMap.get('id'))
        .subscribe(
          data => {
            this.pro = data;
          }
        );
    }
  }

  loadProfiles() {
    this.proSvc.index().subscribe(
      data => {
        this.profiles = data;
      },
      error => {
        console.log('ProfileComponent.loadProfiles(): Error getting all profiles');
        console.log(error);
      }
    );
  }

  disableTable() {
    this.pro = null;
  }

  setEditProfile() {
    this.editProfile = Object.assign({}, this.pro);
  }

  updateProfile(profile: Profile) {
    this.proSvc.update(profile).subscribe(
      data => {
        this.loadProfiles();
        this.editProfile = null;
        this.pro = null;
      },
      error => {
        console.error('ProfileComponent: Error in updateProfile()');
        console.error(error);
      }
    );
  }

}
