package white_cow_gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Loading extends Thread {

	ImageIcon transp = new ImageIcon("./picture/trans.png");
	String name = null;
	
	public void run() {
		MyFrame.Loading.setBounds(455,100,790,610);
		
		MyFrame.Loading_message.setOpaque(false);
		MyFrame.Loading_message.setBounds(592,524,514,83);
		MyFrame.Loading_message.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 50));
		MyFrame.Loading_message.setForeground(new Color(255,255,255));
		MyFrame.Loading_message.setHorizontalAlignment(JLabel.CENTER);
		
		MyFrame.Loading_message.setText("얼굴 인식중");

		try {
			Loading.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MyFrame.Loading_message.setText("");
		
		try {
			Loading.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MyFrame.Loading_message.setText("얼굴 인식중");
		try {
			Loading.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MyFrame.Loading_message.setText("");
		try {
			Loading.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MyFrame.Loading_message.setText("얼굴 인식중");
		try {
			Loading.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MyFrame.Loading_message.setText("");
		try {
			Loading.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MyFrame.Loading_message.setText("");
		MyFrame.Loading.setIcon(transp);
		
		MyFrame.resultback.setOpaque(true);
		MyFrame.resultback.setBounds(13,82,1236,776);
		MyFrame.resultback.setBackground(new Color(35,31,56));

		/*
		status.setText("");
		message.setText("");
		timer.setText("");
		time.flag2 = false;
		
		pro1.setText("");
		pro2.setText("");
		pro3.setText("");
		pro4.setText("");
		pro5.setText("");
		pro6.setText("");
		SUM.setText("");

		paybutton_basic.setIcon(transp);*/
		//63,60,82 - 기본색상
//////////////결과 화면 라벨들 //////////////////////////////////////
    	//////////////결과 화면 라벨들 //////////////////////////////////////
    	

    	MyFrame.back1.setBounds(186, 132, 989, 80); 
    	MyFrame.back1.setOpaque(true);
    	MyFrame.back1.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 35));
    	MyFrame.back1.setBackground(new Color(6,99,76));
    	
    	//Main.readuserdata();
    	
    	try {
			Loading.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	MyFrame.back1.setText(MyGlobals.getInstance().getId().split("_")[0] + "님 - 얼굴인식 완료!");
    	MyFrame.back1.setHorizontalAlignment(JLabel.CENTER);
    	MyFrame.back1.setForeground(new Color(245,248,6));
    	MyFrame.checked.setBounds(112,139,61,61);
  
    	MyFrame.checked.setBounds(112,276,61,61);
    	MyFrame.back1.setBackground(new Color(63,60,82));
    	
    	MyFrame.back2.setBounds(186, 277, 989, 80); 
    	MyFrame.back2.setBackground(new Color(6,99,76));
    	MyFrame.back2.setOpaque(true);
    	MyFrame.back2.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 40));
    	MyFrame.back2.setBackground(new Color(6,99,76));
    	MyFrame.back2.setText("결제 비밀번호를 입력해 주십시오.");
    	MyFrame.back2.setHorizontalAlignment(JLabel.CENTER);
    	MyFrame.back2.setForeground(new Color(255,255,255));
    	try {
			Loading.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//MyFrame.back3.setBounds(186, 422, 989, 80); 
    	//MyFrame.back3.setOpaque(true);
    	//MyFrame.back3.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 20));
    	//MyFrame.back3.setBackground(new Color(63,60,82));
    	
    	//back4.setBounds(88, 567, 1092, 264); 
    	//back4.setOpaque(true);
    	//back4.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 20));
    	//back4.setBackground(new Color(63,60,82));

    	//////////////결과 화면 라벨들 //////////////////////////////////////
    	//////////////결과 화면 라벨들 //////////////////////////////////////
	}
	
}
