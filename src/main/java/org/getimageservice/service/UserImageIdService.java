package org.getimageservice.service;

import org.springframework.http.ResponseEntity;

public interface UserImageIdService {

    ResponseEntity<?> getImageByUuid(String imageUuid);
}
