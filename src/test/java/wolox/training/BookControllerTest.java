package wolox.training;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.nio.charset.Charset;
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
import wolox.training.exceptions.BookNotFoundException;
import wolox.training.models.Book;
import wolox.training.repositories.BookRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepository;

    private Book testBook;

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset
            .forName("utf8"));


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
    }

    @Test(expected = BookNotFoundException.class)
    public void whenFindByIdWithUknownIdThenThrownBookNotFoundException() throws Throwable {
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

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(testBook);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/books/")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());


    }

    @Test
    public void whenDeleteWithUnknownIdThenReturnResponseStatusException() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(testBook);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/books/")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());


    }

}
