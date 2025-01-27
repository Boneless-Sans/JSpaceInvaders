package com.boneless;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Main extends JFrame implements KeyListener {

    private boolean running = false;
    private int score = 0;
    private int level = 0;

    private Player player;
    private ArrayList<Alien> aliens;
    private ArrayList<Blocker> blockers;

    public Main(){
        setSize(480, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        init();
        setVisible(true);
    }

    private void init(){
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);

        player = new Player();

        for(int i = 0; i < level; i++){

        }

        running = true;
    }

    private void run(){
        while(running){
            //

        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override public void keyPressed(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}