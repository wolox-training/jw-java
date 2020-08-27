package wolox.training.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wolox.training.models.Book;
import wolox.training.models.DTO.BookDTO;
import wolox.training.repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private OpenLibraryService openLibraryService;

    public Optional<Book> findByIsbn(String isbn) throws Exception {
       Optional<BookDTO> bookDTOOptional = openLibraryService.bookInfo(isbn);
       return bookDTOOptional.map(bookDTO -> {
             Book book = getBookModelFromDTO(bookDTO);
             bookRepository.save(book);
             return book;
       });
    }

    public Book getBookModelFromDTO(BookDTO bookDTO){
        Book book = new Book(bookDTO);
        return book;
    }
}
