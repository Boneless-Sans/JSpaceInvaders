package com.boneless;

import com.boneless.util.JsonFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

@SuppressWarnings({"BusyWait", "CallToPrintStackTrace"})
public class Main extends JFrame implements KeyListener {

    private boolean running = true;
    private int score = 0;
    private int level = 0;
    private int fireCooldown = 100;

    private Player player;
    private final ArrayList<Alien> aliens = new ArrayList<>();
    private ArrayList<Blocker> blockers;

    public Main(){
        int scaleFactor = 3;
        setSize(224 * scaleFactor, 256 * scaleFactor);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(this);
        init();
        setVisible(true);
    }



    private void init(){
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);

        //init player
        player = new Player(getWidth(), getHeight() - 30);

        for(int i = 0; i < level; i++){
            int spacer = 0;
        }

        add(player);
        for(int i = 0; i < 10; i++){
            Alien test = new Alien(200,100);
            aliens.add(test);
            add(test);
        }
        run();
    }

    private void run(){
        new Thread(() -> {
            while(running) {
                try {
                    //updateTick();
                    Thread.sleep(16); //about 60fps
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void updateTick(){
        // Make each alien move with each tick.
        for(Alien alien : aliens){
            alien.moveStart();
        }
    }

    private String parseKeyStrokeInput(String binding){
        String key = JsonFile.read("settings.json","keybindings", binding);
        return switch (key){
            case "Esc" -> "\u001B";
            case "Space" -> " ";
            case "Enter" -> "\n";
            case "Backspace" -> "\b";
            default -> key.toLowerCase();
        };
    }

    @Override
    public void keyTyped(KeyEvent e) {
        player.move(String.valueOf(e.getKeyChar()).toLowerCase());
        aliens.getFirst().nigger();
    }

    @Override public void keyPressed(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) { }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}