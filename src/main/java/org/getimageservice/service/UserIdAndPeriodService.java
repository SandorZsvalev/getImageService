package org.getimageservice.service;

import org.springframework.http.ResponseEntity;

public interface UserIdAndPeriodService {
    ResponseEntity<?> getListOfImageByUserIdAndPeriod(Long userId, String from, String to);
}
