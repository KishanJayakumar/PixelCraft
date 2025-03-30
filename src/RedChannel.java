import java.awt.image.BufferedImage;
import java.io.IOException;

public class RedChannel extends Converter {
    @Override
    public void convert(String inputFileName, String outputFileName) throws IOException {
        // Read the image from the input file
        BufferedImage image = readImage(inputFileName);
        // Get the width and height of the image
        int width = image.getWidth();
        int height = image.getHeight();

        // Loop through each pixel in the image
        for (int y = 0; y < height; y++) {
            // Loop through each pixel in the row
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;

                // Set green and blue channels to zero
                int g = 0;
                int b = 0;

                // Combine the channels back into a single pixel value
                int newPixel = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, newPixel);
            }
        }

        // Write the modified image to the output file
        writeImage(image, outputFileName);
    }
}
