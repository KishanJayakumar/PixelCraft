import java.awt.image.BufferedImage;
import java.io.IOException;

public class Rotate extends Converter {
    @Override
    public void convert(String inputFileName, String outputFileName) throws IOException {
        // Read the image from the input file
        // Get the width and height of the image
        BufferedImage original = readImage(inputFileName);
        int width = original.getWidth();
        int height = original.getHeight();
        
        // Create a new BufferedImage for the rotated image
        // The new width and height are swapped for a 90-degree rotation
        BufferedImage rotated = new BufferedImage(height, width, original.getType());
        
        // Map pixels from original to rotated positions
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixel = original.getRGB(x, y);
                int newX = height - y - 1; // Rotate 90 degrees clockwise
                int newY = x; // Rotate 90 degrees clockwise
                rotated.setRGB(newX, newY, pixel);
            }
        }
        
        // Write the rotated image to the output file
        writeImage(rotated, outputFileName);
    }
}
