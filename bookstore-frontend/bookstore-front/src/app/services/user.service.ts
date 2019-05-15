import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { AppConst } from '../constants/app-const';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private serverPath = AppConst.serverPath;

  constructor(private http: Http) { }

  updateUserInfo(user: User, newPassword: string) {
    let url = this.serverPath + "/user/updateUserInfo";
    let userInfo = {
      "id" : user.id,
      "firstName" : user.firstName,
      "lastName" : user.lastName,
      "username" : user.username,
      "currentPassword" : user.password,
      "email" : user.email,
      "newPassword" : "newPassword"
    };

    let tokenHeader = new Headers({
      'Content-Type' : 'application/json',
      'x-auth-token' : localStorage.getItem("xAuthToken")
    });
    return this.http.post(url, JSON.stringify(userInfo), {headers:tokenHeader});
  }

  newUser(username: string, password: string, email: string){
    let url = this.serverPath+'/user/newUser';
    let user = {
      "username" : username,
      "password" : password,
      "email" : email
    };

    let tokenHeader = new Headers({
      'Content-Type' : 'application/json',
      'x-auth-token' : localStorage.getItem('xAuthToken')
    });

    return this.http.post(url, JSON.stringify(user), {headers: tokenHeader});
  }

  getCurrentUser() {
    let url = this.serverPath+'/user/getCurrentUser';

    let tokenHeader = new Headers({
      'Content-Type' : 'application/json',
      'x-auth-token' : localStorage.getItem('xAuthToken')
    });

    return this.http.get(url, {headers : tokenHeader});
  }

}
