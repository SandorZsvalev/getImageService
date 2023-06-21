package org.getimageservice.service;

import org.getimageservice.model.ApiResponse;
import org.getimageservice.model.ImageDto;
import org.springframework.stereotype.Service;

@Service
public class ImageDtoServiceImpl implements ImageDtoService {
    @Override
    public ImageDto getImageDto(ApiResponse apiResponse) {
        return apiResponse.getT();
    }

    @Override
    public byte[] getImageFromImageDto(ImageDto imageDto) {
        return imageDto.getBody();
    }
}
