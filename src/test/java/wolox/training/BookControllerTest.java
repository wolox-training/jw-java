package wolox.training;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.util.NestedServletException;
import wolox.training.controllers.BookController;
import wolox.training.exceptions.BookIdMismatchException;
import wolox.training.exceptions.BookNotFoundException;
import wolox.training.factories.BookFactory;
import wolox.training.models.Book;
import wolox.training.repositories.BookRepository;
import wolox.training.utils.Constants;
import wolox.training.utils.Util;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepository;

    private Book testBook;

    String requestJson;

    @Before
    public void setUp(){
        testBook = BookFactory.build();
        requestJson = Util.objectToJsonString(testBook);
    }

    @Test(expected = BookNotFoundException.class)
    public void whenFindByIdWithUknownIdThenThrownException() throws Throwable {
        try{
            mockMvc.perform(MockMvcRequestBuilders.get("/api/books/90")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isNotFound());
        }catch (NestedServletException ex){
            throw ex.getCause();
        }


    }

    @Test
    public void whenPostThenReturnCreated() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/api/books/")
                .contentType(Constants.APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());


    }

    @Test(expected =  BookNotFoundException.class)
    public void whenDeleteWithUnknownIdThenReturnException() throws Throwable {
        try {

            mockMvc.perform(MockMvcRequestBuilders.delete("/api/books/99")
                    .contentType(Constants.APPLICATION_JSON_UTF8)
                    .content(requestJson))
                    .andExpect(MockMvcResultMatchers.status().isCreated());

        }catch (NestedServletException ex){
            throw ex.getCause();
        }
    }

    @Test(expected =  BookIdMismatchException.class)
    public void whenUpdateWithUnknownIdThenReturnException() throws Throwable {
        try {

            mockMvc.perform(MockMvcRequestBuilders.put("/api/books/99")
                    .contentType(Constants.APPLICATION_JSON_UTF8)
                    .content(requestJson))
                    .andExpect(MockMvcResultMatchers.status().isCreated());

        }catch (NestedServletException ex){
            throw ex.getCause();
        }
    }


}
