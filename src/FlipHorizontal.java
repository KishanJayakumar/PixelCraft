import java.awt.image.BufferedImage;
import java.io.IOException;

public class FlipHorizontal extends Converter {
    @Override
    public void convert(String inputFileName, String outputFileName) throws IOException {
        BufferedImage image = readImage(inputFileName);
        flipColumn(0, 0, image); // Start at (0, 0)
        writeImage(image, outputFileName);
    }

    private void flipColumn(int x, int y, BufferedImage image) {
        // Base case: stop when we reach the bottom row
        if (y >= image.getHeight()) return;

        flipRow(x, y, image); // Process current row
        flipColumn(0, y + 1, image); // Move to the next row
    }

    private void flipRow(int x, int y, BufferedImage image) {
        // Base case: stop when we reach the middle of the row
        if (x >= image.getWidth() / 2) return;

        // Swap the pixel at (x, y) with its counterpart on the other side of the row
        int leftPixel = image.getRGB(x, y);
        int rightPixel = image.getRGB(image.getWidth() - x - 1, y);

        image.setRGB(x, y, rightPixel);
        image.setRGB(image.getWidth() - x - 1, y, leftPixel);

        flipRow(x + 1, y, image); // Move to the next pixel in the row
    }
}
