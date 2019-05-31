import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { routing } from './app.routing';
import { MatButtonModule } from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { AlertModule } from 'ngx-bootstrap';
import { MatTabsModule } from '@angular/material/tabs';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { DataTableModule } from "angular2-datatable";
import { DataFilterPipe } from './components/book-list/data-filter.pipe';

import 'hammerjs';

import { LoginService } from './services/login.service';
import { UserService } from './services/user.service';
import { PaymentService } from './services/payment.service';
import { ShippingService } from './services/shipping.service';
import { BookService } from './services/book.service';
import { CartService } from './services/cart.service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { MyAccountComponent } from './components/my-account/my-account.component';
import { MyProfileComponent } from './components/my-profile/my-profile.component';
import { BookListComponent } from './components/book-list/book-list.component';
import { BookDetailComponent } from './components/book-detail/book-detail.component';
import { ShoppingCartComponent } from './components/shopping-cart/shopping-cart.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavBarComponent,
    MyAccountComponent,
    MyProfileComponent,
    BookListComponent,
    DataFilterPipe,
    BookDetailComponent,
    ShoppingCartComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpModule,
    routing,
    MatButtonModule,
    FormsModule,
    AlertModule.forRoot(),
    MatTabsModule,
    BrowserAnimationsModule,
    MatProgressSpinnerModule,
    DataTableModule
  ],
  providers: [
    LoginService,
    UserService,
    PaymentService,
    ShippingService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
