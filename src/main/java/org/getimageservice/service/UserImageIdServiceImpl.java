package org.getimageservice.service;

import org.getimageservice.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserImageIdServiceImpl implements UserImageIdService {

    @Autowired
    private ApplicationContext context;

    @Override
    public ResponseEntity<ApiResponse> getImageByUuid(String imageUuid) {
        ImageReceiveService imageReceiveService = context.getBean(ImageReceiveService.class);
        return imageReceiveService.getImageByUuid(imageUuid);
    }
}
