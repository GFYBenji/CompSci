import javax.swing.*;
import java.awt.event.MouseEvent;

public class MandelScreen extends JuliaScreen {

    private MyImage I;
    private JLabel main;

    MandelScreen(MyImage image) {
        super(image);
        I = image;
        //makeGui(3,"Mandel", main);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Moodlebroot clique");
    }
}
