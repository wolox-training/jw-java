package wolox.training.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

    private String genre;

    @NonNull
    private String author;

    @NonNull
    private String image;

    @NonNull
    private String title;

    @NonNull
    private String subtitle;

    @NonNull
    private String publisher;

    @NonNull
    private String year;

    private int pages;

    @NonNull
    private String isbn;

    @ManyToMany(mappedBy = "books")
    @JsonIgnore
    private List<User> users;

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

    public void setPages(int pages) {
        Preconditions.checkArgument(pages > 0
                , Constants.getNumberValidationMessage("pages"));
        this.pages = pages;
    }

}
