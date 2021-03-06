import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class MyScreen extends JPanel implements KeyListener, MouseMotionListener, MouseListener, ActionListener {

    private MyImage I;
    private JLabel main;
    private String title;


    public MyScreen(String upper) {
        title = upper;
        makeGui(2, makeImage(-2.0, 2.0, 2.0, -2.0));
    }

    public void makeGui(int num, MyImage image) {
        JFrame window = new JFrame(title);
        window.setDefaultCloseOperation(num);
        window.setBounds(0, 0, image.getWidth(), image.getHeight());
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.addKeyListener(this);
        window.addMouseListener(this);
        main = new JLabel();
        main.setBounds(0, 0, image.getWidth(), image.getHeight());
        main.setIcon(new ImageIcon(image));
        window.add(main);
        window.setVisible(true);
    }

    public MyImage makeImage(double xS, double yS, double xE, double yE) {
        I = new MyImage(800, 800, BufferedImage.TYPE_INT_RGB);
        I.Plot(-2.0, 2.0, 2.0, -2.0);
        Calculator calc = new Calculator(I, 200);
        return calc.mandelBrot();
    }

    //region Methods
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
        new JuliaScreen("Julia", e.getX(), e.getY());
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
