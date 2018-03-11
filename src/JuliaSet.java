import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by benjigarment on 11/03/2018.
 */
public class JuliaSet {

    private final int maxIter = 300;
    private final double zoom = 1;
    private double cY, cX;
    private BufferedImage I;

    public JuliaSet(MyImage image) {
        I = image;
    }

    public BufferedImage draw() {
        cX = -0.7;
        cY = 0.27015;
        double moveX = 0, moveY = 0;
        double zx, zy;
        int w = I.getWidth();
        int h = I.getHeight();

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                zx = 1.5 * (x - w / 2) / (0.5 * zoom * w) + moveX;
                zy = (y - h / 2) / (0.5 * zoom * h) + moveY;
                float i = maxIter;
                while (zx * zx + zy * zy < 4 && i > 0) {
                    double tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    i--;
                }
                int c = Color.HSBtoRGB((maxIter / i) % 1, 1, i > 0 ? 1 : 0);
                I.setRGB(x, y, c);
            }
        }
        return I;
    }
}
