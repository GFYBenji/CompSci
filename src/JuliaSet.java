import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by benjigarment on 11/03/2018.
 */
public class JuliaSet {

    private final int maxIter = 300;
    private final double zoom = 1;
    private double cRe, cIm;
    private MyImage I;

    public JuliaSet(MyImage image) {
        I = image;
    }

    public BufferedImage draw() {
        cRe = -0.7;
        cIm = 0.27015;
        double moveX = 0, moveY = 0;
        double zRe, zIm;
        int w = I.getWidth();
        int h = I.getHeight();

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                zRe = I.convertX(x); //1.5 * (x - w / 2) / (0.5 * zoom * w) + moveX;
                zIm = I.convertY(y);//(y - h / 2) / (0.5 * zoom * h) + moveY;
                float i = maxIter;
                while (zRe * zRe + zIm * zIm < 4 && i > 0) {
                    double tmp = zRe * zRe - zIm * zIm + cRe;
                    zIm = 2.0 * zRe * zIm + cIm;
                    zRe = tmp;
                    i--;
                }
                /*int c = Color.HSBtoRGB((maxIter / i) % 1, 1, i > 0 ? 1 : 0);
                I.setRGB(x, y, c);*/
            }
        }
        return I;
    }
}
