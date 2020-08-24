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
import wolox.training.factories.BookFactory;
import wolox.training.factories.UserFactory;
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
        testBook = BookFactory.build();
        bookRepository.save(testBook);

        userTest = UserFactory.build();
        userTest.addBook(testBook);

        userSaveTest = UserFactory.build();
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
