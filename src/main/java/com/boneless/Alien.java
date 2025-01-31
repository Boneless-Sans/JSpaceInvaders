package com.boneless;

import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Alien extends JPanel {
    public boolean doFrameOne = true;
    public static final int[][] SPRITE1 = {
            {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0},
    };

    public static final int[][] SPRITE2 = {
            {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
    };
    public static final int[][] SPRITE69 = {
            {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
    };


    public Alien(int x, int y) {
        setBounds(x,y, 60, 40);
        setBackground(Color.white);

        JLabel sprite = new JLabel();
    }

    public int tickCount = 0;


    public void moveStart() {
        tickCount++;
        if(tickCount == 30){
            doFrameOne = !doFrameOne;
            //setBounds(getX() - 10, getY(), getWidth(), getHeight());
        }
        if(tickCount == 30){
            tickCount = 0;
        }
        revalidate();
        repaint();
    }

    private Color parseColor(int color) {
        return switch (color) {
            case 0 -> Color.cyan;
            case 1 -> Color.white;
            case 2 -> new Color(255, 130, 0);
            case 3 -> Color.yellow;
            case 4 -> Color.green;
            case 5 -> Color.blue;
            case 6 -> Color.black;
            case 7 -> Color.red;
            default -> Color.cyan;
        };
    }

    void nigger(){
        doFrameOne = !doFrameOne;
        System.out.println(doFrameOne);
    }

//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g); //un-comment for debugging
//        int pixelSize = 5;
//        for (int y = 0; y < SPRITE1.length; y++) {
//            for (int x = 0; x < SPRITE1[y].length; x++) {
//                g.setColor(parseColor(doFrameOne ? SPRITE1[y][x] : SPRITE2[y][x]));
//                doFrameOne = !doFrameOne;
//                g.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
//            }
//        }
//
//    }

    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g); //un-comment for debugging
        int pixelSize = 5;
        new Thread(() -> {
            for (int y = 0; y < SPRITE1.length; y++) {
                for (int x = 0; x < SPRITE1[y].length; x++) {
                    int[][] sprite = doFrameOne ? SPRITE1 : SPRITE69;
                    g.setColor(parseColor(sprite[y][x]));
                    doFrameOne = !doFrameOne;
                    g.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
                }
            }
        }).start();

    }

    @Override
    public void paintBorder(Graphics g) {
        //
    }

//    public static class Alien1 extends Alien {
//
//        public static final int[][] SPRITE1 = {
//                {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0},
//                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
//                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                {1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1},
//                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
//                {0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0},
//                {0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0},
//                {0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0},
//        };
//    }
}
