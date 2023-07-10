package core;

import com.google.gson.Gson;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class JsonExtractor {
    public static <P> P deserializeResponse(String jsonResponse, Class<P> cls) {
        Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(jsonResponse, cls);
    }

    @SneakyThrows
    public static <P> P objectMapper(String response, Class<P> cls) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response, cls);
    }
}