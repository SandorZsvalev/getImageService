package org.getimageservice.service;

import org.getimageservice.model.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

public interface UserIdAndPeriodService {
    ResponseEntity<ApiResponse> getListOfImageByUserIdAndPeriod(Long userId, LocalDate from, LocalDate to);
}
