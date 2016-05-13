package java_help;

import javax.swing.*;
import java.awt.Color;
import java.io.IOException;

public class RoundButton extends JButton {
  
  public static RoundButton CreateRoundButton(String idle, String pressed, String hover, int width, int height){
	  	ImageIcon icon = new ImageIcon(idle);
	    ImageIcon pressedIcon = new ImageIcon(pressed);
	    ImageIcon hoverIcon = new ImageIcon(hover);
	    
	    RoundButton btn = new RoundButton();
	
	    btn.setOpaque(false);
	    btn.setContentAreaFilled(false);
	    btn.setBorderPainted(false);
	    btn.setFocusPainted(false);
	    btn.setSize(width, height);
	    
	    btn.setIcon(icon);
	    btn.setPressedIcon(pressedIcon);	
	    btn.setRolloverIcon(hoverIcon);
	    
	    return(btn);
  }

// Test routine.
	public static void main(String[] args) throws IOException {

		  JFrame frame = new JFrame("Swing Test");
			frame.setVisible(true);
			frame.setSize(500, 500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.getContentPane().setBackground(Color.white);
		    
		    String idle = "src/red_round_button.jpg";
		    String pressed = "src/grey_round_button.jpg";
		    String hover = "src/light_red_round_button.jpg";
		    
		    RoundButton btn = RoundButton.CreateRoundButton(idle, pressed, hover, 100, 100);
		    
		    frame.add(btn);
	}
}
