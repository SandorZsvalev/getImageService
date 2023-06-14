package org.getimageservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.getimageservice.model.ImageInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class UserIdAndPeriodServiceImpl implements UserIdAndPeriodService {

    @Value("${storageApp-getList.path:}")
    private String pathToImageList;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ImageInfoDtoService imageInfoDtoService;

    @Override
    public List<UUID> getListOfImageByUserIdAndPeriod(Long userId, LocalDate from, LocalDate to) throws JsonProcessingException {

        String externalAppUrl = pathToImageList + "id=" + userId + "&from=" + from.toString() + "&to=" + to.toString();
        ResponseEntity<String> response = restTemplate.exchange(
                externalAppUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {
                }
        );
        String responseBody = response.getBody();
        List<ImageInfoDto> listImageInfoDto = imageInfoDtoService.deserializeImageInfo(responseBody);
        return imageInfoDtoService.getUUIDfromListOfImageInfoDto(listImageInfoDto);
    }
}
