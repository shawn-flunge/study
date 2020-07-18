package exam;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel1 extends JPanel {
	
	public JTextField txtOperand1;
	public JTextField txtOperand2;
	
	public JButton btnAdd;
	public JButton btnSubtract;
	public JButton btnMultiply;
	public JButton btnDevide;
	
	public Panel1() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		
		setBackground(Color.orange);
		setBounds(10, 10, 350, 150);
		
		txtOperand1 = new JTextField();
		txtOperand1.setBounds(10, 40, 70, 70);
		
		txtOperand2 = new JTextField();
		txtOperand2.setBounds(90, 40, 70, 70);
		
		
		btnAdd = new JButton("더하기");	
		btnAdd.setBounds(185, 10, 75, 60);
		
		btnSubtract = new JButton("빼기");	
		btnSubtract.setBounds(270, 10, 75, 60);
		
		btnMultiply = new JButton("곱하기");	
		btnMultiply.setBounds(185, 80, 75, 60);
		
		btnDevide = new JButton("나누기");	
		btnDevide.setBounds(270, 80, 75, 60);
		
		add(txtOperand1);
		add(txtOperand2);
		add(btnAdd);
		add(btnSubtract);
		add(btnMultiply);
		add(btnDevide);
	}
	
	
	
	

}
