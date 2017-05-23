package game;



/***
 *  find way to shoot, and make bombs drop, then hit reg, and it's done
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainAnimation extends JPanel implements ActionListener, KeyListener{

	static int windowX = 1280;
	static int windowY = 720;
	int playerWidth = 50; //X
	int playerHeight = 50; //Y

	//int playerXPos;
	//int playerYPos;


	//boolean paused = false;
	boolean startGame = false;

	Timer tm = new Timer(5, this); //player timer
	Timer bombtm = new Timer(5, this); //bombs timer
	//x and y are starting positions, starts at bottom center
	int x = windowX/2 - playerWidth/2;
	int y = windowY - playerHeight - 50;

	int velX = 0;
	int velY = 0;

	int bombVelX = 2;
	int bombVelY = 2;

	public MainAnimation(){
		tm.start();
		bombtm.start();
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
		g.drawRect(0, 720 - 50, 1280, 50);
		g.setColor(Color.GREEN);
		g.fillRect(0, 720 - 50, 1280, 50);
		tm.start();	
		bombFalling(null);
	}

	public void bombFalling(Graphics g){
		//for(int i - 0; i < 8){
		//int randomNum = ThreadLocalRandom.current().nextInt(1, 10 + 1); // [1, 10]
		//}
		int[] number = new int[7]; //7 bombs each wave
		int count = 0;
		int num;
		Random r = new Random();
		while(count<number.length){
			num = r.nextInt(11); //pseudorandom [1, 11], because + 1 later, no repeats
			boolean repeat=false;
			do{
				for(int i = 0; i < number.length; i++){
					if(num == number[i]){
						repeat = true;
						break;
					}
					else if(i == count){
						number[count] = num + 1;
						count++;
						repeat = true;
						break;
					}
				}
			}while(!repeat);
		}
		for(int i = 0; i < number.length; i++){ //make 7 bombs
			g.drawRect(20*number[i], 50, 20, 50);
			g.setColor(Color.BLACK);
			g.fillRect(20*number[i], 50, 20, 50);
			bombtm.start();
		}
	}



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
		repaint();
	}

	public void shoot(Graphics g){
		super.paintComponent(g);

		g.setColor(Color.BLACK);
		g.fillRect(x - playerWidth/2, y - playerHeight/2, 5, 10);
	}

	/*public void hitDetection(){
		could be done in shoot
	}*/


	public void keyPressed(KeyEvent e){

		int c = e.getKeyCode();
		if(c == KeyEvent.VK_DOWN) {
			startGame = true; 				//press down arrow to start game
		}

		if(startGame == true){
			if(c == KeyEvent.VK_LEFT){ //go left
				velX = -6;
				velY = 0;
			}else if(c == KeyEvent.VK_UP){ //shoot
				shoot(null);
			}else if(c == KeyEvent.VK_RIGHT){ //go right
				velX = 6;
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

	public static void main(String[] args){
		MainAnimation t = new MainAnimation();
		JFrame jf = new JFrame();
		jf.setTitle("MainAnimation"); //name it
		jf.setSize(windowX, windowY); //see above size (720p)
		jf.setResizable(false); //locked at 720p (1280 x 720)
		jf.setVisible(true); //display on screen
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit command
		jf.add(t);
		t.paint(null);
	}

}
