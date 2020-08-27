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
import wolox.training.models.Professor;
import wolox.training.repositories.ProfessorRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProfessorRepositoryTest {

    @Autowired
    private ProfessorRepository professorRepository;

    Professor professor;

    @Before
    public void setUp(){
        professor = UserFactory.buildProfessor();
        professor.setName("Professor1");
        professor.setSubject("Maths");
        professorRepository.save(professor);

    }

    @Test
    public void whenFindAllThenReturnProfessorsIterable(){
        Iterable<Professor> professors = professorRepository.findAll();
        Assertions.assertTrue(Iterables.size(professors) > 0);
    }

}
