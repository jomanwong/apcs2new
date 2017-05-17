package uberkalt;

import java.awt.*;
import javax.swing.*;        

public class Window {
	
	public static void createWindow(){
	JFrame frame = new JFrame("Uberkalt");
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JLabel textLabel = new JLabel("Kevin is a...",SwingConstants.CENTER); 
	textLabel.setPreferredSize(new Dimension(300, 200)); 
	
	//3. Create components and put them in the frame.
	//...create emptyLabel...
	
	frame.getContentPane().add(textLabel, BorderLayout.CENTER);
	 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
     frame.setBounds(0,0,screenSize.width, screenSize.height);
	frame.setLocationRelativeTo(null); 

	//5. Show it.
	frame.setVisible(true);
	}

}