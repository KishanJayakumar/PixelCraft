import java.awt.image.BufferedImage;
import java.io.IOException;

public class Grayscale extends Converter {
    @Override
    /**
     * Changes the image to a black and white render
     * @param inputFileName - The file name of the image to access
     * @param outputFileName - The file name to assign to the new image
     */
    public void convert(String inputFileName, String outputFileName) throws IOException{
        //grabs the image
        BufferedImage image = readImage(inputFileName);
        //start the recursive functions at the first pixel
        grayColumn(0, 0, image);
        //Set the updated image with the output file name
        writeImage(image, outputFileName);
    }

    public void grayColumn(int x, int y, BufferedImage image){
        //stops the conversion once the image is finished converting
        if(y == image.getHeight() - 1){
            return;
        }

        //starts the recursive function for a row
        grayRow(x, y, image);
        //increments the y variable to move on to the next row
        y++;
        //recursively calls the function
        grayColumn(x, y, image);
    }

    public void grayRow(int x, int y, BufferedImage image){
        //stops once it gets to the final pixel of the row
        if(x == image.getWidth() - 1){
            return;
        }
        //gets the colour of the current pixel and assigns it to a ARGB instance
        ARGB pixel = new ARGB(image.getRGB(x, y));
        //gets the average int of all three colours
        int colour = (pixel.blue + pixel.green + pixel.red) / 3;
        //set the colour of this pixel to the calculated colour
        image.setRGB(x, y, new ARGB(255, colour, colour, colour).toInt());
        //increments the x variable to move on to the next pixel
        x++;
        //recursively calls the function
        grayRow(x, y, image);
    }
}
