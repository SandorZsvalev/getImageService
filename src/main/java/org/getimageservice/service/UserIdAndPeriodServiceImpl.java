package org.getimageservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class UserIdAndPeriodServiceImpl implements UserIdAndPeriodService {

    @Autowired
    private ApplicationContext context;

    @Override
    public List<UUID> getListOfImageByUserIdAndPeriod(Long userId, LocalDate from, LocalDate to) throws JsonProcessingException {
        ImageInfoReceiveService imageInfoReceiveService = context.getBean(ImageInfoReceiveService.class);
        return imageInfoReceiveService.getListOfImageByUserIdAndPeriod(userId,from,to);
    }
}
