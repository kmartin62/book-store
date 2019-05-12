import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../service/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  private isLoggedIn = false;

  constructor(private loginService: LoginService, private router: Router) { }

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

  this.router.navigate(['/']);
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
