package org.getimageservice.service;

import org.getimageservice.client.ImageRestTemplate;
import org.getimageservice.model.ImageDto;
import org.getimageservice.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Scope("prototype")
public class ImageReceiveServiceImpl implements ImageReceiveService {

    @Value("${storageApp-getImage.path:}")
    private String pathToImageStorage;

    @Autowired
    private ImageRestTemplate imageRestTemplate;

    @Autowired
    private ImageDtoService imageDtoService;

    @Autowired
    private ImageUtils imageUtils;

    @Override
    public byte[] getImageByUuid(String imageUuid) throws IOException {

        String externalAppUrl = pathToImageStorage +imageUuid;
        ResponseEntity<String> response = imageRestTemplate.exchange(
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
