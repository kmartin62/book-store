import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login.service';
import { UserService } from '../../services/user.service';
import { AppConst } from '../../constants/app-const';

@Component({
  selector: 'app-my-account',
  templateUrl: './my-account.component.html',
  styleUrls: ['./my-account.component.css']
})
export class MyAccountComponent implements OnInit {

  private serverPath = AppConst.serverPath;
  private loginError: boolean = false;
  private loggedIn: boolean = false;
  private credential = {'username':'', 'password': ''};

  private emailSent: boolean = false;
  private usernameExists: boolean;
  private emailExists: boolean;
  private username: string;
  private email: string;

  private forgetPasswordEmailSent: boolean;
  private emailNotExists: boolean;
  private recoverEmail: string;


  constructor(private loginService: LoginService, private userService: UserService,
  private router: Router) { }

  onLogin(){
    this.loginService.sendCredential(this.credential.username, this.credential.password).subscribe(
      res => {
        localStorage.setItem("xAuthToken", res.json().token);
        this.loggedIn = true;
        location.reload();
        this.router.navigate(['/home']);
      },
      err => {
        console.log(err);
        this.loggedIn = false;
        this.loginError = true;
      }
    )
  }

  onNewAccount(){
    this.usernameExists = false;
    this.emailExists = false;
    this.emailSent = false;

    this.userService.newUser(this.username, this.email).subscribe(
      res => {
        this.emailSent = true;
      },
      err => {
        console.log(err.text());
        let errorMessage = err.text();
        if(errorMessage === "usernameExists") {
          this.usernameExists = true;
        }

        if(errorMessage === "emailExists") {
          this.emailExists = true;
        }
      }
    );
  }

  onForgetPassword() {
    this.forgetPasswordEmailSent = false;
    this.emailNotExists = false;

    this.userService.retrievePassword(this.recoverEmail).subscribe(
      res => {
        this.emailSent = true;
      },
      err => {
        let errorMessage = err.text();

        if(errorMessage === "emailExists") {
          this.emailExists = true;
        }
      }
    )
  }

  ngOnInit() {
    this.loginService.checkSession().subscribe(
      res => {
        this.loggedIn = true;
      },
      err => {
        this.loggedIn = false;
      }
    )
  }

}
