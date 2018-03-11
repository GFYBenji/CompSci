import java.awt.image.BufferedImage;

public class Plot{

    private Double startX, startY, endX, endY;
    private int windowX, windowY;
    private Double plotX, plotY;

    public Plot(Double xS, Double yS, Double xE, Double yE, int winX, int winY) {
        if (xS > xE) {
            startX = xE;
            endX = xS;
        } else {
            startX = xS;
            endX = xE;
        }
        if (yS < yE) {
            startY = yE;
            endY = yS;
        } else {
            startY = yS;
            endY = yE;
        }
        plotX = endX - startX;
        plotY = startY - endY;
        windowX = winX;
        windowY = winY;
    }

    public Plot(Double xS, Double yS, Double xE, Double yE) {
        if (xS > xE) {
            startX = xE;
            endX = xS;
        } else {
            startX = xS;
            endX = xE;
        }
        if (yS < yE) {
            startY = yE;
            endY = yS;
        } else {
            startY = yS;
            endY = yE;
        }
        plotX = endX - startX;
        plotY = startY - endY;
        windowY = windowX = 800;
    }

    public Double convertX(Double x) {
        x = x * plotX / windowX + startX;
        return x;
    }

    public Double convertY(Double y) {
        y = startY - y * plotY / windowY;
        return y;
    }

    public Double getPlotX(){
        return plotX;
    }
    public Double getPlotY(){
        return plotY;
    }


}
