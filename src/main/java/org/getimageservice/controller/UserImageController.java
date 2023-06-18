package org.getimageservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.getimageservice.service.UserIdAndPeriodService;
import org.getimageservice.service.UserImageIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.time.LocalDate;

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
             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from,
             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to) {
        try {
            return new ResponseEntity<>
                    (userIdAndPeriodService.getListOfImageByUserIdAndPeriod(userId, from, to), HttpStatus.OK);
        } catch (IllegalArgumentException | JsonProcessingException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (HttpClientErrorException.BadRequest exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("BadRequest: " + exception.getRawStatusCode() + " : " + exception.getResponseBodyAsString());
        }
    }

    @GetMapping(path = "/image")
    public ResponseEntity<?> getImageByUuid(@RequestParam(value = "uuid") String imageUuid) {
        try {
            return new ResponseEntity<>(userImageIdService.getImageByUuid(imageUuid), HttpStatus.OK);
        } catch (IllegalArgumentException | JsonProcessingException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (HttpClientErrorException.BadRequest exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("BadRequest: " + exception.getRawStatusCode() + " : " + exception.getResponseBodyAsString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
