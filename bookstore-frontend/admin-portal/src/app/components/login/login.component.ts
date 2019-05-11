import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private credential = {'username':'', 'password':''};
  private isLoggedIn = false;

  constructor(private loginService: LoginService) { }

  onSubmit(){
    this.loginService.sendCredential(this.credential.username, this.credential.password).subscribe(
      res => {
        console.log(res);
        localStorage.setItem("xAuthToken", res.json().token);
        this.isLoggedIn = true;
        location.reload();
      },
      err => {
        console.log(err);
      }
    );
  }

  ngOnInit() {
  }

}
