import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Vibrancy extends Converter {
    /// Adjust the vibrancy factor to control the intensity of the effect
    /// A value of 1.0 means no change, while higher values increase vibrancy.
    private static final float VIBRANCY_FACTOR = 2.5f; // Adjust for stronger or weaker effect
    
    @Override
    public void convert(String inputFileName, String outputFileName) throws IOException {
        // Read the image from the input file
        // Get the width and height of the image
        BufferedImage original = readImage(inputFileName);
        int width = original.getWidth();
        int height = original.getHeight();
        
        // Create a new BufferedImage for the vibrant image
        BufferedImage vibrant = new BufferedImage(width, height, original.getType());
        
        // Loop through each pixel in the original image
        // and apply the vibrancy effect
        for (int x = 0; x < width; x++) {
            // Loop through each pixel in the row
            for (int y = 0; y < height; y++) {
                int pixel = original.getRGB(x, y);
                Color color = new Color(pixel);
                
                // Convert RGB to HSB (Hue, Saturation, Brightness)
                float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
                hsb[1] = Math.min(1.0f, hsb[1] * VIBRANCY_FACTOR); // Increase saturation
                
                // Clamp brightness to avoid overflow
                int vibrantRGB = Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);
                vibrant.setRGB(x, y, vibrantRGB);
            }
        }
        
        // Write the vibrant image to the output file
        writeImage(vibrant, outputFileName);
    }
}
