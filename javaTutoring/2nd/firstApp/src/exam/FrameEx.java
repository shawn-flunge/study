package exam;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameEx extends JFrame{


	
	public FrameEx() {
		this.setLayout(null);	
			
		Init();
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(10, 10, 400, 400);
		
	}
	

	
	public void Init() {		
			
		Panel1 pan1 = new Panel1();
		Panel2 pan2 = new Panel2();
		
		add(pan1);
		add(pan2);
	}
	
	
	
	
	
}
