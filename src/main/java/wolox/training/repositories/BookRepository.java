package wolox.training.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wolox.training.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    public Optional<Book> findFirstByAuthorIgnoreCase(String author);

    public Optional<Book> findByIsbn(String isbn);

    public Optional<Book> findByPublisherAndGenreAndYear(String publisher, String genre, String year);
}
