package org.getimageservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {

    private String error;
    private List<ImageInfoDto> list;
    private ImageDto t;

    public ApiResponse() {
    //
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<ImageInfoDto> getList() {
        return list;
    }

    public void setList(List<ImageInfoDto> list) {
        this.list = list;
    }

    public ImageDto getT() {
        return t;
    }

    public void setT(ImageDto t) {
        this.t = t;
    }
}
