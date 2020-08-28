package wolox.training.models.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

public @Data class BookDTO {
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

}
