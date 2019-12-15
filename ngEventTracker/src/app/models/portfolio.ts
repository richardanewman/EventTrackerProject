import { Profile } from 'src/app/models/profile';

export class Portfolio {

  id: number;
  portfolioName: string;
  user: Profile;

  constructor(
    id?: number,
    portfolioName?: string,
    user?: Profile
  ) {
    this.id = id;
    this.portfolioName = portfolioName;
    this.user = user;
  }

  set portUser(folioUser: Profile) {
    this.user = folioUser;
  }

}
