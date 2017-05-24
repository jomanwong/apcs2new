package game;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class ColdWar extends JFrame implements Variables {

    public ColdWar() {

        launch(); //self explanatory
        
    }

    private void launch() {

        add(new Panel()); //starts creating a new panel
        setTitle("ColdWar");  //name
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Close
        setSize(BOARD_WIDTH, BOARD_HEIGHT);  //sizing
        setLocationRelativeTo(null); // Window location
        setResizable(false); //we set it to a certain size so it doesn't look weird when size is changed
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> { //apparently that's how you do it
        	ColdWar ex = new ColdWar();  //new ColdWar, which then calls launch, sets the panel specs
            ex.setVisible(true);  //after setting the size and locations, time to make panel visible on screen
        });
        
    }
}