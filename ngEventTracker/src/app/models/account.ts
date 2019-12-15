export class Account {
  firstName: string;
  lastName: string;
  id: number;
  email: string;
  username: string;
  password: string;


  constructor(
    firstName?: string,
    lastName?: string,
    id?: number,
    email?: string,
    username?: string,
    password?: string,

  ) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
    this.email = email;
    this.username = username;
    this.password = password;

  }
}
