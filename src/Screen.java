import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Screen extends JPanel implements MouseListener{

    private MyImage I;
    private JLabel main;
    private int xx, yy, width, height;

    public Screen(MyImage image){
        I = image;
        mandelFrame();
        width = I.getWidth();
        height = I.getHeight();
        //juliaFrame(I);
    }

    private void mandelFrame() {
        JFrame window = new JFrame("MoodleBroot");
        window.setBounds(0,0,I.getWidth(),I.getHeight());
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        main = new JLabel();
        main.setBounds(0,0,I.getWidth(),I.getHeight());
        main.setIcon(new ImageIcon(I));
        main.addMouseListener(this);
        main.setFocusable(true);
        window.add(main);
        window.setVisible(true);
    }

    private void juliaFrame(MyImage image) {
        JFrame window2 = new JFrame("Jellybread");
        window2.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window2.setBounds(0, 0, image.getWidth(), image.getHeight());
        window2.setResizable(false);
        window2.setLocationRelativeTo(null);
        JLabel main2 = new JLabel();
        main2.setBounds(0, 0, window2.getWidth(), window2.getHeight());
        main2.setIcon(new ImageIcon(image));
        window2.add(main2);
        window2.setVisible(true);
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
        double StartX, StartY, EndX, EndY, re, im;
        if (xx == e.getX() || yy == e.getY()) {
            MyImage image = new MyImage(width, height, MyImage.TYPE_INT_RGB);
            image.Plot(-2.0, 2.0, 2.0, -2.0);
            re = image.convertX(xx);
            im = image.convertY(yy);
            Calculator calc = new Calculator(image, 200);
            juliaFrame(calc.juliaSet(re, im));
        } else {
            StartX = I.convertX(xx);
            StartY = I.convertY(yy);
            EndX = I.convertX(e.getX());
            EndY = I.convertY(e.getY());
            I.Plot(StartX, StartY, EndX, EndY);
            Calculator calc = new Calculator(I, 200);
            main.setIcon(new ImageIcon(calc.mandelBrot()));
            repaint();
        }

    }
    @Override
    public void mouseEntered(MouseEvent e) {
        //When the mouse enters the JFrame
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //When the mouse leaves the JFrame
        //System.out.println("Help");
    }
}
