import { Injectable } from '@angular/core';
import { User } from './user-interface';
import { AuthService } from './auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  baseUrl = environment.baseUrl;

  private authenticationApiUrl = this.baseUrl+'authentication/truyum/authentication';
  private token: string;
  
  usersignup: User[];
  currentUserName: string;
  currentRole: string = "anonymous";
  httpOptions: any;
  

  constructor(private httpClient: HttpClient) {

    /* this.usersignup = [
      {
        userName: "John",
        firstName: "John",
        lastName: "Smith",
        password: "john"
      },
      {
        userName: "admin",
        firstName: "Admin",
        lastName: "Admin",
        password: "admin"
      }]; */

  }

  getAllUserList() {
    return this.usersignup;
  }

  getUsername() {
    return this.currentUserName;
  }

  createUser(userData) {
    /* let user: User = {
      userName: userData.username,
      firstName: userData.fname,
      lastName: userData.lname,
      password: userData.password
    } 
    this.usersignup.push(user);*/
    /* this.token = 'Bearer ' + this.getToken();
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': this.token
      })
    }; */
    //console.log(JSON.stringify(userData));
    return this.httpClient.post(this.baseUrl+"menu-item-service/truyum/signup",userData);

    
  }

  logVerify(loginData) {        
/*     for (let i = 0; i < this.usersignup.length; i++) {
      
      if (this.usersignup[i].userName == userData.username && this.usersignup[i].password == userData.password) {
        this.currentUserName = userData.username;
        this.authSer.userCustomer();
        if(userData.username == "admin" && userData.password == "admin") {
          this.authSer.userAdmin();
        }
        return true;
      }
    } */
    /* 
    console.log(loginData.username+"  "+loginData.password);
    this.authenticationService.authenticate( loginData.username, loginData.password )
    .subscribe((response) => {
      console.log(response);
      this.authenticationService.setToken(response.token);
      return true;
    },
    (error) => {
      console.log(error);
    });


    this.authSer.userRole = "anonymous";
    return false; */
  }

  authenticate(user: string, password: string): Observable<any> {
    let credential  = btoa(user + ':' + password);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic ' + credential);
    return this.httpClient.get(this.authenticationApiUrl, {headers})
  }

  public setToken(token: string) {
    this.token = token;
  }
  public getToken() {
    return this.token;
  }

  public setRole(role: string) {
    console.log(role);
    if(role == "ADMIN") {
      this.currentRole = "admin";  
    }
    else if(role == "USER") {
      this.currentRole = "customer";
    }
    else {
      this.currentRole = "anonymous";
    }
  
    //this.currentRole = role;
  }
  public getRole() {
    return this.currentRole;
  }

  public setName(name: string) {
    this.currentUserName = name;
  }
  public getName() {
    return this.currentUserName;
  }
  
}