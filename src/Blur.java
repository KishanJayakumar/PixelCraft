import java.awt.image.BufferedImage;
import java.io.IOException;

public class Blur extends Converter{
    @Override
    /**
     * Blurs the image by averaging its colour with the surrounding pixels colours a few times
     * @param inputFileName - The file name of the image to access
     * @param outputFileName - The file name to assign to the new image
     */
    public void convert(String inputFileName, String outputFileName) throws IOException{
        //grabs the image
        BufferedImage image = readImage(inputFileName);
        //continuously blur the image more and more for a more exaggerated effect
        for(int z = 0; z < 30; z++){
            //parse through each pixel of the image
            for(int y = 0; y < image.getHeight(); y++){
                for(int x = 0; x < image.getWidth(); x++){
                    //assign all the pixels to the original pixel's colour
                    ARGB pixel = new ARGB(image.getRGB(x, y)), pixel1 = new ARGB(image.getRGB(x, y)), pixel2 = new ARGB(image.getRGB(x, y)), pixel3 = new ARGB(image.getRGB(x, y)), pixel4 = new ARGB(image.getRGB(x, y)), pixel5 = new ARGB(image.getRGB(x, y)), pixel6 = new ARGB(image.getRGB(x, y)), pixel7 = new ARGB(image.getRGB(x, y)), pixel8 = new ARGB(image.getRGB(x, y));
                    // Get the ARGB of the surrounding orthogonal pixels, if they exist
                    if (y > 0) { // top pixel exists
                        pixel1 = new ARGB(image.getRGB(x, y - 1));//overwrite the original pixel to this pixel
                    }
                    if (y < image.getHeight() - 1) { // bottom pixel exists
                        pixel2 = new ARGB(image.getRGB(x, y + 1));
                    }
                    if (x > 0) { // left pixel exists
                        pixel3 = new ARGB(image.getRGB(x - 1, y));
                    }
                    if (x < image.getWidth() - 1) { // right pixel exists
                        pixel4 = new ARGB(image.getRGB(x + 1, y));
                    }
                    // Get the ARGB of the surrounding diagonal pixels, if they exist
                    if (y > 0 && x > 0) { // top left pixel exists
                        pixel5 = new ARGB(image.getRGB(x - 1, y - 1));
                    }
                    if (y > 0 && x < image.getWidth() - 1) { // top right pixel exists
                        pixel6 = new ARGB(image.getRGB(x + 1, y - 1));
                    }
                    if (y < image.getHeight() - 1 && x > 0) { // bottom left pixel exists
                        pixel7 = new ARGB(image.getRGB(x - 1, y + 1));
                    }
                    if (y < image.getHeight() - 1 && x < 0) { // bottom right pixel exists
                        pixel8 = new ARGB(image.getRGB(x + 1, y + 1));
                    }
                    //calculates the averages of each colour and assigns it to pixel
                    pixel.red = (pixel.red + pixel1.red + pixel2.red + pixel3.red + pixel4.red + pixel5.red + pixel6.red + pixel7.red + pixel8.red) / 9;
                    pixel.green = (pixel.green + pixel1.green + pixel2.green + pixel3.green + pixel4.green + pixel5.green + pixel6.green + pixel7.green + pixel8.green) / 9;
                    pixel.blue = (pixel.blue + pixel1.blue + pixel2.blue + pixel3.blue + pixel4.blue + pixel5.blue + pixel6.blue + pixel7.blue + pixel8.blue) / 9;
                    //set the colour of this pixel to the calculated colour
                    image.setRGB(x, y, pixel.toInt());
                }
            }
        }
        //Set the updated image with the output file name
        writeImage(image, outputFileName);
    }
}
