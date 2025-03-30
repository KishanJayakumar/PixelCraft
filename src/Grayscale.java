import java.awt.image.BufferedImage;
import java.io.IOException;

public class Grayscale extends Converter {
    @Override
    public void convert(String inputFileName, String outputFileName) throws IOException{
        BufferedImage image = readImage(inputFileName);

        grayColumn(0, 0, image);

        writeImage(image, outputFileName);
    }

    public void grayColumn(int x, int y, BufferedImage image){
        if(y == image.getHeight() - 1){
            return;
        }

        grayRow(x, y, image);

        y++;
        grayColumn(x, y, image);
    }

    public void grayRow(int x, int y, BufferedImage image){
        if(x == image.getWidth() - 1){
            return;
        }

        ARGB pixel = new ARGB(image.getRGB(x, y));

        int colour = (pixel.blue + pixel.green + pixel.red) / 3;

        image.setRGB(x, y, new ARGB(255, colour, colour, colour).toInt());

        x++;
        grayRow(x, y, image);
    }
}
