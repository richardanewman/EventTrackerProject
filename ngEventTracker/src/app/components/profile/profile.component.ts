import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Profile } from 'src/app/models/profile';
import { PortfolioService } from 'src/app/services/portfolio.service';
import { ProfileService } from 'src/app/services/profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  profiles: Profile[] = [];
  selectedProfile: Profile = null;
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
    if (!this.selectedProfile && this.currentRoute.snapshot.paramMap.get('id')) {
      return this.proSvc
        .showProfile(this.currentRoute.snapshot.paramMap.get('id'))
        .subscribe(
          data => {
            this.selectedProfile = data;
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
        console.error('ProfileComponent.loadProfiles(): Error getting all profiles');
        console.error(error);
      }
    );
  }

  disableTable() {
    this.selectedProfile = null;
  }

  setEditProfile() {
    this.editProfile = Object.assign({}, this.selectedProfile);
  }

  updateProfile(profile: Profile) {
    this.proSvc.update(profile).subscribe(
      data => {
        this.loadProfiles();
        this.editProfile = null;
        this.selectedProfile = null;
      },
      error => {
        console.error('ProfileComponent: Error in updateProfile()');
        console.error(error);
      }
    );
  }

}
