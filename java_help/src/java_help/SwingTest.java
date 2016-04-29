package java_help;

import javax.swing.*; //lib for JButton, JFrame
import java.awt.Color;
import java.io.IOException;

public class SwingTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Swing Test");
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setBackground(Color.white);
		
	    ImageIcon icon = new ImageIcon("D:/btn/red_round_button.jpg");
	    ImageIcon pressedIcon = new ImageIcon("D:/btn/grey_round_button.jpg");
	    ImageIcon hoverIcon = new ImageIcon("D:/btn/light_red_round_button.jpg");
	    
	    JButton btn = new JButton();

	    btn.setOpaque(false);
	    btn.setContentAreaFilled(false);
	    btn.setBorderPainted(false);
	    btn.setFocusPainted(false);
	    btn.setSize(100, 100);
	    
	    btn.setIcon(icon);
	    btn.setPressedIcon(pressedIcon);	
	    btn.setRolloverIcon(hoverIcon); //hover icon
	    
	    frame.add(btn);
	}
}
