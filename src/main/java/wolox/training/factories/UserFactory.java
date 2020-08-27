package wolox.training.factories;

import java.time.LocalDate;
import java.time.Month;
import java.util.Random;
import wolox.training.models.Book;
import wolox.training.models.Professor;
import wolox.training.models.Student;
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

    public static Student buildStudent(){
        Random random = new Random();

        Student student = new Student();
        student.setUsername("student"+random.nextInt());
        student.setName("student_"+random.nextInt());
        student.setBirthdate(LocalDate.of(1990, Month.JUNE, 27));

        return student;
    }

    public static Professor buildProfessor(){
        Random random = new Random();

        Professor professor = new Professor();
        professor.setUsername("student"+random.nextInt());
        professor.setName("student_"+random.nextInt());
        professor.setBirthdate(LocalDate.of(1990, Month.JUNE, 27));

        return professor;
    }

}
