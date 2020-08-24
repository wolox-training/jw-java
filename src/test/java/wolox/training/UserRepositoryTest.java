package wolox.training;

import java.time.LocalDate;
import java.time.Month;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import wolox.training.exceptions.BookAlreadyOwnedException;
import wolox.training.models.Book;
import wolox.training.models.User;
import wolox.training.repositories.BookRepository;
import wolox.training.repositories.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    private User userTest;
    private User userSaveTest;

    private Book testBook;

    @Before
    public void setUp(){
        testBook = new Book();
        testBook.setGenre("Fantasy");
        testBook.setAuthor("Juan Camilo");
        testBook.setImage("image.jpg");
        testBook.setTitle("Libro test");
        testBook.setSubtitle("test");
        testBook.setPublisher("Tesstpublisher");
        testBook.setPages(100);
        testBook.setYear("2020");
        testBook.setIsbn("12345678");
        bookRepository.save(testBook);

        userTest = new User();
        userTest.setUsername("test1");
        userTest.setName("TestUno");
        userTest.setBirthdate(LocalDate.of(1953, Month.JUNE, 27));
        userTest.addBook(testBook);

        userSaveTest = new User();
        userSaveTest.setUsername("test2");
        userSaveTest.setName("TestDos");
        userSaveTest.setBirthdate(LocalDate.of(1921, Month.JUNE, 17));
        userSaveTest.addBook(testBook);
        userRepository.save(userSaveTest);

    }

    @Test
    public void whenCreateUserThenReturnUser(){
        //given
        User userSaved;


        //when
        userSaved = userRepository.save(userTest);

        //then
        Assertions.assertTrue(userSaved != null);
        Assertions.assertEquals(userTest.getUsername(),userTest.getUsername());
        Assertions.assertEquals(userTest.getName(),userTest.getName());
        Assertions.assertEquals(userTest.getBirthdate(),userTest.getBirthdate());
    }

    @Test
    public void whenFindByIdThenReturnUser(){
        //given
        User userFound;


        //when
        userFound = userRepository.findById(userSaveTest.getId()).orElseGet(null);

        //then
        Assertions.assertTrue(userFound != null);
        Assertions.assertEquals(userSaveTest.getUsername(),userSaveTest.getUsername());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateWithoutUsernameThenThrowIllegalArgumentException(){
        userTest.setUsername(null);
        userRepository.save(userTest);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateWithoutNameThenThrowIllegalArgumentException(){
        userTest.setName(null);
        userRepository.save(userTest);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCreateWithoutBirthdateThenThrowIllegalArgumentException(){
        userTest.setBirthdate(null);
        userRepository.save(userTest);
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateWithNullBooksThenThrowNullPointerException(){
        userTest.setBooks(null);
        userRepository.save(userTest);
    }

    @Test(expected = BookAlreadyOwnedException.class)
    public void whenAddBookWithExistingBookThenThrowBookAlreadyOwnedException(){
        userTest.addBook(testBook);
    }
}
