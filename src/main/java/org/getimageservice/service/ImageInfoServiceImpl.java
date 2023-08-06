package org.getimageservice.service;

import org.getimageservice.model.ApiResponse;
import org.getimageservice.model.ImageInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageInfoServiceImpl implements ImageInfoService {

    @Override
    public List<ImageInfo> getImageInfoList(ApiResponse apiResponse) {
        return apiResponse.getList();
    }

    @Override
    public List<String> getUUIDfromListOfImageInfo(List<ImageInfo> listOfImage) {
        List<String> userImageIdList = new ArrayList<>();

        for (ImageInfo imageInfo : listOfImage) {
            userImageIdList.add(imageInfo.getUuid());
        }
        return userImageIdList;
    }
}
