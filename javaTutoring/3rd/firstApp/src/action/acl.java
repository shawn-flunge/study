package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import exam.Panel1;
import exam.Panel2;

public class acl implements ActionListener {
	
	Panel1 pan1;
	Panel2 pan2;
	
	public acl(Panel1 p, Panel2 p2) {
		// TODO Auto-generated constructor stub
		pan1=p;
		pan2=p2;	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getActionCommand()=="»©±â") {
			int a, b;
			
			a = Integer.parseInt(pan1.txtOperand1.getText());
			b = Integer.parseInt(pan1.txtOperand2.getText());
			
			pan2.txt.setText( Integer.toString(a-b));
		}
		
	}

}
