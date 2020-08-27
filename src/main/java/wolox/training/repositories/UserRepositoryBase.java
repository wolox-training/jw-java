package wolox.training.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wolox.training.models.User;

@Repository
public interface UserRepositoryBase <T extends User> extends CrudRepository<T, Long> {

}
