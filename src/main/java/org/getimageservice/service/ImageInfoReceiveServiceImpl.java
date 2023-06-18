package org.getimageservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.getimageservice.client.ImageRestTemplate;
import org.getimageservice.model.ImageInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Scope("prototype")
public class ImageInfoReceiveServiceImpl implements ImageInfoReceiveService {

    @Value("${storageApp-getList.path:}")
    private String pathToImageList;

    @Autowired
    private ImageRestTemplate imageRestTemplate;

    @Autowired
    private ImageInfoDtoService imageInfoDtoService;
    @Override
    public List<UUID> getListOfImageByUserIdAndPeriod(Long userId, LocalDate from, LocalDate to) throws JsonProcessingException {

        String externalAppUrl = pathToImageList + "id=" + userId + "&from=" + from.toString() + "&to=" + to.toString();
        ResponseEntity<String> response = imageRestTemplate.exchange(
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
