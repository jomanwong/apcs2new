package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paint {
	public static void paintRect(Graphics g, Color c, int x, int y, int w, int l){
		g.setColor(c);
		g.fillRect(x, y, w, l);
		
	}
}
