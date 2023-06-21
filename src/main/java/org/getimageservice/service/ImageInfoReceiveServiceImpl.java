package org.getimageservice.service;

import org.getimageservice.client.ImageRestTemplate;
import org.getimageservice.model.ApiResponse;
import org.getimageservice.utils.ExceptionParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;

@Service
@Scope("prototype")
public class ImageInfoReceiveServiceImpl implements ImageInfoReceiveService {

    @Value("${storageApp-getListBy.path:}")
    private String pathToImageList;

    @Autowired
    private ImageRestTemplate imageRestTemplate;

    @Autowired
    private ImageInfoDtoService imageInfoDtoService;

    @Autowired
    private ApiResponseService apiResponseService;

    @Override
    public ResponseEntity<ApiResponse> getListOfImageByUserIdAndPeriod(Long userId, LocalDate from, LocalDate to) {

        try {
            ResponseEntity<ApiResponse> response = imageRestTemplate.exchange(
                    pathToImageList,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    },
                    userId,
                    from.toString(),
                    to.toString()
            );
            return response;
        } catch (HttpClientErrorException exception) {
            ExceptionParser exceptionParser = new ExceptionParser();
            ApiResponse apiResponse = exceptionParser.fromException(exception);
            return new ResponseEntity<>(apiResponse, exception.getStatusCode());
        }
    }
}
