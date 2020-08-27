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
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import wolox.training.models.DTO.BookDTO;
import wolox.training.utils.Constants;

@Entity
@NoArgsConstructor
public @Data class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE) private long id;

    @Setter(AccessLevel.NONE) private String genre;

    @NotNull
    @Setter(AccessLevel.NONE) private String author;

    @NotNull
    @Setter(AccessLevel.NONE) private String image;

    @NotNull
    @Setter(AccessLevel.NONE) private String title;

    @NotNull
    @Setter(AccessLevel.NONE) private String subtitle;

    @NotNull
    @Setter(AccessLevel.NONE) private String publisher;

    @NotNull
    @Setter(AccessLevel.NONE) private String year;

    @NotNull
    @Setter(AccessLevel.NONE) private int pages;

    @NotNull
    @Setter(AccessLevel.NONE) private String isbn;

    @ManyToMany(mappedBy = "books")
    @JsonIgnore
    @Setter(AccessLevel.NONE) private List<User> users;

    public Book(@NonNull BookDTO bookDTO){
        this.pages = bookDTO.getNumberOfPages();
        this.isbn = bookDTO.getIsbn();
        this.publisher = bookDTO.getPublishers().get(0).getName();
        this.title = bookDTO.getTitle();
        this.year = bookDTO.getPublishDate();
        this.subtitle = bookDTO.getSubtitle();
        this.author = bookDTO.getAuthors().get(0).getName();
        this.image = bookDTO.getImage().getUrl();
        this.genre = bookDTO.getTitle();
    }

    public void setGenre(String genre) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(genre)
                , Constants.getNullOrEmptyValidationMessage("genre"));
        this.genre = genre;
    }

    public void setAuthor(String author) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(author)
                , Constants.getNullOrEmptyValidationMessage("author"));
        this.author = author;
    }

    public void setImage(String image) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(image)
                , Constants.getNullOrEmptyValidationMessage("image"));
        this.image = image;
    }

    public void setTitle(String title) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(title)
                , Constants.getNullOrEmptyValidationMessage("title"));
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(subtitle)
                , Constants.getNullOrEmptyValidationMessage("subtitle"));
        this.subtitle = subtitle;
    }

    public void setPublisher(String publisher) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(publisher)
                , Constants.getNullOrEmptyValidationMessage("publisher"));
        this.publisher = publisher;
    }

    public void setYear(String year) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(year)
                , Constants.getNullOrEmptyValidationMessage("year"));
        this.year = year;
    }

    public void setPages(int pages) {
        Preconditions.checkArgument(pages > 0
                , Constants.getNumberValidationMessage("pages"));
        this.pages = pages;
    }

    public void setIsbn(String isbn) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(isbn)
                , Constants.getNullOrEmptyValidationMessage("isbn"));
        this.isbn = isbn;
    }
}
