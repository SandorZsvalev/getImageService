package org.getimageservice.service;

import org.getimageservice.model.ImageDto;
import org.getimageservice.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class UserImageIdServiceImpl implements UserImageIdService {

    @Value("${storageApp-getImage.path:}")
    private String pathToImageStorage;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ImageDtoService imageDtoService;

    @Autowired
    ImageUtils imageUtils;

    @Override
    public byte[] getImageByUuid(String imageUuid) throws IOException {

        String externalAppUrl = pathToImageStorage + "id=" + imageUuid;
        ResponseEntity<String> response = restTemplate.exchange(
                externalAppUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {
                }
        );
        String responseBody = response.getBody();
        ImageDto imageDto = imageDtoService.deserializeImage(responseBody);
        byte[] imageData = imageDtoService.getImageFromImageDto(imageDto);

        // test to save picture locally to check bytecode is correct
/*        BufferedImage image = ImageUtils.bytesToImage(imageData);
        ImageUtils.saveImageLocally(image, "/Users/zsvalevsandor/Documents/finfour/forSave/image.jpg");*/

        return imageData;
    }
}
