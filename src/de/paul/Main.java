package de.paul;


import de.paul.players.Player;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        createFrame();
        createPlayers();
    }


    public static void createFrame() {
        Variables.frame = new JFrame();
        Variables.frame.setVisible(true);
        Variables.frame.setBounds(0, 0, 1000, 500);
        Variables.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Variables.frame.setTitle("Pauls Pong");
        Variables.frame.setLayout(null);
        Variables.frame.setResizable(false);

        Variables.frame.getContentPane().setBackground(Color.BLACK);
    }

    public static void createPlayers() {
        Variables.p1 = new Player(Variables.frame, 20, 175, Player.remoteKindWS);
        Variables.p2 = new Player(Variables.frame, 960, 175, Player.remoteKindArrows);
    }
}