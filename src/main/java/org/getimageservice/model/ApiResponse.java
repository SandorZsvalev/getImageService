package org.getimageservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {

    private String error;
    private List<ImageInfo> list;
    private Image t;

    public ApiResponse() {
    //
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<ImageInfo> getList() {
        return list;
    }

    public void setList(List<ImageInfo> list) {
        this.list = list;
    }

    public Image getT() {
        return t;
    }

    public void setT(Image t) {
        this.t = t;
    }
}
