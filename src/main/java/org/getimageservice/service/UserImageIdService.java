package org.getimageservice.service;

import java.io.IOException;

public interface UserImageIdService {

    byte[] getImageByUuid(String imageUuid) throws IOException;
}
