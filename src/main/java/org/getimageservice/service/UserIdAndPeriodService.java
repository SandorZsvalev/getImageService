package org.getimageservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface UserIdAndPeriodService {
    List<UUID> getListOfImageByUserIdAndPeriod(Long userId, LocalDate from, LocalDate to) throws JsonProcessingException;
}
