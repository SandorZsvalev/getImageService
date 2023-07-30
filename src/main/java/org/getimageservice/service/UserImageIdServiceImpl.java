package org.getimageservice.service;

import org.getimageservice.model.ApiResponse;
import org.getimageservice.model.ImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserImageIdServiceImpl implements UserImageIdService {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private ImageDtoService imageDtoService;

    @Autowired
    private ApiResponseService apiResponseService;

    @Override
    public ResponseEntity<?> getImageByUuid(String imageUuid) {
        ImageReceiveService imageReceiveService = context.getBean(ImageReceiveService.class);
        ResponseEntity<ApiResponse> imageByUuid = imageReceiveService.getImageByUuid(imageUuid);
        if (imageByUuid.getStatusCode() == HttpStatus.OK){
            ImageDto imageDto = imageDtoService.getImageDto(imageByUuid.getBody());
            byte[] imageFromImageDto = imageDtoService.getImageFromImageDto(imageDto);
            return new ResponseEntity<>(imageFromImageDto,imageByUuid.getStatusCode());
        } else {
            String errorMessage = apiResponseService.getErrorMessage(imageByUuid.getBody());
            return new ResponseEntity<>(errorMessage,imageByUuid.getStatusCode());
        }
    }
}
