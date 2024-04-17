package chapters.ch_03;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ean {
    public class BarcodeGenerator {

        private static final String[] CODE_PATTERNS_L = {
                "0001101", "0011001", "0010011", "0111101", "0100011",
                "0110001", "0101111", "0111011", "0110111", "0001011"
        };
        private static final String[] CODE_PATTERNS_G = {
                "0100111", "0110011", "0011011", "0100001", "0011101",
                "0111001", "0000101", "0010001", "0001001", "0010111"
        };
        private static final String[] CODE_PATTERNS_R = {
                "1110010", "1100110", "1101100", "1000010", "1011100",
                "1001110", "1010000", "1000100", "1001000", "1110100"
        };
        private static final String[] FIRST_DIGIT_PATTERNS = {
                "LLLLLL", "LLGLGG", "LLGGLG", "LLGGGL", "LGLLGG",
                "LGGLLG", "LGGGLL", "LGLGLG", "LGLGGL", "LGGLGL"
        };

        // These arrays hold the string patterns corresponding to the left (L), right (R), and alternate (G) digit encodings for the EAN-13 barcode, 
        // as well as the encoding pattern for the first digit.

        private static final int BARCODE_WIDTH = 2;
        private static final int BARCODE_HEIGHT = 100;
        private static final int MARGIN_TOP = 50;
        private static final int MARGIN_BOTTOM = 50;
        private static final int IMAGE_WIDTH = 95 * BARCODE_WIDTH;
        private static final int IMAGE_HEIGHT = BARCODE_HEIGHT + MARGIN_TOP + MARGIN_BOTTOM;
    
        public static void main(String[] args) {
            String ean = "0000000000666"; // Example EAN code
            String path = ean + ".png";
            generateBarcode(ean, path);
        }
    
        private static void generateBarcode(String ean, String path) {
            if (ean.length() != 13 || !ean.matches("\\d+")) {
                throw new IllegalArgumentException("Invalid EAN-13 code");
            }
    /*In summary, the purpose of these two Objects is to set up a blank BufferedImage of the specified dimensions, with a pixel format suitable 
    for displaying a full-color image, and to obtain a Graphics2D object that provides the methods needed to draw on the image. 
    Once the drawing is complete, you can save the BufferedImage to a file, render it on a component, or perform other operations. */

            BufferedImage image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = (Graphics2D) image.getGraphics();
    
            // Fill the background with white
            g.setColor(Color.white);
            g.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
    
            // Start drawing the barcode
            g.setColor(Color.BLACK);
            int position = 0;
    

            // Logic Start
            // Left guard
            position = drawSequence(g, position, "101");
    
            // Draw the first six digits
            String firstDigitPattern = FIRST_DIGIT_PATTERNS[ean.charAt(0) - '0'];
            for (int i = 1; i <= 6; i++) {
                String pattern = firstDigitPattern.charAt(i - 1) == 'L' ? CODE_PATTERNS_L[ean.charAt(i) - '0'] : CODE_PATTERNS_G[ean.charAt(i) - '0'];
                position = drawSequence(g, position, pattern);
            }
    
            // Center guard
            position = drawSequence(g, position, "01010");
    
            // Draw the last six digits
            for (int i = 7; i <= 12; i++) {
                String pattern = CODE_PATTERNS_R[ean.charAt(i) - '0'];
                position = drawSequence(g, position, pattern);
            }
    
            // Right guard
            drawSequence(g, position, "101");
    

            // Logic End
            // Dispose graphics and save the image
            g.dispose();
            try {
                ImageIO.write(image, "png", new File(path));
                System.out.println("Barcode image saved to " + path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
        private static int drawSequence(Graphics2D g, int position, String sequence) {
            for (char c : sequence.toCharArray()) {
                if (c == '1') {
                    g.fillRect(position, MARGIN_TOP, BARCODE_WIDTH, BARCODE_HEIGHT);
                }
                position += BARCODE_WIDTH;
            }
            return position;
        }
    }
}
