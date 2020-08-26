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
            + " WHERE (:genre = '' OR :genre is null OR b.genre = :genre)"
            + " AND (:author = '' OR :author is null OR b.author = :author)"
            + " AND (:image = '' OR :image is null OR b.image = :image)"
            + " AND (:title = '' OR :title is null OR b.title = :title)"
            + " AND (:subtitle = '' OR :subtitle is null OR b.subtitle = :subtitle)"
            + " AND (:publisher = '' OR :publisher is null OR b.publisher = :publisher)"
            + " AND (:year = '' OR :year is null OR b.year = :year)"
            + " AND (:pages is null OR CAST(:pages as int) <= 0 OR CAST(b.pages as int) = :pages)"
            + " AND (:isbn = '' OR :isbn is null OR b.isbn = :isbn)"
            + " AND ((:startYear = '' AND :endYear = '') "
            + " AND (:startYear is null AND :endYear is null) "
            + " AND (CAST(b.year as int) BETWEEN CAST(:startYear as int) AND CAST(:endYear as int))"
            + " AND (:startYear is null AND :startYear = '' AND b.year >= :startYear )"
            + " AND (:endYear is null AND :endYear = '' AND b.year <= :endYear ))")
    public Optional<List<Book>> findByAllFields(@Param("genre") String genre,
            @Param("author") String author, @Param("image") String image,
            @Param("title") String title, @Param("subtitle") String subtitle,
            @Param("publisher") String publisher, @Param("year") String year,
            @Param("pages") Integer pages, @Param("isbn") String isbn,
            @Param("startYear") String startYear, @Param("endYear") String endYear);

}
