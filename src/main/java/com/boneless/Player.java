package com.boneless;

import javax.swing.*;
import java.awt.*;

public class Player extends JPanel {
    public static final int[][] SPRITE = {
            {0,0,0,4,0,0,0},
            {0,0,4,4,4,0,0},
            {4,4,4,4,4,4,4},
            {4,4,4,4,4,4,4},
    };
    public Player(int x, int y){
        setBounds(x,y,70,30);
    }

    private Color parseColor(int color){
        return switch (color){
            case 0 -> Color.white;
            case 1 -> Color.red;
            case 2 -> new Color(255,130,0);
            case 3 -> Color.yellow;
            case 4 -> Color.green;
            case 5 -> Color.blue;
            default -> Color.cyan;
        };
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int pixelSize = 10;
        for(int y = 0; y < SPRITE.length; y++){
            for(int x = 0; x < SPRITE[y].length; x++){
                g.setColor(parseColor(SPRITE[y][x]));
                g.fillRect(x*pixelSize,y*pixelSize,pixelSize,pixelSize);
            }
        }

    }
    @Override
    public void paintBorder(Graphics g){
        //
    }

    public void move(String key){
        int moveAmount = 5;
        switch (key){
            case "a": setBounds(getX() - moveAmount, getY(), getWidth(), getHeight()); break;
            case "d": setBounds(getX() + moveAmount, getY(), getWidth(), getHeight());
        }
    }
}
