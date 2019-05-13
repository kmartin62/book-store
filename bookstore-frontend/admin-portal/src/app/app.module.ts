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
import { MatListModule } from '@angular/material/list';
import {MatDialogModule} from '@angular/material/dialog';

import 'hammerjs';

import { AppComponent } from './app.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { LoginComponent } from './components/login/login.component';
import { AddBookComponent } from './components/add-book/add-book.component'
import { BookListComponent, DialogResultExampleDialog } from './components/book-list/book-list.component';
import { ViewBookComponent } from './components/view-book/view-book.component';
import { EditBookComponent } from './components/edit-book/edit-book.component';

import { LoginService } from './service/login.service';
import { AddBookService } from './service/add-book.service';
import { UploadImageService } from './service/upload-image.service';
import { GetBookListService } from './service/get-book-list.service';
import { GetBookService } from './service/get-book.service';
import { EditBookService } from './service/edit-book.service';
import { RemoveBookService } from './service/remove-book.service';




@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    LoginComponent,
    AddBookComponent,
    BookListComponent,
    DialogResultExampleDialog,
    ViewBookComponent,
    EditBookComponent
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
    MatListModule,
    MatDialogModule,
    routing
  ],
  providers: [
    LoginService,
    AddBookService,
    UploadImageService,
    GetBookListService,
    GetBookService,
    EditBookService,
    RemoveBookService
  ],
  bootstrap: [AppComponent],
  entryComponents: [DialogResultExampleDialog],
})
export class AppModule { }
