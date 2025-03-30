import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Vibrancy extends Converter {
    private static final float VIBRANCY_FACTOR = 2.5f; // Adjust for stronger or weaker effect
    
    @Override
    public void convert(String inputFileName, String outputFileName) throws IOException {
        BufferedImage original = readImage(inputFileName);
        int width = original.getWidth();
        int height = original.getHeight();
        
        BufferedImage vibrant = new BufferedImage(width, height, original.getType());
        
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int pixel = original.getRGB(x, y);
                Color color = new Color(pixel);
                
                float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
                hsb[1] = Math.min(1.0f, hsb[1] * VIBRANCY_FACTOR); // Increase saturation
                
                int vibrantRGB = Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);
                vibrant.setRGB(x, y, vibrantRGB);
            }
        }
        
        writeImage(vibrant, outputFileName);
    }
}
