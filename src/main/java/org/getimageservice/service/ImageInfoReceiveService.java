package org.getimageservice.service;

import org.getimageservice.model.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public interface ImageInfoReceiveService {

    ResponseEntity<ApiResponse> getListOfImageByUserIdAndPeriod(Long userId, String from, String to);

}

