package org.getimageservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserImageIdServiceImpl implements UserImageIdService {

    @Autowired
    private ApplicationContext context;

    @Override
    public byte[] getImageByUuid(String imageUuid) throws IOException {
        ImageReceiveService imageReceiveService = context.getBean(ImageReceiveService.class);
        return imageReceiveService.getImageByUuid(imageUuid);
    }
}
