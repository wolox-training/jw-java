package wolox.training.models.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class BookDTO {
    private String isbn;

    private String title;

    private String subtitle;

    private List<AuthorDTO> publishers;

    private String publish_date;

    private int number_of_pages;

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

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public int getNumber_of_pages() {
        return number_of_pages;
    }

    public void setNumber_of_pages(int number_of_pages) {
        this.number_of_pages = number_of_pages;
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
