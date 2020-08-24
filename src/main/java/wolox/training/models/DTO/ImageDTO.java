package wolox.training.models.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageDTO {

    @JsonProperty("medium")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
