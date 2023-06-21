package org.getimageservice.service;

import org.getimageservice.model.ApiResponse;
import org.getimageservice.model.ImageInfoDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageInfoDtoServiceImpl implements ImageInfoDtoService {

    @Override
    public List<ImageInfoDto> getImageInfoList (ApiResponse apiResponse) {
       return apiResponse.getList();
    }

    @Override
    public List<String> getUUIDfromListOfImageInfoDto(List<ImageInfoDto> listOfImageDto) {
        List<String> userImageIdList = new ArrayList<>();

        for (ImageInfoDto imageInfoDto : listOfImageDto) {
            userImageIdList.add(imageInfoDto.getUuid());
        }
        return userImageIdList;
    }
}
