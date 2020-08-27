package wolox.training.models.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class AuthorDTO {

    private String name;

    public AuthorDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
