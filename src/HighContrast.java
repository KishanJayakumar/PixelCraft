import java.awt.image.BufferedImage;
import java.io.IOException;

public class HighContrast extends Converter{
    @Override
    public void convert(String inputFileName, String outputFileName) throws IOException{
        BufferedImage image = readImage(inputFileName);
        
        for(int y = 0; y < image.getHeight(); y++){
            for(int x = 0; x < image.getWidth(); x++){
                ARGB pixel = new ARGB(image.getRGB(x, y));

                pixel.red = pixel.red * 3;
                pixel.green = pixel.green * 3;
                pixel.blue = pixel.blue * 3;

                pixel.red = Math.min(255, Math.max(0, pixel.red));
                pixel.green = Math.min(255, Math.max(0, pixel.green));
                pixel.blue = Math.min(255, Math.max(0, pixel.blue));

                image.setRGB(x, y, pixel.toInt());
            }
        }

        writeImage(image, outputFileName);
    }
}

