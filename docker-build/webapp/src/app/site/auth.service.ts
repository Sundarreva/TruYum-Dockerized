import { Injectable } from '@angular/core';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  userRole: string = "anonymous";
  itemId: number = 0;
  loggedIn: boolean = false;

  constructor(private userSer:UserService, ) { }

  login() {
    this.loggedIn = true;
  }
  
  logout() {
    this.userRole = "anonymous";
    this.userSer.setToken(null);
    this.userSer.setRole(this.userRole);
    this.loggedIn = false;
  }

  isLoggedIn(){
    return this.loggedIn;
  }

  userCustomer() {
    this.userRole = "customer";
  }

  userAdmin() {
    this.userRole = "admin";
  }

  currentRole() {
    return this.userRole;
  }

  setAnonymousMenuItemId(menuItemId) {
    this.itemId = menuItemId;
  }

  getAnonymousMenuItemId() {
    return this.itemId;
  }


}
