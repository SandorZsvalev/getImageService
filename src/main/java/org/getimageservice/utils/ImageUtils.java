package org.getimageservice.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class ImageUtils {
    public static BufferedImage bytesToImage(byte[] imageData) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
        return ImageIO.read(bis);
    }
    public static void saveImageLocally(BufferedImage image, String outputPath) throws IOException {
        ImageIO.write(image, "jpg", new File(outputPath));
    }
}