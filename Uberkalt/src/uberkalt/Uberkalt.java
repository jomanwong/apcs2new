package uberkalt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Uberkalt extends JPanel implements ActionListener{
	
	Timer tm = new Timer(5, this);
	int x = 0, velX = 2;
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		g.fillRect(x, 30, 50, 30);
		
		tm.start();	
	}
	
	public void actionPerformed(ActionEvent e){
		x = x + velX;
		repaint();
		
	}
	
	public static void main(String[] args){
		Uberkalt u = new Uberkalt();
		JFrame jf = new JFrame();
		jf.setTitle("Uberkalt");
		
		
	}
	
	
}
