package org.getimageservice.service;

import org.getimageservice.model.ApiResponse;
import org.getimageservice.model.ImageDto;

public interface ImageDtoService {

    ImageDto getImageDto(ApiResponse apiResponse);

    byte[] getImageFromImageDto(ImageDto imageDto);
}
