package exam;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import calculator.Calculator;
import action.acl;

public class FrameEx extends JFrame implements ActionListener{

	Panel1 pan1;
	Panel2 pan2;
	Calculator calc;
	
	acl acl;
	
	public FrameEx() {
		this.setLayout(null);	
			
		Init();
		
		pan1.btnAdd.addActionListener(this);
		pan1.btnSubtract.addActionListener(acl);
		
		ActionListener ac = new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getActionCommand()=="곱하기") {
					int a, b,c;
					
					a = Integer.parseInt(pan1.txtOperand1.getText());
					b = Integer.parseInt(pan1.txtOperand2.getText());
					
					c= calc.multiply(a, b);
					pan2.txt.setText(String.valueOf(c));	
				}
			}
		};
		
		pan1.btnMultiply.addActionListener(ac);	
		
		pan1.btnDevide.addActionListener(this);	
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(10, 10, 400, 400);
		
	}
	
	
	public void Init() {		
			
		pan1 = new Panel1();
		pan2 = new Panel2();
		calc = new Calculator();
		
		acl = new acl(pan1,pan2);
		
		add(pan1);
		add(pan2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand()=="더하기") {
			int a, b,c;
			
			a = Integer.parseInt(pan1.txtOperand1.getText());
			b = Integer.parseInt(pan1.txtOperand2.getText());
			
			c= calc.add(a, b);
			pan2.txt.setText(String.valueOf(c));	
			
		}else if(e.getActionCommand()=="곱하기") {
			
		}else {	//나누기
			double a,b,c;
			a = (double)Integer.parseInt(pan1.txtOperand1.getText());
			b =(double)Integer.parseInt(pan1.txtOperand2.getText());
			
			c=calc.devide(a, b);
			pan2.txt.setText(String.valueOf(c));
		}		
		
	}


	
	
	
	
	
}
