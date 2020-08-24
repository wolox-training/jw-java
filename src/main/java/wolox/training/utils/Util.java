package wolox.training.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Util {

    public static String objectToJsonString(Object o){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson= null;
        try {
            requestJson = ow.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return requestJson;
    }

}
