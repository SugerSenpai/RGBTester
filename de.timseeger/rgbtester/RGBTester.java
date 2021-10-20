package de.timseeger.rgbtester;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class RGBTester extends JFrame implements Runnable {
    private GridBagLayout layout;
    private GridBagConstraints gbc;
    private ColorSelection colorSelection;
    private ColorPanel colorPanel;

    private JLabel red,green,blue;
    private JSlider redSlider, greenSlider, blueSlider;
    private JTextField redField, greenField, blueField;
    private JButton redButton, greenButton, blueButton;
    private JTextArea rgbColorCodeCopy;

    public RGBTester(){
        super("RGBTester");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new RGBTester().run();
    }


    @Override
    public void run() {
        initialize();
    }

    public void initialize(){
        layout = new GridBagLayout();
        setLayout(layout);


        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5,5,5,5);

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.gridwidth = 5;
        gbc.gridheight = 1;


        colorSelection = new ColorSelection();
        colorSelection.setColor(128,128,128);
        colorPanel = new ColorPanel(colorSelection);
        add(colorPanel, gbc);

        gbc.gridy = -1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        red = new JLabel("Red");
        add(red, gbc);
        gbc.gridy = -1;
        gbc.gridx = 1;
        redSlider = new JSlider(0, 255, colorSelection.getRed());
        redSlider.setMajorTickSpacing(16);
        redSlider.setPaintTicks(true);
        add(redSlider, gbc);
        gbc.gridx = 2;
        redField = new JTextField(String.valueOf(colorSelection.getRed()));
        add(redField, gbc);
        gbc.gridx = 3;
        redButton = new JButton("Change");
        add(redButton, gbc);

        gbc.gridy = -2;
        gbc.gridx = 0;
        green = new JLabel("Green");
        add(green, gbc);
        gbc.gridy = -2;
        gbc.gridx = 1;
        greenSlider = new JSlider(0, 255, colorSelection.getGreen());
        greenSlider.setMajorTickSpacing(16);
        greenSlider.setPaintTicks(true);
        add(greenSlider, gbc);
        gbc.gridx = 2;
        greenField = new JTextField(String.valueOf(colorSelection.getGreen()));
        add(greenField, gbc);
        gbc.gridx = 3;
        greenButton = new JButton("Change");
        add(greenButton, gbc);


        gbc.gridy = -3;
        gbc.gridx = 0;
        blue = new JLabel("Blue");
        add(blue, gbc);
        gbc.gridy = -3;
        gbc.gridx = 1;
        blueSlider = new JSlider(0, 255, colorSelection.getBlue());
        blueSlider.setMajorTickSpacing(16);
        blueSlider.setPaintTicks(true);
        add(blueSlider, gbc);
        gbc.gridx = 2;
        blueField = new JTextField(String.valueOf(colorSelection.getBlue()));
        add(blueField, gbc);
        gbc.gridx = 3;
        blueButton = new JButton("Change");
        add(blueButton, gbc);

        redSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                colorSelection.setRed(redSlider.getValue());
                redField.setText(String.valueOf(redSlider.getValue()));
                rgbColorCodeCopy.setText(getCodeString());
                colorPanel.repaint();
            }
        });

        greenSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                colorSelection.setGreen(greenSlider.getValue());
                greenField.setText(String.valueOf(greenSlider.getValue()));
                rgbColorCodeCopy.setText(getCodeString());
                colorPanel.repaint();
            }
        });

        blueSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                colorSelection.setBlue(blueSlider.getValue());
                blueField.setText(String.valueOf(blueSlider.getValue()));
                rgbColorCodeCopy.setText(getCodeString());
                colorPanel.repaint();
            }
        });

        redButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int red = Integer.parseInt(redField.getText());
                colorSelection.setRed(red);
                redSlider.setValue(red);
                colorPanel.repaint();
            }
        });

        greenButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int green = Integer.parseInt(greenField.getText());
                colorSelection.setGreen(green);
                greenSlider.setValue(green);
                colorPanel.repaint();
            }
        });

        blueButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int blue = Integer.parseInt(blueField.getText());
                colorSelection.setBlue(blue);
                blueSlider.setValue(blue);
                colorPanel.repaint();
            }
        });

        gbc.gridy = -4;
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;

        rgbColorCodeCopy = new JTextArea(getCodeString());

        add(rgbColorCodeCopy,gbc);

        pack();
    }

    public String getCodeString(){
        return "Decimal Code: ("+colorSelection.getRed() +"," +colorSelection.getGreen()+ "," + colorSelection.getBlue() + ")" + " Hex Code: " + "#" + Integer.toHexString(colorSelection.getColor().getRGB());
    }
}
