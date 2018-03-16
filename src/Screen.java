import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

class Screen extends JPanel implements MouseListener{

    private JFrame window;
    private JLabel main;
    private int windowX, windowY;
    private Double plotX, plotY;
    private MyImage I;

    public Screen(MyImage image){
        I = image;
        prepGui(I);
    }

    private void prepGui(MyImage I){
        window = new JFrame("MoodleBroot");
        window.setBounds(0,0,I.getWidth(),I.getHeight());
        window.setResizable(false);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
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
            MyImage im = new MyImage(800,800, BufferedImage.TYPE_INT_RGB);
            im.Plot(-2.0,2.0,2.0,-2.0);
            prepGui(new Calculator(im,200).juliaSet());

        }
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
}
