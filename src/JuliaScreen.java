import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class JuliaScreen extends MyScreen {


    private int xx, yy, width, height;
    private JLabel main;
    private Calculator calc;
    //private double xS, yS, xE, yE;
    private int im, re;

    JuliaScreen(String title, int re, int im) {
        super(title);
        this.re = re;
        this.im = im;

    }
    @Override
    public MyImage makeImage(double xS, double yS, double xE, double yE) {
        MyImage image = new MyImage(800, 800, BufferedImage.TYPE_INT_RGB);
        image.Plot(xS, yS, xE, yE);
        Calculator calc = new Calculator(image, 200);
        //return calc.juliaSet(image.convertX(re),image.convertY(im));
        return calc.juliaSet(0.285, 0.01);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

}
