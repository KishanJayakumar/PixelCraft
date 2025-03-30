import java.awt.image.BufferedImage;
import java.io.IOException;

public class Rotate extends Converter {
    @Override
    public void convert(String inputFileName, String outputFileName) throws IOException {
        BufferedImage original = readImage(inputFileName);
        int width = original.getWidth();
        int height = original.getHeight();
        
        // Create new image with swapped dimensions
        BufferedImage rotated = new BufferedImage(height, width, original.getType());
        
        // Map pixels from original to rotated positions
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixel = original.getRGB(x, y);
                int newX = y;                // New X becomes original Y
                int newY = width - x - 1;    // New Y counts backward from original X
                rotated.setRGB(newX, newY, pixel);
            }
        }
        
        writeImage(rotated, outputFileName);
    }
}
