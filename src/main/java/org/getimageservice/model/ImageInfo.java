package org.getimageservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.getimageservice.service.ModelMicroService;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageInfo implements ModelMicroService {
    private String uuid;

    private Date creationDate;

    private Long size;

    public ImageInfo(String uuid, Date creationDate, Long size) {
        this.uuid = uuid;
        this.creationDate = creationDate;
        this.size = size;
    }

    public ImageInfo() {
        //
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
