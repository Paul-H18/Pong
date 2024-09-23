package de.paul.players;

import de.paul.Variables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player {

    public static int remoteKindWS = 0, remoteKindArrows = 1;

    private JPanel bar;
    private int x, y;

    private int remoteKind;

    public Player(JFrame frame, int x, int y, int remoteKind) {
        this.x = x;
        this.y = y;

        this.remoteKind = remoteKind;


        this.initBar();
        frame.add(this.bar);
        frame.addKeyListener(this.getKeyAdapterUp());
        frame.addKeyListener(this.getKeyAdapterDown());

    }

    private void moveBar(int value) {
        int desiredPosition = this.y + (value * Variables.playerMovementSpeedMultiplicator);
        if(desiredPosition >= 0 && desiredPosition <= 340) {
            this.y = desiredPosition;
            this.bar.setBounds(this.x, this.y, 20, 150);
        }
    }

    private void initBar() {
        this.bar = new JPanel();
        this.bar.setBounds(this.x, this.y, 20, 150);
        this.bar.setBackground(Color.WHITE);
    }

    private KeyAdapter getKeyAdapterUp() {
        if(this.remoteKind == 0) {
            return new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    super.keyPressed(e);
                    if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W') {
                        System.out.println("W");
                        moveBar(-1);
                    }
                }
            };
        }

        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    System.out.println("Arrow Up pressed");
                    moveBar(-1);
                }
            }
        };

    }

    private KeyAdapter getKeyAdapterDown() {
        if(this.remoteKind == 0) {
            return new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    super.keyPressed(e);
                    if (e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
                        System.out.println("S");
                        moveBar(1);
                    }
                }
            };
        }

        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    System.out.println("Arrow Up pressed");
                    moveBar(1);
                }
            }
        };

    }
}
