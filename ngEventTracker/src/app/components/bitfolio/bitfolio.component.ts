import { ProfileService } from 'src/app/services/profile.service';
import { Component, OnInit } from '@angular/core';
import { Profile } from 'src/app/models/profile';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-bitfolio',
  templateUrl: './bitfolio.component.html',
  styleUrls: ['./bitfolio.component.css']
})
export class BitfolioComponent implements OnInit {

  profiles: Profile[] = [];
  pro: Profile = null;
  editProfile: Profile = null;

  constructor(
    private proSvc: ProfileService,
    private currentRoute: ActivatedRoute
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
        console.log('BitfolioComponent.loadProfiles(): Error getting all profiles');
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
        console.error('BitfolioComponent: Error in updateProfile()');
        console.error(error);
      }
    );
  }

}
