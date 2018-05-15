import {User} from './User';

export class UserAuthService {
  users: User[] = [
    new User('253233', 'test', 'Student'),
    new User('test2', 'test', 'Teacher'),
  ];

  private loggedUser: User;

  authorize(index: string, password: string) {
    for (const user of this.users) {
      if (user.index === index && user.password === password) {
        this.loggedUser = user;
        return true;
      }
    }
    return false;
  }

  getUserIndex() {
    if (this.loggedUser != null) {
      return this.loggedUser.index;
    }
  }


}
