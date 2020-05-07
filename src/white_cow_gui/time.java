package white_cow_gui;

import java.util.Random;

public class time extends Thread{
	
	//int timer;
	
	Random random = new Random();
	int n = 0;
	static boolean flag2 = true;
	public time() {
		//this.timer = a;
	}
	
	public void run() {
		
		MyFrame.timer.setText(Integer.toString(MyFrame.timer_time));
		try {
			time.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MyFrame.timer_time = MyFrame.timer_time - 1;
		MyFrame.timer.setText(Integer.toString(MyFrame.timer_time));
		try {
			time.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MyFrame.timer_time = MyFrame.timer_time - 1;
		MyFrame.timer.setText(Integer.toString(MyFrame.timer_time));
		try {
			time.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MyFrame.timer.setText("");
		MyFrame.message.setText("결제 비밀번호를 입력하면 인식이 진행됩니다.");
		
		while(flag2)
		{
			n = random.nextInt(40)+60;
			MyFrame.random.setText(Integer.toString(n)+"%");
			try {
				time.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		MyFrame.random.setText("");
	
	}
}
