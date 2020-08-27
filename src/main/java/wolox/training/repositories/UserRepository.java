package wolox.training.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wolox.training.models.User;

public interface UserRepository extends UserRepositoryBase<User> {

    public Optional<User> findFirstByUsername(String username);
    public Optional<List<User>> findByBirthdateBetweenAndNameContainingIgnoreCase(LocalDate startDate,
            LocalDate endDate, String name);
}
