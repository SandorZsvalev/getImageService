package org.getimageservice.service.handler;

import org.getimageservice.model.ApiResponse;
import org.getimageservice.service.ApiResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class HttpClientErrorExceptionHandler {

    @Autowired
    private ApiResponseService apiResponseService;

    @ExceptionHandler
    public ResponseEntity<?> handleHttpClientErrorException(HttpClientErrorException exception,
                                                            HttpServletRequest request) {

        ApiResponse apiResponse = apiResponseService.fromException(exception);
        return new ResponseEntity<>(apiResponse.getError(), exception.getStatusCode());
    }
}
