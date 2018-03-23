import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class JuliaScreen extends MandelScreen {


    private int xx, yy, width, height;
    private JLabel main;
    private Calculator calc;

    JuliaScreen() {
        MyImage I = new MyImage(800, 800, BufferedImage.TYPE_INT_RGB);
        I.Plot(-2.0, 2.0, 2.0, -2.0);
        Calculator calc = new Calculator(I, 200);
        makeGui(2, "Julia", calc.juliaSet(0.0, 0.0));
    }

    //region methods
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    //endregion
}
