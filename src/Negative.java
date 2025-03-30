import java.awt.image.BufferedImage;
import java.io.IOException;

public class Negative extends Converter{
    @Override
    /**
     * Creates the negative of the image input
     * @param inputFileName - The file name of the image to access
     * @param outputFileName - The file name to assign to the new image
     */
    public void convert(String inputFileName, String outputFileName) throws IOException{
        //grabs the image
        BufferedImage image = readImage(inputFileName);
        //parse through each pixel of the image
        for(int y = 0; y < image.getHeight(); y++){
            for(int x = 0; x < image.getWidth(); x++){
                //gets the colour of the current pixel and assigns it to a ARGB instance
                ARGB pixel = new ARGB(image.getRGB(x, y));
                //to produce the negative it gets the opposite colour by subtracting the colours current number from 255
                pixel.red = 255 - pixel.red;
                pixel.green = 255 - pixel.green;
                pixel.blue = 255 - pixel.blue;
                //set the colour of this pixel to the calculated colour
                image.setRGB(x, y, pixel.toInt());
            }
        }
        //Set the updated image with the output file name
        writeImage(image, outputFileName);
    }
}
