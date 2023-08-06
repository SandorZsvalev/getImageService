package org.getimageservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.getimageservice.service.ModelMicroService;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Image implements ModelMicroService {
    private byte[] body;

    public Image() {
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }
}
