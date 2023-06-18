package org.getimageservice.configuration;

import org.getimageservice.client.ImageRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImageServiceConfiguration {
    @Bean
    public ImageRestTemplate imageRestTemplate() {
        return new ImageRestTemplate(new RestTemplateBuilder());
    }


}
