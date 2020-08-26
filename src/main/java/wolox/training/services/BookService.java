package wolox.training.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<Book> findByAllFieldsPaging( String genre, String author, String image,
            String title, String subtitle, String publisher, String year, Integer pages,
            String isbn, String startYear, String endYear, Integer page, Integer size,
            String sortBy, String order){

        Pageable pageable = PageRequest.of(page, size,
                order.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() :
                        Sort.by(sortBy).descending());

        return bookRepository.findByAllFieldsPaging(genre, author, image, title, subtitle, publisher,
                year, pages, isbn, startYear, endYear, pageable).orElse(new ArrayList<Book>());
    }
}
