import javax.swing.*;
import java.awt.event.*;

public class JuliaScreen extends JPanel implements MouseListener, ActionListener, KeyListener, MouseMotionListener {

    private MyImage I;
    private int xx, yy, width, height;
    private JLabel main;
    private Calculator calc;

    JuliaScreen(MyImage image) {
        width = image.getWidth();
        height = image.getHeight();
        I = image;
        //makeGui(2, "Julia", main);
    }

    public void makeGui(int num, String title, JLabel icon) {
        JFrame window = new JFrame(title);
        window.setDefaultCloseOperation(num);
        window.setBounds(0, 0, I.getWidth(), I.getHeight());
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.addKeyListener(this);
        window.addMouseListener(this);
        icon = new JLabel();
        icon.setBounds(0, 0, I.getWidth(), I.getHeight());
        icon.setIcon(new ImageIcon(I));
        window.add(icon);
        window.setVisible(true);

    }

    public MyImage getI() {
        return I;
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
        if (e.getKeyChar() == 'e') {
            I.Plot(-2.0, 2.0, 2.0, -2.0);
            calc = new Calculator(I, 200);
            MandelScreen ms = new MandelScreen(calc.mandelBrot());
            ms.makeGui(2, "Tit", new JLabel());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        xx = e.getX();
        yy = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        double StartX, StartY, EndX, EndY;
        StartX = I.convertX(xx);
        StartY = I.convertY(yy);
        EndX = I.convertX(e.getX());
        EndY = I.convertY(e.getY());
        calc = new Calculator(I, 200);
        I.Plot(StartX, StartY, EndX, EndY);
        calc.juliaSet(0.0, 0.0);
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
