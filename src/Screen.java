import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class Screen extends JPanel {

    private JFrame window;
    private JLabel main;
    private int windowX, windowY;
    private Double plotX, plotY;

    public Screen(BufferedImage image){
        window = new JFrame("MoodleBroot");
        window.setBounds(0,0,image.getWidth(),image.getHeight());
        window.setResizable(false);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        main = new JLabel();
        main.setBounds(0,0,image.getWidth(),image.getHeight());
        main.setIcon(new ImageIcon(image));
        window.add(main);
        window.setVisible(true);
    }
}
