package wolox.training.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import wolox.training.models.DTO.BookDTO;
import wolox.training.utils.Constants;

@Service
public class OpenLibraryService {

    public Optional<BookDTO> bookInfo(String isbn) throws Exception {

        String param="ISBN:"+isbn;
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        ResponseEntity<String> response
                = restTemplate.getForEntity(Constants.getUrlOpenlibraryISBNParam(isbn), String.class);
        JsonNode root = objectMapper.readTree(response.getBody());
        JsonNode isbValue = root.path(param);
        BookDTO bookDTO = !Strings.isNullOrEmpty(isbValue.toString()) ?
                objectMapper.readValue(isbValue.toString(), BookDTO.class) : null;
        if (bookDTO != null){
            bookDTO.setIsbn(isbn);
        }
        return Optional.ofNullable(bookDTO);

    }
}
