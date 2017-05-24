package game;

import javax.swing.JFrame;

public class MainRunner extends MainAnimation{
	public static void main(String[] args){
		MainAnimation t = new MainAnimation();
		JFrame jf = new JFrame();
		jf.setTitle("MainAnimation"); //name it\
		jf.setSize(windowX, windowY); //see above size (720p)
		jf.setResizable(false); //locked at 720p (1280 x 720)
		jf.setVisible(true); //display on screen
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit command
		jf.add(t);
		
		if(MainAnimation.isGameOver()){
			jf.remove(t);
		}
		//t.paint(null);
		//while(true){
		//System.out.println(MainAnimation.playershot);
		//}
	}

}
