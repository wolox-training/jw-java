package wolox.training;

import java.util.List;
import java.util.Optional;
import javax.validation.constraints.AssertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import wolox.training.factories.BookFactory;
import wolox.training.models.Book;
import wolox.training.repositories.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    private Book testBook;
    private Book testSaveBook;


    @Before
    public void setUp(){
        testBook = BookFactory.build();
        testSaveBook = BookFactory.build();
        testSaveBook = bookRepository.save(testSaveBook);
    }

    @Test
    public void whenCreateBookThenReturnBook(){
        //given
        Book bookSaved;


        //when
        bookSaved = bookRepository.save(testBook);

        //then
        Assertions.assertTrue(bookSaved != null);
        Assertions.assertEquals(testBook.getAuthor(),bookSaved.getAuthor());
        Assertions.assertEquals(testBook.getGenre(),bookSaved.getGenre());
        Assertions.assertEquals(testBook.getIsbn(),bookSaved.getIsbn());
    }

    @Test
    public void whenFindByIdThenReturnBook(){
        //given
        Book bookFound;


        //when
        bookFound = bookRepository.findById(testSaveBook.getId()).orElseGet(null);

        //then
        Assertions.assertTrue(bookFound != null);
        Assertions.assertEquals(testSaveBook.getAuthor(),bookFound.getAuthor());
    }

    @Test
    public void whenFindByPublisherGenreAndYearThenReturnBook(){
        //given
        List<Book> booksFound;


        //when
        booksFound = bookRepository.findByPublisherAndGenreAndYear(testSaveBook.getPublisher(),
                testSaveBook.getGenre(), testSaveBook.getYear()).orElseGet(null);
        //then
        Assertions.assertNotNull(booksFound);
        Assertions.assertTrue(booksFound.size() > 0);
    }

    @Test
    public void whenFindByPublisherGenreAndYearCustomThenReturnBook(){
        //given
        List<Book> booksFound;

        //when
        booksFound = bookRepository.findByPublisherGenreAndYearCustom(null,
                testSaveBook.getGenre(), testSaveBook.getYear()).orElseGet(null);
        //then
        Assertions.assertNotNull(booksFound);
        Assertions.assertTrue(booksFound.size() > 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateWithoutGenreThenThrowIllegalArgumentException(){
        testBook.setGenre(null);
        bookRepository.save(testBook);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateWithoutAuthorThenThrowIllegalArgumentException(){
        testBook.setAuthor(null);
        bookRepository.save(testBook);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateWithoutImageThenThrowIllegalArgumentException(){
        testBook.setImage(null);
        bookRepository.save(testBook);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateWithoutTitleThenThrowIllegalArgumentException(){
        testBook.setTitle(null);
        bookRepository.save(testBook);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateWithoutSubtitleThenThrowIllegalArgumentException(){
        testBook.setSubtitle(null);
        bookRepository.save(testBook);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateWithoutPublisherThenThrowIllegalArgumentException(){
        testBook.setPublisher(null);
        bookRepository.save(testBook);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateWithoutYearThenThrowIllegalArgumentException(){
        testBook.setYear(null);
        bookRepository.save(testBook);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateWithoutIsbn_thenThrowIllegalArgumentException(){
        testBook.setIsbn(null);
        bookRepository.save(testBook);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateWithNegativePages_thenThrowIllegalArgumentException(){
        testBook.setPages(-18);
        bookRepository.save(testBook);
    }
}
