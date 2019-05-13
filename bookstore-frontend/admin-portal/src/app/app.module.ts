import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material';
import { MatToolbarModule } from '@angular/material/toolbar';
import { HttpModule } from '@angular/http';
import { routing } from './app.routing';
import { FormsModule } from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { AppRoutingModule } from './app-routing.module';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatInputModule } from '@angular/material/input';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';

import 'hammerjs';

import { AppComponent } from './app.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { LoginComponent } from './components/login/login.component';
import { AddBookComponent } from './components/add-book/add-book.component'
import { BookListComponent } from './components/book-list/book-list.component';

import { LoginService } from './service/login.service';
import { AddBookService } from './service/add-book.service';
import { UploadImageService } from './service/upload-image.service';
import { GetBookListService } from './service/get-book-list.service';
import { ViewBookComponent } from './components/view-book/view-book.component';


@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    LoginComponent,
    AddBookComponent,
    BookListComponent,
    ViewBookComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    HttpModule,
    MatSlideToggleModule,
    MatGridListModule,
    MatInputModule,
    FormsModule,
    MatSelectModule,
    routing
  ],
  providers: [
    LoginService,
    AddBookService,
    UploadImageService,
    GetBookListService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
