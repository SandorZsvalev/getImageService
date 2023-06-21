package org.getimageservice.service;

import org.getimageservice.model.ApiResponse;
import org.springframework.web.client.HttpClientErrorException;


public interface ApiResponseService {

    ApiResponse fromException (HttpClientErrorException exception);

    String getErrorMessage (ApiResponse apiResponse);
}
