import { Component, OnInit } from '@angular/core';
import { Book } from '../../models/book';
import { AddBookService } from '../../service/add-book.service';
import { UploadImageService } from '../../service/upload-image.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  private newBook: Book = new Book();
  private bookAdded: boolean;

  constructor(private addBookService: AddBookService, private uploadImageService: UploadImageService) { }

  onSubmit(){
    this.addBookService.sendBook(this.newBook).subscribe(
      res => {
        this.uploadImageService.upload(JSON.parse(JSON.parse(JSON.stringify(res))._body).id);
        this.bookAdded = true;
        this.newBook = new Book();
        this.newBook.category = "Management";
        this.newBook.language = "english";
        this.newBook.format = "Paperback";
      },
      err => {
        console.log(err);
      }
    )
  }

  ngOnInit() {
    this.bookAdded = false;
    this.newBook.active = true;
    this.newBook.category = "Management";
    this.newBook.language = "english";
    this.newBook.format = "Paperback";
  }

}
