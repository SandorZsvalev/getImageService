package org.getimageservice.service;

import org.getimageservice.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserImageIdServiceImpl implements UserImageIdService {

    @Autowired
    private ApplicationContext context;

    @Override
    public ResponseEntity<?> getImageByUuid(String imageUuid) {
        ImageReceiveService imageReceiveService = context.getBean(ImageReceiveService.class);
        ResponseEntity<ApiResponse> imageByUuid = imageReceiveService.getImageByUuid(imageUuid);
        if (imageByUuid.getStatusCode() == HttpStatus.OK){
            return new ResponseEntity<>(imageByUuid.getBody().getT().getBody(),imageByUuid.getStatusCode());
        } else {
            return new ResponseEntity<>(imageByUuid.getBody().getError(),imageByUuid.getStatusCode());
        }
    }
}
