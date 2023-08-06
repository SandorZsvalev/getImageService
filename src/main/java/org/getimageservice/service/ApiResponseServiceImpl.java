package org.getimageservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.getimageservice.model.ApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Map;

@Service
public class ApiResponseServiceImpl implements ApiResponseService {

    public ApiResponse fromException(HttpClientErrorException exception) {
        ApiResponse apiResponse = new ApiResponse();
        String exceptionMessage = exception.getMessage();

        // Удаляем префикс и суффикс из строки message
        assert exceptionMessage != null;
        String jsonStr = exceptionMessage.substring(exceptionMessage.indexOf("{"), exceptionMessage.lastIndexOf("}") + 1);

        // Удаляем кавычки вокруг JSON-строки
        jsonStr = jsonStr.replace("\"{", "{").replace("}\"", "}");

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> jsonMap;
        try {
            jsonMap = objectMapper.readValue(jsonStr, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        String error = (String) jsonMap.get("error");

        apiResponse.setError(error);
        return apiResponse;
    }

    public String getErrorMessage(ApiResponse apiResponse) {
        return apiResponse.getError();
    }
}
