package org.getimageservice.utils;

import org.springframework.context.annotation.Profile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

@Profile("dev")
public class ImageUtils {
    public static BufferedImage bytesToImage(byte[] imageData) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
        return ImageIO.read(bis);
    }
    public static void saveImageLocally(BufferedImage image, String outputPath) throws IOException {
        ImageIO.write(image, "jpg", new File(outputPath));
    }
}