package org.getimageservice.controller;

import org.getimageservice.service.UserIdAndPeriodService;
import org.getimageservice.service.UserImageIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserImageController {

    @Autowired
    private UserIdAndPeriodService userIdAndPeriodService;

    @Autowired
    private UserImageIdService userImageIdService;

    @GetMapping(path = "/list")
    public ResponseEntity<?> getListImagesIdByUserId
            (@RequestParam(value = "id") Long userId,
             @RequestParam(value = "from") String from,
             @RequestParam(value = "to") String to) {
        return userIdAndPeriodService.getListOfImageByUserIdAndPeriod(userId, from, to);
    }

    @GetMapping(path = "/image")
    public ResponseEntity<?> getImageByUuid(@RequestParam(value = "uuid") String imageUuid) {
        return userImageIdService.getImageByUuid(imageUuid);
    }
}
