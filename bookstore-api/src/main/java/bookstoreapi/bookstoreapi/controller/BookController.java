package bookstoreapi.bookstoreapi.controller;

import bookstoreapi.bookstoreapi.model.Book;
import bookstoreapi.bookstoreapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Created by @kmartin62
 */
@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book){
        return bookService.save(book);
    }

    @RequestMapping(value = "/add/image", method = RequestMethod.POST)
    public ResponseEntity upload(@RequestParam("id") Long id, HttpServletResponse response, HttpServletRequest request){
        try {
            Optional<Book> book = bookService.findById(id);
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
            MultipartFile multipartFile = multipartHttpServletRequest.getFile(iterator.next());
            String fileName = id+".png";

            byte[] bytes = multipartFile.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/book/"+fileName)));
            stream.write(bytes);
            stream.close();

            return new ResponseEntity("Upload success", HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity("upload failed", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/update/image", method = RequestMethod.POST)
    public ResponseEntity updateImage(@RequestParam("id") Long id, HttpServletResponse response, HttpServletRequest request){
        try {
            Optional<Book> book = bookService.findById(id);
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
            MultipartFile multipartFile = multipartHttpServletRequest.getFile(iterator.next());
            String fileName = id+".png";

            Files.delete(Paths.get("src/main/resources/static/image/book/"+fileName));

            byte[] bytes = multipartFile.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/book/"+fileName)));
            stream.write(bytes);
            stream.close();

            return new ResponseEntity("Upload success", HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity("upload failed", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/getAll")
    public List<Book> getAll(){
        return bookService.findAll();
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ResponseEntity remove(@RequestBody String id){
        bookService.removeById(Long.parseLong(id));

        return new ResponseEntity("Successful", HttpStatus.OK);
    }

    @RequestMapping("{id}")
    public Optional<Book> getBook(@PathVariable("id") Long id) throws IOException {
        Optional<Book> book = bookService.findById(id);
        String fileName = id+".png";

        Files.delete(Paths.get("src/main/resources/static/image/book/"+fileName));
        return book;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Book updateBook(@RequestBody Book book) {
        return bookService.save(book);
    }
}
