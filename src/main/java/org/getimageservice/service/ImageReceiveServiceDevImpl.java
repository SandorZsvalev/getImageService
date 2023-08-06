package org.getimageservice.service;

import org.getimageservice.client.ImageRestTemplate;
import org.getimageservice.model.ApiResponse;
import org.getimageservice.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.IOException;

@Service
@Scope("prototype")
@Profile("dev")
public class ImageReceiveServiceDevImpl implements ImageReceiveService {

    @Value("${storageApp-getImageById.path:}")
    private String pathToImageStorage;

    @Value("${storage-image.path}")
    private String pathToSaveImage;

    @Autowired
    private ImageRestTemplate imageRestTemplate;

    @Override
    public ResponseEntity<ApiResponse> getImageByUuid(String imageUuid) {

        ResponseEntity<ApiResponse> exchange = imageRestTemplate.exchange(
                pathToImageStorage,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                },
                imageUuid
        );

        // test to save picture locally to check bytecode is correct
        byte[] body = exchange.getBody().getT().getBody();
        try {
            BufferedImage image = ImageUtils.bytesToImage(body);
            ImageUtils.saveImageLocally(image, pathToSaveImage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //
        return exchange;
    }
}
