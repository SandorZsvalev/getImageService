package org.getimageservice.service;

import org.getimageservice.model.ApiResponse;
import org.getimageservice.model.ImageInfoDto;

import java.util.List;

public interface ImageInfoDtoService {

    List<ImageInfoDto> getImageInfoList(ApiResponse apiResponse);

    List<String> getUUIDfromListOfImageInfoDto(List<ImageInfoDto> listOfImageDto);
}
