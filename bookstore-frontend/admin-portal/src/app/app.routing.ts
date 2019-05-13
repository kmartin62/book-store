import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { AddBookComponent } from './components/add-book/add-book.component';
import { BookListComponent } from './components/book-list/book-list.component';
import { ViewBookComponent } from './components/view-book/view-book.component';
import { EditBookComponent } from './components/edit-book/edit-book.component';


const appRoutes: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'addBook',
    component: AddBookComponent
  },
  {
    path: 'getAll',
    component: BookListComponent
  },
  {
    path: 'viewBook/:id',
    component: ViewBookComponent
  },
  {
    path: 'editBook/:id',
    component: EditBookComponent
  }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
