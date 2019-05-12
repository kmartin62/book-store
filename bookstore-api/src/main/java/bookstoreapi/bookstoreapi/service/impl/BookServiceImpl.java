package bookstoreapi.bookstoreapi.service.impl;

import bookstoreapi.bookstoreapi.model.Book;
import bookstoreapi.bookstoreapi.repository.BookRepository;
import bookstoreapi.bookstoreapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by @kmartin62
 */
@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    private List<Book> activeBookList(List<Book> books){
        List<Book> activeBookList = new ArrayList<>();

        for(Book book: books){
            if(book.isActive()){
                activeBookList.add(book);
            }
        }

        return activeBookList;
    }

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        List<Book> bookList = (List<Book>) bookRepository.findAll();

        return activeBookList(bookList);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findByTitle(String title) {
        List<Book> bookList = bookRepository.findByTitleContaining(title);

        return activeBookList(bookList);
    }

    @Override
    public void removeById(Long id) {
        bookRepository.deleteById(id);
    }
}
