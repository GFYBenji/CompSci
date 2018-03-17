import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Screen extends JPanel implements MouseListener{

    private JLabel main; // i need some way to set the image of the Juliaset window without changing the mandelbrot window
    private int windowX, windowY;
    private Double plotX, plotY;
    private MyImage I;
    private Double xS, yS;

    public Screen(MyImage image){
        I = image;
        mandelFrame();
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
        if (e.isAltDown()) { //Using a key modifier so that when executing the double click for the Julia Set it doesnt execute both
            //Mandelbrot zoom
            xS = I.convertX(e.getX());
            yS = I.convertY(e.getY());
        }
        if (e.getClickCount() == 2) {
            //Juliaset
            Double re, im;
            I.Plot(-2.0, 2.0, 2.0, -2.0);
            re = I.convertX(e.getX());
            im = I.convertY(e.getY());
            Calculator calc = new Calculator(I, 200);
            juliaFrame(calc.juliaSet(re, im));
            System.out.println("Jesus is the bread");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.isAltDown()) {
            Double xE, yE;
            xE = I.convertX(e.getX());
            yE = I.convertY(e.getY());
            I.Plot(xS, yS, xE, yE);
            Calculator calc = new Calculator(I, 200);
            main.setIcon(new ImageIcon(calc.mandelBrot()));
            repaint();
            System.out.println("Memes r cool");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //When the mouse enters the JFrame
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //When the mouse leaves the JFrame
    }
}
