package wolox.training.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;
import wolox.training.exceptions.BookAlreadyOwnedException;

@Entity
@Table(name = "users")
public @Data class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE) private long id;

    @NonNull
    private String username;

    @NonNull
    private String name;

    @NonNull
    private LocalDate birthdate;

    @NonNull
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Book> books;

    public User() {
        books = new ArrayList<>();
    }

    /**
     * Add book to user
     * @param book
     * @throws BookAlreadyOwnedException
     */
    public void addBook(Book book){
        if(!books.contains(book)){
            books.add(book);
        }else{
            throw new BookAlreadyOwnedException(book.getTitle());
        }
    }

    /**
     * Remove book from user
     * @param book
     */
    public void removeBook(Book book){
        books.remove(book);
    }

}
