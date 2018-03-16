import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

class Screen extends JPanel implements MouseListener{

    private JFrame window;
    private JLabel main, main2;
    private int windowX, windowY;
    private Double plotX, plotY;
    private MyImage I;
    private Double xS, xE, yS, yE, re, im;

    public Screen(MyImage image){
        I = image;
        prepGui(I, JFrame.EXIT_ON_CLOSE);
    }

    private void prepGui(MyImage I, int close){
        window = new JFrame("MoodleBroot");
        window.setBounds(0,0,I.getWidth(),I.getHeight());
        window.setResizable(false);
        window.setDefaultCloseOperation(close);
        window.setLocationRelativeTo(null);
        main = new JLabel();
        main.setBounds(0,0,I.getWidth(),I.getHeight());
        main.setIcon(new ImageIcon(I));
        main.addMouseListener(this);
        main.setFocusable(true);
        window.add(main);
        window.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
            re = I.convertX(e.getX());
            im = I.convertY(e.getY());
            I.Plot(-2.0,2.0,2.0,-2.0);
            Calculator calc = new Calculator(I, 200);
            prepGui(calc.juliaSet(re, im), 2); //Really janky but not sure how to proced at the moment
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        xS = I.convertX(e.getX());
        yS = I.convertY(e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        xE = I.convertX(e.getX());
        yE = I.convertY(e.getY());
        I.Plot(xS,yS,xE,yE);
        System.out.println("xS:" + xS + ",yS: " + yS +"\nxE: " + xE + ",yE: " + yE); //Just making sure the X,Y values are the right way round
        new Calculator(I, 200).mandelBrot();
        main.setIcon(new ImageIcon(I));
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
