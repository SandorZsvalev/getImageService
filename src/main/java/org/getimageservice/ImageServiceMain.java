package org.getimageservice;

import org.getimageservice.configuration.ImageServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ImageServiceConfiguration.class)
public class ImageServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(ImageServiceMain.class, args);
    }
}
