package org.getimageservice.service;

import org.getimageservice.model.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface UserImageIdService {

    ResponseEntity<ApiResponse> getImageByUuid(String imageUuid);
}
