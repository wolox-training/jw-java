package wolox.training.factories;

import java.time.LocalDate;
import java.time.Month;
import java.util.Random;
import wolox.training.models.Book;
import wolox.training.models.User;

public class UserFactory {

    public static User build(){
        Random random = new Random();

        User user = new User();
        user.setUsername("user"+random.nextInt());
        user.setName("user_"+random.nextInt());
        user.setBirthdate(LocalDate.of(1953, Month.JUNE, 27));

        return user;
    }

}
