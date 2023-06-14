package org.getimageservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.getimageservice.model.ImageDto;
import org.springframework.stereotype.Service;

@Service
public class ImageDtoServiceImpl implements ImageDtoService {
    @Override
    public ImageDto deserializeImage(String responseBody) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(responseBody, new TypeReference<>() {
        });
    }

    @Override
    public byte[] getImageFromImageDto(ImageDto imageDto) {
        return imageDto.getBody();
    }
}
