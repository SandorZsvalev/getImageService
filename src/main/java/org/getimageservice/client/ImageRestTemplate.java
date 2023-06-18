package org.getimageservice.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

public class ImageRestTemplate extends RestTemplate {
    public ImageRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        super();
        restTemplateBuilder
                .setReadTimeout(Duration.ofMillis(5000))
                .setConnectTimeout(Duration.ofMillis(5000))
                .configure(this);
    }
}
