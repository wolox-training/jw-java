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
import wolox.training.controllers.UserController;
import wolox.training.exceptions.UserIdMismatchException;
import wolox.training.exceptions.UserNotFoundException;
import wolox.training.repositories.BookRepository;
import wolox.training.repositories.UserRepository;
import wolox.training.utils.Constants;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private BookRepository bookRepository;

    private String requestJson;

    @Before
    public void setUp(){
        requestJson ="{\n"
                + "    \"username\": \"prueba\",\n"
                + "    \"name\":\"Prueba\",\n"
                + "    \"birthdate\":\"1970-07-25\"\n"
                + "}";
    }

    @Test(expected = UserNotFoundException.class)
    public void whenFindByIdWithUknownIdThenThrownException() throws Throwable {
        try{
            mockMvc.perform(MockMvcRequestBuilders.get("/api/users/90")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().isNotFound());
        }catch (NestedServletException ex){
            throw ex.getCause();
        }


    }

    @Test
    public void whenPostThenReturnCreated() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/api/users")
                .contentType(Constants.APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isCreated());


    }

    @Test(expected =  UserNotFoundException.class)
    public void whenDeleteWithUnknownIdThenReturnException() throws Throwable {
        try {

            mockMvc.perform(MockMvcRequestBuilders.delete("/api/users/99")
                    .contentType(Constants.APPLICATION_JSON_UTF8)
                    .content(requestJson))
                    .andExpect(MockMvcResultMatchers.status().isCreated());

        }catch (NestedServletException ex){
            throw ex.getCause();
        }
    }

    @Test(expected =  UserIdMismatchException.class)
    public void whenUpdateWithUnknownIdThenReturnException() throws Throwable {
        try {

            mockMvc.perform(MockMvcRequestBuilders.put("/api/users/99")
                    .contentType(Constants.APPLICATION_JSON_UTF8)
                    .content(requestJson))
                    .andExpect(MockMvcResultMatchers.status().isCreated());

        }catch (NestedServletException ex){
            throw ex.getCause();
        }
    }

}
