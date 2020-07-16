package exam;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class firstapp extends JFrame {

	
	public firstapp() {
		// TODO Auto-generated constructor stub
		this.setLayout(null);
		
		
		JPanel panel1 = new JPanel();
		panel1.setSize(200, 100);
		panel1.setBackground(Color.PINK);
		
		JButton btn = new JButton("¹öÆ°");
		btn.setBounds(10, 10, 50, 50);
		
		//JTextArea txt = new JTextArea("afa");
		JTextField txt1 = new JTextField();
		txt1.setBounds(70,10,100,50);
		txt1.setBackground(Color.GREEN);
		
		panel1.setLayout(null);
		
		panel1.add(txt1);
		panel1.add(btn);
		this.add(panel1);
		
		setBounds(10, 10, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
