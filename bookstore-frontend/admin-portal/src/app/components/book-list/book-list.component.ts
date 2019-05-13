import { Component, OnInit } from '@angular/core';
import { Book } from '../../models/book';
import { Router } from '@angular/router';
import { LoginService } from '../../service/login.service';
import { GetBookListService } from '../../service/get-book-list.service';
// import { MatDialogModule, MatDialogRef } from '@angular/material/dialog';
import { RemoveBookService } from '../../service/remove-book.service';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  private selectedBook: Book;
  private checked: boolean;
  private bookList: Book[];
  private allChecked: boolean;
  private removeBookList: Book[] = new Array();

  constructor(private getBookListService: GetBookListService, private router: Router,
    public dialog: MatDialog, private removeBookService: RemoveBookService) { }

  onSelect(book: Book){
    this.selectedBook = book;
    this.router.navigate(['/viewBook', this.selectedBook.id]);
  }

  openDialog(book: Book){
    let dialogRef = this.dialog.open(DialogResultExampleDialog);
    dialogRef.afterClosed().subscribe(
      res => {
          console.log(res);
          if(res == "yes") {
            this.removeBookService.sendBook(book.id).subscribe(
              res => {
                location.reload();
              },
              err => {
                console.log(err);
              }
            )
          }
      },
      err => {
        console.log(err);
      }
    );
  }

  updateRemoveBookList(checked: boolean, book: Book) {
    if(checked){
      this.removeBookList.push(book);
    } else {
      this.removeBookList.splice(this.removeBookList.indexOf(book), 1);
    }
  }

  updateSelected(checked:boolean) {
    if(checked){
      this.allChecked = true;
      this.removeBookList = this.bookList.slice();
    } else {
      this.allChecked = false;
      this.removeBookList = [];
    }
  }

  removeSelectedBooks(){
    let dialogRef = this.dialog.open(DialogResultExampleDialog);
    dialogRef.afterClosed().subscribe(
      res => {
          console.log(res);
          if(res == "yes") {
            for(let book of this.removeBookList) {
              this.removeBookService.sendBook(book.id).subscribe(
                res => {
                  location.reload();
                },
                err => {
                  console.log(err);
                }
              );
              }
              this.getBookListService.getBookList().subscribe(
                res => {
                  console.log(res.json());
                  this.bookList = res.json();
                },
                err => {
                  console.log(err);
                }
              );
              // location.reload();
            }
      },
      err => {
        console.log(err);
      }
    );
  }

  ngOnInit() {
    this.getBookListService.getBookList().subscribe(
      res => {
        console.log(res.json());
        this.bookList = res.json();
      },
      err => {
        console.log(err);
      }
    );
  }

}

@Component({
  selector: 'dialog-result-example-dialog',
  templateUrl: './dialog-result-example-dialog.html'
})
export class DialogResultExampleDialog{
  constructor(public dialogRef: MatDialogRef<DialogResultExampleDialog>){}
}
