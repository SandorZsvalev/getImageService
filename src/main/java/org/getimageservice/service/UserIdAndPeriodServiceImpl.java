package org.getimageservice.service;

import org.getimageservice.model.ApiResponse;
import org.getimageservice.model.ImageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserIdAndPeriodServiceImpl implements UserIdAndPeriodService {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private ImageInfoService imageInfoService;

    @Autowired
    private ApiResponseService apiResponseService;

    @Override
    public ResponseEntity<?> getListOfImageByUserIdAndPeriod(Long userId, String from, String to) {
        ImageInfoReceiveService imageInfoReceiveService = context.getBean(ImageInfoReceiveService.class);
        ResponseEntity<ApiResponse> listImagesIdByUserId = imageInfoReceiveService.getListOfImageByUserIdAndPeriod(userId, from, to);
        if (listImagesIdByUserId.getStatusCode() == HttpStatus.OK) {
            List<ImageInfo> imageInfoList = imageInfoService.getImageInfoList(listImagesIdByUserId.getBody());
            List<String> uuidFromListOfImageInfo = imageInfoService.getUUIDfromListOfImageInfo(imageInfoList);
            return new ResponseEntity<>(uuidFromListOfImageInfo, listImagesIdByUserId.getStatusCode());
        } else {
            String errorMessage = apiResponseService.getErrorMessage(listImagesIdByUserId.getBody());
            return new ResponseEntity<>(errorMessage, listImagesIdByUserId.getStatusCode());
        }
    }
}
