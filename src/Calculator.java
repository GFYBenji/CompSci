import java.awt.*;
import java.awt.image.BufferedImage;

public class Calculator {

    private int windowX, windowY;
    private int MAX_ITER;
    private Double cIm, cRe, zIm, zRe, tmp;
    private MyImage I;

    public Calculator(MyImage image, int iter){
        I = image;
        MAX_ITER = iter;
    }
    public BufferedImage mandelBrot(){
        for(int y = 0; y < I.getHeight(); y++){
            cIm = I.convertY(y);
            for(int x = 0; x <  I.getWidth(); x++){
                cRe = I.convertX(x);
                zRe = zIm = 0.0;
                int iter = 0;
                while(zRe*zRe + zIm*zIm < 4 && iter < MAX_ITER -1){
                    tmp = zRe*zRe - zIm*zIm + cRe;
                    zIm = 2.0 * zRe*zIm + cIm;
                    zRe = tmp;
                    iter++;
                }

                /*if(iter < MAX_ITER -1){
                    I.setRGB(x,y, Color.white.getRGB());
                }else{
                    I.setRGB(x,y, Color.black.getRGB());
                }
                */
                I.setRGB(x,y, iter);
            }
        }
        return I;
    }
    public BufferedImage juliaSet(){
        cRe= 0.0; // -0.7;
        cIm = 0.0; //0.27015;
        for(int y = 0; y < I.getHeight(); y++){
            zIm = I.convertY(y);
            for (int x = 0; x < I.getWidth(); x ++){
               zRe = I.convertX(x);
               int iter = 0;
               while((zRe+cRe)*(zRe+cRe) + (zIm+cIm)*(zIm+cIm) < 4 && iter < MAX_ITER -1){
                   tmp = zRe *zRe -zIm*zIm +cRe;
                   zIm = 2.0 * zRe*zIm + cIm;
                   zRe = tmp;
                   iter++;
               }
                if(iter < MAX_ITER -1){
                    //I.setRGB(x,y, Color.white.getRGB());
                    I.setRGB(x,y, iter);
                }else{
                    //I.setRGB(x,y, Color.black.getRGB());
                    I.setRGB(x,y, iter);
                }
            }
        }
        return I;
    }

}
