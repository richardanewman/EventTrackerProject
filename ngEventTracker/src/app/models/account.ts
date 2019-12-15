import { Profile } from './profile';

export class Account {
  id: number;
  profile: Profile;
  email: string;
  username: string;
  password: string;


  constructor(
    id?: number,
    profile?: Profile,
    email?: string,
    username?: string,
    password?: string,

  ) {
    this.id = id;
    this.profile = profile;
    this.email = email;
    this.username = username;
    this.password = password;

  }
}
