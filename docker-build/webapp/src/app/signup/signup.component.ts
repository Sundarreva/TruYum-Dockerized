import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { UserService } from '../site/user.service';
import { Router } from '@angular/router';
import { User } from '../site/user-interface';


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signup: any;
  error: any = false;

  constructor(private userSer: UserService, private router: Router) { }

  ngOnInit() {
    this.signup = new FormGroup({
      'username' : new FormControl(),
      'fname' : new FormControl (),
      'lname' : new FormControl (),
      'password' : new FormControl(),
      'confirmpassword' : new FormControl()
    });
  }


  signIn(userData) {
    let user: User = {
      userName: userData.username,
      firstName: userData.fname,
      lastName: userData.lname,
      password: userData.password
    }
    this.userSer.createUser(user).subscribe((data)=>{
      if(!this.error)
      this.router.navigate(['login']);  
    },
      (error) => {
        this.error = true;
      }
    );

  }

}
