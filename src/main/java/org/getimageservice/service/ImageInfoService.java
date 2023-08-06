package org.getimageservice.service;

import org.getimageservice.model.ApiResponse;
import org.getimageservice.model.ImageInfo;

import java.util.List;

public interface ImageInfoService {

    List<ImageInfo> getImageInfoList(ApiResponse apiResponse);

    List<String> getUUIDfromListOfImageInfo(List<ImageInfo> listOfImage);
}
