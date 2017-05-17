package uberkalt;

import java.awt.*;
import javax.swing.*;        

public class Window {

	public static void Window(String name){
		JFrame frame = new JFrame(name);
	}

	public static void createWindow(JFrame name){

		name.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel textLabel = new JLabel("Kevin is a...",SwingConstants.CENTER); 
		textLabel.setPreferredSize(new Dimension(300, 200)); 

		//3. Create components and put them in the frame.
		//...create emptyLabel...

		name.getContentPane().add(textLabel, BorderLayout.CENTER);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		name.setBounds(0,0,screenSize.width, screenSize.height);
		name.setLocationRelativeTo(null); 

		//5. Show it.
		name.setVisible(true);
	}

}