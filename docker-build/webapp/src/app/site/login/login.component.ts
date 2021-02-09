import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { UserService } from '../user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from '../auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: any;
  log: boolean;
  validation: boolean;
  anonymousUser: String;
  menuId: any = 0;


  constructor(private userSer: UserService,
    private authSer: AuthService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit() {
    this.login = new FormGroup({
      'username': new FormControl(),
      'password': new FormControl()
    });
    this.log = false;
    this.validation = false;
    this.menuId = this.authSer.getAnonymousMenuItemId();
    /* this.route.paramMap.subscribe(params => {
      this.anonymousUser = params.get('userAnonymous');
    }); */
  }
  
  ngOnDestroy() {
    this.authSer.setAnonymousMenuItemId(0);
  }

  loggingIn(loginData) {

    this.userSer.authenticate(loginData.username, loginData.password)
      .subscribe((response) => {
        this.userSer.setToken(response.token);
        this.userSer.setRole(response.role);
        this.userSer.setName(response.user);
        this.authSer.login();
        this.log = true;

        if (this.log == true) {
          //console.log(this.userSer.getRole());
          this.validation = false;
          this.router.navigate(['menu-list']);
        }
        else {
          this.validation = true;
        }
      },
        (error) => {
          this.validation = true;
        });

    /* this.log = this.user.logVerify(data);
    this.auth.login();
    if(this.log == true) {
    this.validation = false;
    this.router.navigate(['menu-list']);
    }
    else {
      this.validation = false;
    } */
  }

  userStatus() {
    return this.authSer.currentRole();
  }

}
