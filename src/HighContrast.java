import java.awt.image.BufferedImage;
import java.io.IOException;

public class HighContrast extends Converter{
    @Override
    /**
     * Increases the contrast of the image by increasing the rbg values
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

                //Multiplies all the colours to make them as bright and vibrant as possible
                pixel.red = pixel.red * 3;
                pixel.green = pixel.green * 3;
                pixel.blue = pixel.blue * 3;

                //Ensures the colours will be in range
                pixel.red = Math.min(255, Math.max(0, pixel.red));
                pixel.green = Math.min(255, Math.max(0, pixel.green));
                pixel.blue = Math.min(255, Math.max(0, pixel.blue));
                //set the colour of this pixel to the calculated colour
                image.setRGB(x, y, pixel.toInt());
            }
        }
        //Set the updated image with the output file name
        writeImage(image, outputFileName);
    }
}

