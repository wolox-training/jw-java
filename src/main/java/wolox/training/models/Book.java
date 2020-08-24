package wolox.training.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import wolox.training.utils.Constants;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotNull
    private String genre;

    @NotNull
    private String author;

    @NotNull
    private String image;

    @NotNull
    private String title;

    @NotNull
    private String subtitle;

    @NotNull
    private String publisher;

    @NotNull
    private String year;

    @NotNull
    private int pages;

    @NotNull
    private String isbn;

    @ManyToMany(mappedBy = "books")
    @JsonIgnore
    private List<User> users;

    public Book() {
    }

    public long getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        Preconditions.checkArgument(Strings.isNullOrEmpty(genre)
                , Constants.getNullOrEmptyValidationMessage("genre"));
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        Preconditions.checkArgument(Strings.isNullOrEmpty(author)
                , Constants.getNullOrEmptyValidationMessage("author"));
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        Preconditions.checkArgument(Strings.isNullOrEmpty(image)
                , Constants.getNullOrEmptyValidationMessage("image"));
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        Preconditions.checkArgument(Strings.isNullOrEmpty(title)
                , Constants.getNullOrEmptyValidationMessage("title"));
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        Preconditions.checkArgument(Strings.isNullOrEmpty(subtitle)
                , Constants.getNullOrEmptyValidationMessage("subtitle"));
        this.subtitle = subtitle;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        Preconditions.checkArgument(Strings.isNullOrEmpty(publisher)
                , Constants.getNullOrEmptyValidationMessage("publisher"));
        this.publisher = publisher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        Preconditions.checkArgument(Strings.isNullOrEmpty(year)
                , Constants.getNullOrEmptyValidationMessage("year"));
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        Preconditions.checkArgument(pages > 0
                , Constants.getNumberValidationMessage("pages"));
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        Preconditions.checkArgument(Strings.isNullOrEmpty(isbn)
                , Constants.getNullOrEmptyValidationMessage("isbn"));
        this.isbn = isbn;
    }

    public List<User> getUsers() {
        return users;
    }
}
