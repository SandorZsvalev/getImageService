package org.getimageservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.getimageservice.model.ImageInfoDto;
import java.util.List;
import java.util.UUID;

public interface ImageInfoDtoService {

    List<ImageInfoDto> deserializeImageInfo(String responseBody) throws JsonProcessingException;

    List<UUID> getUUIDfromListOfImageInfoDto(List<ImageInfoDto> listOfImageDto);
}
