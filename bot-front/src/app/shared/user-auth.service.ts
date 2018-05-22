import {User} from '../model/User';

export class UserAuthService {
  users: User[] = [
    new User('253233', 'test', 'Student'),
    new User('test2', 'test', 'Teacher'),
  ];

  private loggedUser: User;
  private authorized = false;
  isAuthorized() {
    return this.authorized;
  }

  authorize(index: string, password: string) {
    for (const user of this.users) {
      if (user.index === index && user.password === password) {
        this.loggedUser = user;
        this.authorized = true;
        return true;
      }
    }
    return false;
  }

  getUserIndex() {
    if (this.loggedUser != null) {
      return this.loggedUser.index;
    }
    return '';
  }

  getUserRole() {
    if (this.loggedUser != null) {
      return this.loggedUser.role;
    }
    return '';
  }


}
