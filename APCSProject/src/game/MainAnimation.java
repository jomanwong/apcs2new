package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainAnimation extends JPanel implements ActionListener, KeyListener{

	static int windowX = 1920;
	static int windowY = 1080;
	int playerWidth = 50; //X
	int playerHeight = 50; //Y

	Timer tm = new Timer(5, this);
	//x and y are starting positions
	int x = 0;
	int y = 0;
	
	int velX = 0;
	int velY = 0;

	public MainAnimation(){
		tm.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void setVelX(int velX){
		this.velX = velX;
	}
	
	public void setVelY(int velY){
		this.velY = velY;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		g.setColor(Color.RED);
		g.fillRect(x, y, playerWidth, playerHeight);

		tm.start();	
	}


	public void actionPerformed(ActionEvent e){
		if(x < 0){ //left side
			velX = 0;
			x = 0;
		} 
		if(x > windowX - playerWidth){ //right side
			velX = 0;
			x = windowX - playerWidth;
		}
		if(y < 0){ //top side
			velY = 0;
			y = 0;
		}
		if(y > windowY - playerHeight){ //down side, go back up top
			velY = 0;
			y = windowY - 70 - playerHeight;
		}

		x = x + velX;
		y = y + velY;
		repaint();
	}

	public void keyPressed(KeyEvent e){

		int c = e.getKeyCode();
			if(c == KeyEvent.VK_A){ //go left
				velX = -6;
				velY = 0;
			}else
			if(c == KeyEvent.VK_W){ //go up
				velX = 0;
				velY = -6;
			}else
			if(c == KeyEvent.VK_S){ //go down
					velX = 0;
					velY = 6;
			}else
			if(c == KeyEvent.VK_D){ //go right
					velX = 6;
					velY = 0;
			}
	}

	public void KeyTyped(KeyEvent e){

	}

	public void keyReleased(KeyEvent e){
		velX = 0;
		velY = 0;
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
