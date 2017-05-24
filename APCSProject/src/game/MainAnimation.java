package game;



/***
 *  find way to shoot, and make bombs drop, then hit reg, and it's done
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;


import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainAnimation extends JPanel implements ActionListener, KeyListener{

	static int windowX = 1280;
	static int windowY = 720;
	int playerWidth = 50; //X
	int playerHeight = 50; //Y

	int numBombs = 9;

	static String playershot = "false";

	//int playerXPos;
	//int playerYPos;

	int projectileY;
	int projectileVelY = 2;


	//boolean paused = false;
	boolean startGame = false;

	Timer tm = new Timer(7, this); //player timer
	//Timer bombtm = new Timer(10, this); //bombs timer
	//x and y are starting positions, starts at bottom center
	int x = windowX/2 - playerWidth/2;
	int y = windowY - playerHeight - 50;

	int velX = 0;
	int velY = 0;

	//int bombVelX = 1; bombs fall downward
	int bombVelY = 1;

	int bombX = 20;
	int bombY = 5;

	static boolean gameOver = false;

	public MainAnimation(){
		tm.start();
		//bombtm.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	public void setVelX(int velX){
		this.velX = velX;
	}

	public void setVelY(int velY){
		this.velY = velY;
		this.bombVelY = 1;
	}




	/*public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(10, 10, 100, 50);
	}*/


	int[] number = new int[numBombs];

	public void rng(){
		int count = 0;
		int num;
		Random r = new Random();
		while(count < number.length){
			num = r.nextInt(numBombs) + 1;
			boolean repeat=false;
			do{
				for(int i = 0; i<number.length; i++){
					if(num == number[i]){
						repeat = true;
						break;
					}
					else if(i == count){
						number[count]=num;
						count++;
						repeat=true;
						break;
					}
				}
			}while(!repeat);

		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Paint.paint(g, Color.RED, x, y, playerWidth, playerHeight); //I am very proud that I made this work ~ Joman

		//g.setColor(Color.RED);
		//g.fillRect(x, y, playerWidth, playerHeight);


		Paint.paint(g, Color.GREEN, 0, 720 - 50, 1280, 50);
		//g.setColor(Color.GREEN);
		//g.fillRect(0, 720 - 50, 1280, 50);



		for(int pos: number){
			//Bomb b = new Bomb(pos);

			Paint.paint(g, Color.BLUE, bombX + pos * 40 + 20, bombY, 40, 64);

			//g.setColor(Color.BLUE); //bomb?
			//g.fillRect(bombX + pos * 40 + 20, bombY, 40, 64); //one width away and at least 20 pixels apart

		}

		/*if(playershot.equals("true")){
			g.setColor(Color.BLACK);
			g.fillRect(x - playerWidth/2, y - playerHeight/2, 10, 16);
			projectileY = y - playerHeight/2;
		}*/

		if(gameOver){
			Paint.paint(g, Color.BLACK, 0, 0, windowX, windowY);
			JFrame frame = new JFrame();
			frame.setLayout(new GridBagLayout());
			JPanel panel = new JPanel();
			JLabel jlabel = new JLabel("Game Over");
			jlabel.setFont(new Font("Verdana",1,20));
			panel.add(jlabel);
			panel.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
			frame.add(panel, new GridBagConstraints());
			frame.setSize(400, 400);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}

		tm.start();	
	}


	/**
	 *  This code is made by Joman Wong, Kevin Wong, Tyler Hackman
	 *  If you're dumb enough to copy off Joman's github and didn't delete this, good luck, idiot.
	 */



	public void actionPerformed(ActionEvent e){
		if(x < 0){ //left side
			velX = 0;
			x = 0;
		} 
		if(x > windowX - playerWidth){ //right side
			velX = 0;
			x = windowX - playerWidth - 7;
		}
		/*if(y < 0){ //top side
			velY = 0;
			y = 0;
		}*/
		/*if(y > windowY - playerHeight){ //down side
			velY = 0;
			y = windowY - 50 - playerHeight;
		}*/

		x = x + velX;
		y = y + velY;

		if(startGame){
			//bombX += bombVelX;
			bombY += bombVelY;
		}

		//projectileY -= projectileVelY;
		hitDetection();
		repaint();
	}

	public void shoot(){
		playershot = "true";
	}

	public void hitDetection(){
		if((bombY + 64) >= (720-50)){
			gameOver = true;
			//JLabel gamOver = new JLabel("Game Over");
			//gameOver.setVisible(true);

		}
	}


	public void keyPressed(KeyEvent e){

		int c = e.getKeyCode();
		if(c == KeyEvent.VK_DOWN) {
			startGame = true; //press down arrow to start game
		}

		if(startGame == true){
			if(c == KeyEvent.VK_LEFT){ //go left
				velX = -4;
				velY = 0;
			}else if(c == KeyEvent.VK_UP){ //shoot
				shoot();
				//playershot = "false"; //is string because test
			}else if(c == KeyEvent.VK_RIGHT){ //go right
				velX = 4;
				velY = 0;
			}

		}
	}

	public void KeyTyped(KeyEvent e){

	}

	public void keyReleased(KeyEvent e){
		velX = 0;
		velY = 0;
	}
	
	public static boolean isGameOver(){
		return gameOver;
	}
}
