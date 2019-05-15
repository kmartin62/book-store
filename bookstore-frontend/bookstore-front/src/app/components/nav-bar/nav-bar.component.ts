import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  private loggedIn = false;

  constructor(private loginService: LoginService) { }

  logout(){
    this.loginService.logout().subscribe(
      res => {
        location.reload();
      },
      err => {
        console.log(err.text());
      }
    );
  }

  ngOnInit() {
    this.loginService.checkSession().subscribe(
      res => {
        this.loggedIn = true;
      },
      err => {
        console.log(err.text());
        this.loggedIn = false;
      }
    );
  }

}
