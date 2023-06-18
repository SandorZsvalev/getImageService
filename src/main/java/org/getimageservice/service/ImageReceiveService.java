package org.getimageservice.service;

import java.io.IOException;

public interface ImageReceiveService {
    byte[] getImageByUuid(String imageUuid) throws IOException;
}
