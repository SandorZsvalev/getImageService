package org.getimageservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.getimageservice.model.ApiResponse;
import org.springframework.web.client.HttpClientErrorException;


public interface ApiResponseService {
    ApiResponse deserializeApiResponse(String responseBody) throws JsonProcessingException;

    ApiResponse fromException (HttpClientErrorException exception);

    String getErrorMessage (ApiResponse apiResponse);
}
