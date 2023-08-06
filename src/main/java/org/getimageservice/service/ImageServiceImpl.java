package org.getimageservice.service;

import org.getimageservice.model.ApiResponse;
import org.getimageservice.model.Image;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public Image getImage(ApiResponse apiResponse) {
        return apiResponse.getT();
    }

    @Override
    public byte[] getByteCodeFromImage(Image image) {
        return image.getBody();
    }
}
