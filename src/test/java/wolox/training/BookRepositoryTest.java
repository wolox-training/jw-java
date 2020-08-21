package wolox.training;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import wolox.training.models.Book;
import wolox.training.repositories.BookRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
public class BookRepositoryTest {

    private BookRepository bookRepository;

    @Test
    public void whenFindById_ThenReturnBook(){
        //given
        Book book = new Book();
        book.setGenre("Fantasy");
        book.setAuthor("Juan Camilo");
        book.setImage("image.jpg");
        book.setTitle("Libro test");
        book.setSubtitle("test");
        book.setPublisher("Tesstpublisher");
        book.setPages(100);
        book.setYear("2020");
        book.setIsbn("12345678");

        Book bookSaved = bookRepository.save(book);

        Optional<Book> bookFound = bookRepository.findById(bookSaved.getId());

        Assertions.assertThat(bookFound).isPresent();


    }
}
