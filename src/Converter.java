import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Converter{
    /**
     * Read the input image file
     * @param inputFileName - The file name of the image to access
     * @return - returns the image it was told to get
     */
    public BufferedImage readImage(String inputFileName){
        try {
            File inputFile = new File(inputFileName);
            BufferedImage originalImage = ImageIO.read(inputFile);
            return originalImage;
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Save the output image to a file
     * @param processedImage - The finished image after conversion
     * @param outputFileName - The file name to assign to the new image
     */
    public void writeImage(BufferedImage processedImage, String outputFileName) {
        try {
            File outputFile = new File(outputFileName);
            ImageIO.write(processedImage, "PNG", outputFile);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create a new image with <width> and <height>, and specifies the type of the color value
     * @param width - The width of the image
     * @param height - The height of the image
     * @return - Returns the image 
     */
    public BufferedImage createImage(int width, int height){
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        return newImage;
    }

    //The abstact method that must be filled by every class that inherits this class
    abstract void convert(String inputFileName, String outputFileName) throws IOException;
}