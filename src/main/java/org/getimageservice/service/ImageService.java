package org.getimageservice.service;

import org.getimageservice.model.ApiResponse;
import org.getimageservice.model.Image;

public interface ImageService {

    Image getImage(ApiResponse apiResponse);

    byte[] getByteCodeFromImage(Image image);
}
