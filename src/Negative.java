import java.awt.image.BufferedImage;
import java.io.IOException;

public class Negative extends Converter{
    @Override
    public void convert(String inputFileName, String outputFileName) throws IOException{
        BufferedImage image = readImage(inputFileName);
        
        for(int y = 0; y < image.getHeight(); y++){
            for(int x = 0; x < image.getWidth(); x++){
                ARGB pixel = new ARGB(image.getRGB(x, y));

                pixel.red = 255 - pixel.red;
                pixel.green = 255 - pixel.green;
                pixel.blue = 255 - pixel.blue;

                image.setRGB(x, y, pixel.toInt());
            }
        }

        writeImage(image, outputFileName);
    }
}
