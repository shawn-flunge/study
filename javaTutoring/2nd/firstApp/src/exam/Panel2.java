package exam;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel2 extends JPanel {

	public JTextField txt;
	
	public Panel2() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		
		setBackground(Color.pink);
		setBounds(10, 180, 350, 100);
		
		txt = new JTextField("¡§¥‰¿∫/?");
		txt.setBounds(50, 20, 250 , 60);
		txt.setBackground(Color.white);
		
		txt.setFont(new Font("πŸ≈¡",Font.BOLD,30));
		txt.setHorizontalAlignment(JTextField.CENTER);
		
		add(txt);
	}
	
}
