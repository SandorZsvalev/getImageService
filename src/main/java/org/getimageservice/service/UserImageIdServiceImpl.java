package org.getimageservice.service;

import org.getimageservice.model.ApiResponse;
import org.getimageservice.model.Image;
import org.getimageservice.model.ImageResponse;
import org.getimageservice.service.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserImageIdServiceImpl implements UserImageIdService {

    @Autowired
    private Mapper<ImageResponse, Image> mapper;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private ImageService imageService;

    @Autowired
    private ApiResponseService apiResponseService;

    @Override
    public ResponseEntity<?> getImageByUuid(String imageUuid) {
        ImageReceiveService imageReceiveService = context.getBean(ImageReceiveService.class);
        ResponseEntity<ApiResponse> imageByUuid = imageReceiveService.getImageByUuid(imageUuid);
        if (imageByUuid.getStatusCode() == HttpStatus.OK) {
            Image image = imageService.getImage(imageByUuid.getBody());
            ImageResponse imageResponse = mapper.toDo(image);
            return new ResponseEntity<>(imageResponse, imageByUuid.getStatusCode());
        } else {
            String errorMessage = apiResponseService.getErrorMessage(imageByUuid.getBody());
            return new ResponseEntity<>(errorMessage, imageByUuid.getStatusCode());
        }
    }
}
