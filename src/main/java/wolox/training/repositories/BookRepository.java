package wolox.training.repositories;

import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;
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

    @Query("SELECT b "
            + " FROM Book b "
            + " WHERE (:genre = '' or :genre is null or b.genre = :genre)"
            + " AND (:author = '' or :author is null or b.author = :author)"
            + " AND (:image = '' or :image is null or b.image = :image)"
            + " AND (:title = '' or :title is null or b.title = :title)"
            + " AND (:subtitle = '' or :subtitle is null or b.subtitle = :subtitle)"
            + " AND (:publisher = '' or :publisher is null or b.publisher = :publisher)"
            + " AND (:year = '' or :year is null or b.year = :year)"
            + " AND (:pages is null or CAST(:pages as int) <= 0 or CAST(b.pages as int) = :pages)"
            + " AND (:isbn = '' or :isbn is null or b.isbn = :isbn)")
    public Optional<List<Book>> findByAllFields(@Param("genre") String genre,
            @Param("author") String author, @Param("image") String image,
            @Param("title") String title, @Param("subtitle") String subtitle,
            @Param("publisher") String publisher, @Param("year") String year,
            @Param("pages") Integer pages, @Param("isbn") String isbn);

}
