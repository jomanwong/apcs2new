package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainAnimation extends JPanel implements ActionListener{
	
	static int windowX = 1280;
	static int windowY = 720;
	int playerWidth = 50; //X
	int playerHeigth = 50; //Y
	
	Timer tm = new Timer(5, this);
	Timer tm2 = new Timer(5, this);
	int x = 0, velX = 2;

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		g.fillRect(x, playerHeigth, playerWidth, playerHeigth);
		
		tm.start();	
	}
	
	public void actionPerformed(ActionEvent e){
		if(x < 0 || x > windowX - playerWidth){
			velX = -velX;
		}
		x = x + velX;
		repaint();
	}
	
	public static void main(String[] args){
		MainAnimation t = new MainAnimation();
		JFrame jf = new JFrame();
		jf.setTitle("MainAnimation");
		jf.setSize(windowX, windowY);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);
	}
	
}