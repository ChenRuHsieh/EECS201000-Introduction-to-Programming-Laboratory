package game;

import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;


public class SnakeGame extends JFrame{
	public SnakeGame() {
		super("Greedy Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //add(new SinglePlayerPanel());
		add(new PlayerPanel());
        //removeAll();
        //add(new SinglePlayerPanel());
        pack();
        setVisible(true);
	}
	
	public static void main(String[] arg0) {
		SnakeGame game = new SnakeGame();
	}
}

