package org.getimageservice.service;

import org.getimageservice.client.ImageRestTemplate;
import org.getimageservice.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
@Scope("prototype")
@Profile("prod")
public class ImageReceiveServiceImpl implements ImageReceiveService {

    @Value("${storageApp-getImageById.path:}")
    private String pathToImageStorage;

    @Autowired
    private ImageRestTemplate imageRestTemplate;

    @Autowired
    private ApiResponseService apiResponseService;

    @Override
    public ResponseEntity<ApiResponse> getImageByUuid(String imageUuid) {

        try {
            return imageRestTemplate.exchange(
                    pathToImageStorage,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    },
                    imageUuid
            );
        } catch (HttpClientErrorException exception) {
            ApiResponse apiResponse = apiResponseService.fromException(exception);
            return new ResponseEntity<>(apiResponse, exception.getStatusCode());
        }
    }
}
