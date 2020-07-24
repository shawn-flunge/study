package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import thread.ThreadEx;

public class FrameEx extends JFrame {

	JLabel lblHour;
	JLabel lblminute;
	JLabel lblsecond;
	
	public FrameEx() {
		// TODO Auto-generated constructor stub
	
		setLayout(null);
		JPanel pan = new JPanel();	
	
		pan.setBounds(5, 5, 460, 300);
		pan.setBackground(Color.pink);
		
		String hour="2";
		lblHour = new JLabel(hour);
		String minute="3";
		lblminute = new JLabel(minute);
		String second="4";
		lblsecond = new JLabel(second);
		
		lblHour.setFont(new Font("πŸ≈¡",Font.BOLD,30));
		lblminute.setFont(new Font("πŸ≈¡",Font.BOLD,30));
		lblsecond.setFont(new Font("πŸ≈¡",Font.BOLD,30));
		
		pan.add(lblHour);
		pan.add(lblminute);
		pan.add(lblsecond);
		
		
		add(pan);
		setBounds(10, 10, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		ThreadEx tt = new ThreadEx(lblHour, lblminute, lblsecond);
		tt.start();
		
		
	}
	

	public static void main(String[] args) {
		FrameEx ex = new FrameEx();
	}
	
}
