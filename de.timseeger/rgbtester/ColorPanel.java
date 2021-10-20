package de.timseeger.rgbtester;

import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel {
    ColorSelection selection;

    public ColorPanel(ColorSelection selection){
        this.setPreferredSize(new Dimension(350,350));
        this.selection = selection;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(selection.getColor());
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}

class ColorSelection{
    private int red,green,blue;

    public void setRed(int red){
        this.red = red;
    }

    public void setGreen(int green){
        this.green = green;
    }

    public void setBlue(int blue){
        this.blue = blue;
    }

    public int getRed(){
        return red;
    }

    public int getGreen(){
        return green;
    }

    public int getBlue(){
        return blue;
    }

    public Color getColor() {
        return new Color(red, green, blue);
    }

    public void setColor(int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
}