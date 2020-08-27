package wolox.training;

import com.google.common.collect.Iterables;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import wolox.training.factories.UserFactory;
import wolox.training.models.Student;
import wolox.training.repositories.StudentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class StudentRepositoryTest {


    @Autowired
    private StudentRepository studentRepository;

    Student student;
    @Before
    public void setUp(){
        student = UserFactory.buildStudent();
        student.setName("Student1");
        student.setYear("11");
        studentRepository.save(student);

    }

    @Test
    public void whenFindAllThenReturnStudentsIterable(){
        Iterable<Student> students = studentRepository.findAll();
        Assertions.assertTrue(Iterables.size(students) > 0);
    }

}
