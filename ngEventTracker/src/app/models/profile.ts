export class Profile {
  id: number;
  firstName: string;
  lastName: string;
  city: string;
  state: string;
  picUrl: string;
  bio: string;

  constructor(
    id?: number,
    firstName?: string,
    lastName?: string,
    city?: string,
    state?: string,
    picUrl?: string,
    bio?: string
  ) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.city = city;
    this.state = state;
    this.picUrl = picUrl;
    this.bio = bio;
  }
}
