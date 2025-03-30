import java.awt.image.BufferedImage;
import java.io.IOException;

public class RedChannel extends Converter {
    @Override
    public void convert(String inputFileName, String outputFileName) throws IOException {
        BufferedImage image = readImage(inputFileName);
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;

                // Set green and blue channels to zero
                int g = 0;
                int b = 0;

                int newPixel = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, newPixel);
            }
        }

        writeImage(image, outputFileName);
    }
}
