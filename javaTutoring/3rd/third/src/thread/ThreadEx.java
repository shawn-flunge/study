package thread;

import javax.swing.JLabel;

public class ThreadEx extends Thread {
	
	JLabel lblHour;
	JLabel lblMinute;
	JLabel lblSecond;
	
	int hour;
	int minute;
	int second;
	
	public ThreadEx(JLabel lbl1,JLabel lbl2,JLabel lbl3) {
		// TODO Auto-generated constructor stub
		lblHour = lbl1;
		lblMinute = lbl2;
		lblSecond = lbl3;
		hour=0;
		minute=0;
		second=0;
	}
	
	@Override
	public void run() {
		while(true) {
			second ++;
			lblSecond.setText(String.valueOf(second));
			if(second ==60) {
				minute++;
				second=0;
			}
				
			lblMinute.setText(String.valueOf(minute));
			if(minute == 60) {
				hour++;
				minute=0;
			}
				
			lblHour.setText(String.valueOf(hour));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
