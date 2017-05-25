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


class Control implements KeyListener {

	// Set of keys pressed, kinda like key mapping?
	private final Set<Character> pressed = new HashSet<Character>();

	@Override
	public synchronized void keyPressed(KeyEvent e) {
		pressed.add(e.getKeyChar());
		if(pressed.size() == 1){ // if only one key pressed, with shift
			
		}else if (pressed.size() > 1 && e.isShiftDown()) { //multiple keys control, movement as shift is pressed.
			for(int i = 0; i < pressed.size(); i++){ //check first 2 keys after shift
			
			}
			
			
			
			// More than one key is currently pressed.
			// Iterate over pressed to get the keys.
		}
	}

	@Override
	public synchronized void keyReleased(KeyEvent e) {
		pressed.remove(e.getKeyChar());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		/* Not used */ 
	}
}


