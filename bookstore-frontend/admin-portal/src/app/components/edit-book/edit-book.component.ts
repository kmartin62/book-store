import { Component, OnInit } from '@angular/core';
import { UploadImageService } from '../../service/upload-image.service';
import { Book } from '../../models/book';
import { Params, ActivatedRoute, Router } from '@angular/router';
import { GetBookService } from '../../service/get-book.service';
import { EditBookService } from '../../service/edit-book.service';

@Component({
  selector: 'app-edit-book',
  templateUrl: './edit-book.component.html',
  styleUrls: ['./edit-book.component.css']
})
export class EditBookComponent implements OnInit {

  private bookId: number;
  private book: Book = new Book();
  private bookUpdated: boolean;

  constructor(private uploadImageService: UploadImageService,
    private editBookService: EditBookService, private getBookService: GetBookService,
    private route: ActivatedRoute, private router: Router) { }

  onSubmit() {
    this.editBookService.sendBook(this.book).subscribe(
      res => {
        this.uploadImageService.modify(JSON.parse(JSON.parse(JSON.stringify(res))._body).id);
        this.bookUpdated = true;
      },
      err => {
        console.log(err);
      }
    );
  }

  ngOnInit() {
    this.route.params.forEach((params: Params) => {
      this.bookId = Number.parseInt(params['id']);
    });

    this.getBookService.getBook(this.bookId).subscribe(
      res => {
        this.book = res.json();
      },
      err => {
        console.log(err);
      }
    );
  }

}
