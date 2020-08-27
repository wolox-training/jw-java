package wolox.training.models.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public @Data class ImageDTO {

    @JsonProperty("medium")
    private String url;

}
