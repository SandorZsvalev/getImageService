package org.getimageservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.getimageservice.model.ApiResponse;


public interface ApiResponseService {
    public ApiResponse deserializeApiResponse(String responseBody) throws JsonProcessingException;

}
