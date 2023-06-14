package org.getimageservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.getimageservice.model.ImageInfoDto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ImageInfoDtoServiceImpl implements ImageInfoDtoService {

    @Override
    public List<ImageInfoDto> deserializeImageInfo(String responseBody) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(responseBody, new TypeReference<>() {
        });
    }

    @Override
    public List<UUID> getUUIDfromListOfImageInfoDto(List<ImageInfoDto> listOfImageDto) {
        List<UUID> userImageIdList = new ArrayList<>();

        for (ImageInfoDto imageInfoDto : listOfImageDto) {
            userImageIdList.add(imageInfoDto.getUuid());
        }
        return userImageIdList;
    }
}
