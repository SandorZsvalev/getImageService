package org.getimageservice.model;

import org.getimageservice.service.ModelMicroService;

public class ImageResponse implements ModelMicroService {
    private byte[] body;

    public ImageResponse() {
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

}
