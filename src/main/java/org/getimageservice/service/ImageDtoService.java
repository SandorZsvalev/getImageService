package org.getimageservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.getimageservice.model.ImageDto;

public interface ImageDtoService {

    ImageDto deserializeImage(String responseBody) throws JsonProcessingException;

    byte[] getImageFromImageDto(ImageDto imageDto);
}
