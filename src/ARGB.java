public class ARGB {
    //The variables to hold the colour values in this class
    public int alpha, red, green, blue;

    /**
     * Constructor for ARGB from a pixel
     * @param pixel - the pixel the colours will be extracted from
     */
    public ARGB(int pixel) {

        // extract different bits from pixel that stores the ARGB values
        this.alpha = (pixel >> 24) & 0xff;
        this.red = (pixel >> 16) & 0xff;
        this.green = (pixel >> 8) & 0xff;
        this.blue = pixel & 0xff;
    }

    /**
     * Constructor for ARGB, inputting all values
     * @param a - the alpha value
     * @param r - the red value
     * @param g - the green value
     * @param b - the blue value
     */
    public ARGB(int a, int r, int g, int b) {
        this.alpha = a;
        this.red = r;
        this.green = g;
        this.blue = b;
    }

    /**
     * Encodes the ARGB values into a single integer
     * @param a - the alpha value
     * @param r - the red value
     * @param g - the green value
     * @param b - the blue value
     * @return - returns the ARGB values as a integer
     */
    public int toInt() {
        // encode the ARGB values into a single integer
        return (this.alpha << 24) | (this.red << 16) | (this.green << 8) | blue;
    }
}