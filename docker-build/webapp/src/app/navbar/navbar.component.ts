import { Component, OnInit } from '@angular/core';
import { AuthService } from '../site/auth.service';
import { Router } from '@angular/router';
import { UserService } from '../site/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  userMask: string;

  constructor(private authSer: AuthService, private router: Router, private userSer: UserService) { }

  ngOnInit() {
    this.userMask = this.authSer.userRole;
    this.onLoad();
  }

  onLoad() {
    return this.userSer.getRole();
  }
  getName()
  {
    return this.userSer.getName();
  }

  logingOut() {
    this.authSer.logout();
    this.router.navigate(['login']);
  }

}
