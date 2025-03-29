import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Converter{
    
    // Read the input image file
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
    // Save the output image to a file
    public void writeImage(BufferedImage processedImage, String outputFileName) {
        try {
            File outputFile = new File(outputFileName);
            ImageIO.write(processedImage, "PNG", outputFile);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    // Create a new image with <width> and <height>, and specifies the type of the color value
    public BufferedImage createImage(int width, int height){
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        return newImage;
    }

    abstract void convert(String inputFileName, String outputFileName) throws IOException;
}