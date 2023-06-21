package org.getimageservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.getimageservice.model.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public class ApiResponseServiceImpl implements ApiResponseService {
    @Override
    public ApiResponse deserializeApiResponse(String responseBody) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(responseBody, new TypeReference<>() {
        });
    }
}
