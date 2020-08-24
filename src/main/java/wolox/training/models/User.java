package wolox.training.models;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import wolox.training.exceptions.BookAlreadyOwnedException;
import wolox.training.utils.Constants;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull
    private String username;

    @NotNull
    private String name;

    @NotNull
    private LocalDate birthdate;

    @NotNull
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Book> books;

    public User() {
        books = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        Preconditions.checkArgument(Strings.isNullOrEmpty(username)
                , Constants.getNullOrEmptyValidationMessage("username"));
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Preconditions.checkArgument(Strings.isNullOrEmpty(name)
                , Constants.getNullOrEmptyValidationMessage("name"));
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        Preconditions.checkNotNull(birthdate
                , Constants.getNotNullalidationMessage("bitrhdate"));
        this.birthdate = birthdate;
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public void setBooks(List<Book> books) {
        Preconditions.checkNotNull(books
                , Constants.getEmptyListValidationMessage("books"));
        this.books = books;
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
