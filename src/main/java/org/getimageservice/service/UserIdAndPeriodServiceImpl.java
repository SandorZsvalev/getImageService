package org.getimageservice.service;

import org.getimageservice.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserIdAndPeriodServiceImpl implements UserIdAndPeriodService {

    @Autowired
    private ApplicationContext context;

    @Override
    public ResponseEntity<ApiResponse> getListOfImageByUserIdAndPeriod(Long userId, LocalDate from, LocalDate to) {
        ImageInfoReceiveService imageInfoReceiveService = context.getBean(ImageInfoReceiveService.class);
        return imageInfoReceiveService.getListOfImageByUserIdAndPeriod(userId,from,to);
    }
}
