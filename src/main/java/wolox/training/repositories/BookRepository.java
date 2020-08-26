package wolox.training.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import wolox.training.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    public Optional<Book> findFirstByAuthorIgnoreCase(String author);

    public Optional<Book> findByIsbn(String isbn);

    public Optional<List<Book>> findByPublisherAndGenreAndYear(String publisher, String genre, String year);

    @Query("SELECT b "
            + " FROM Book b "
            + " WHERE (:publisher is null or b.publisher = :publisher)"
            + " AND (:genre is null or b.genre = :genre)"
            + " AND (:year is null or b.year = :year)")
    public Optional<List<Book>> findByPublisherGenreAndYearCustom(@Param("publisher") String publisher,
            @Param("genre") String genre, @Param("year") String year);
}
