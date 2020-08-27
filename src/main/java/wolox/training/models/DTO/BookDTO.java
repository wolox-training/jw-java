package wolox.training.models.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class BookDTO {
    private String isbn;

    private String title;

    private String subtitle;

    private List<AuthorDTO> publishers;

    @JsonProperty("publish_date")
    private String publishDate;

    @JsonProperty("number_of_pages")
    private int numberOfPages;

    private List<AuthorDTO> authors;

    @JsonProperty("cover")
    private ImageDTO image;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public List<AuthorDTO> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<AuthorDTO> publishers) {
        this.publishers = publishers;
    }

    public List<AuthorDTO> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDTO> authors) {
        this.authors = authors;
    }

    public ImageDTO getImage() {
        return image;
    }

    public void setImage(ImageDTO image) {
        this.image = image;
    }
}
