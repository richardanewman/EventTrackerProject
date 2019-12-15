import { Profile } from './profile';

export class Account {
  id: number;
  user: Profile;
  email: string;
  username: string;
  password: string;


  constructor(
    id?: number,
    user?: Profile,
    email?: string,
    username?: string,
    password?: string,

  ) {
    this.id = id;
    this.user = user;
    this.email = email;
    this.username = username;
    this.password = password;

  }
}
