package org.getimageservice.service;

import org.getimageservice.client.ImageRestTemplate;
import org.getimageservice.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
@Scope("prototype")
public class ImageInfoReceiveServiceImpl implements ImageInfoReceiveService {

    @Value("${storageApp-getListBy.path:}")
    private String pathToImageList;

    @Autowired
    private ImageRestTemplate imageRestTemplate;

    @Autowired
    private ApiResponseService apiResponseService;

    @Override
    public ResponseEntity<ApiResponse> getListOfImageByUserIdAndPeriod(Long userId, String from, String to) {

        try {
            ResponseEntity<ApiResponse> response = imageRestTemplate.exchange(
                    pathToImageList,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    },
                    userId,
                    from,
                    to
            );
            return response;
        } catch (HttpClientErrorException exception) {
            ApiResponse apiResponse = apiResponseService.fromException(exception);
            return new ResponseEntity<>(apiResponse, exception.getStatusCode());
        }
    }
}
