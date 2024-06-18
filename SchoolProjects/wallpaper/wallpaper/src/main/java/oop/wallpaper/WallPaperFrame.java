package oop.wallpaper;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 * Die Klasse WallPaperFrame erzeugt ein JFrame-Fenster, das ein Tapeten-Bild 
 * mit einem zufällig geneniertem Muster darstellt.
 * <p>Bemerkung: Je nach Grösse des Musters wird ein komplett anderes Muster genenriert. 
 * Das Chaotische Verhalten wird durch das Runden der Radiusfunktion erzeugt.
 * 
 * @author Aleksandar Travanov
 * @version 1.0
 */
@SuppressWarnings("serial")
public class WallPaperFrame extends JFrame {
    /**
     * Konstruiert ein neues WallPaperFrame-Objekt mit der angegebenen Bildgröße und der 
     * Größe des Schachbrettmusters.
     * @param sizeImg Die Größe des Bildes (Breite und Höhe)
     * @param sizePattern Die Größe des Musters als Bruchteil der Bildgröße
     */
    public WallPaperFrame(int sizeImg, double sizePattern) {
        BufferedImage image = createWallPaperImg(sizeImg, sizePattern);
        add(new JLabel(new ImageIcon(image)));
        pack();
    }

    /**
     * Erzeugt ein BufferedImage, das ein Wallpaper-Bild mit einem Muster darstellt.
     * @param sizeRasterImg Die Größe des Bildes (Breite und Höhe)
     * @param sizeSquarePattern Die Größe des Musters als Bruchteil der Bildgröße
     * @return Das erzeugte BufferedImage
     */
    public BufferedImage createWallPaperImg(int sizeRasterImg, double sizeSquarePattern) {
        BufferedImage Image = new BufferedImage(sizeRasterImg, sizeRasterImg, 
        		BufferedImage.TYPE_INT_RGB);
        WritableRaster raster = Image.getRaster();
        
        int[] redPixel = {255, 0, 0};
        int[] greenPixel = {0, 255, 0};
        int[] bluePixel = {0, 0, 255};
        
        for (int i = 0; i < sizeRasterImg; i++) {
            for (int j = 0; j < sizeRasterImg; j++) {
                double x = (i * sizeSquarePattern) / sizeRasterImg;
                double y = (j * sizeSquarePattern) / sizeRasterImg;
                int c = (int) (x * x + y * y);
                
                if (c % 3 == 0) {
                    raster.setPixel(i, j, redPixel);
                } else if (c % 3 == 1) {
                    raster.setPixel(i, j, greenPixel);
                } else {
                    raster.setPixel(i, j, bluePixel);
                }
            }
        }
        return Image;
    }
}

