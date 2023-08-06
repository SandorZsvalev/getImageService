package org.getimageservice.service.mapper;

import org.getimageservice.model.Image;
import org.getimageservice.model.ImageResponse;
import org.springframework.stereotype.Service;

@Service
public class ImageMapper implements Mapper<ImageResponse, Image> {
    @Override
    public ImageResponse toDo(Image image) {
        ImageResponse imageResponse = new ImageResponse();
        imageResponse.setBody(image.getBody());
        return imageResponse;
    }
}
