import java.awt.image.BufferedImage;

public class Main {

    public static void main(String args[]) {
        MyImage image = new MyImage(800, 800, BufferedImage.TYPE_INT_RGB);
        image.Plot(-2.0, 2.0, 2.0, -2.0, 800, 800);
        Calculator calc = new Calculator(image, 300);
        Screen window = new Screen(calc.mandelBrot());
        //Screen window = new Screen(calc.juliaSet(0.0,0.0));
    }

}
