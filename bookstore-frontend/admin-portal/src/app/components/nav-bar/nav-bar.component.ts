import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../service/login.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  private isLoggedIn = false;

  constructor(private loginService: LoginService) { }

  toggleDisplay(){
    this.isLoggedIn = !this.isLoggedIn;
}

logout(){
  this.loginService.logout().subscribe(
    res => {
      location.reload();
    },
    err => {
      console.log(err);
    }
  );
}

  ngOnInit() {
    this.loginService.checkSession().subscribe(
      res => {
        this.isLoggedIn = true;
      },
      err => {
        this.isLoggedIn = false;
      }
    );
  }

}
