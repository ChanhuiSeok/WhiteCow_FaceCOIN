package white_cow_gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class LoadingTwo extends Thread{
	
	
	public void run() {
		System.out.println("����!!!");
		Main.data_exist = true;
		//status.setText("���� �������Դϴ�");
		//status.setForeground(new Color(255,227,70));
		
		MyFrame.checked.setBounds(112,276,61,61);
		MyFrame.back2.setText("��й�ȣ�� ��ġ�մϴ�.");
		MyFrame.back2.setForeground(new Color(245,248,6)); //��Ʈ����
		try {
			LoadingTwo.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MyFrame.back2.setBackground(new Color(63,60,82)); // �󺧹�� ���� ������ ����

		MyFrame.checked.setBounds(112,423,61,61);
		
		MyFrame.back3.setBounds(186, 422, 989, 80); 
		MyFrame.back3.setOpaque(true);
		MyFrame.back3.setBackground(new Color(6,99,76));
		MyFrame.back3.setFont(new Font("���� ����� 230", Font.PLAIN, 40));
		MyFrame.back3.setText("���ü�� ���� �������Դϴ�");
		MyFrame.back3.setHorizontalAlignment(JLabel.CENTER);
		MyFrame.back3.setForeground(new Color(255,255,255));
		try {
			LoadingTwo.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		///////////////////////////���ü�� ���� ���� �ϴ� �ڵ� �ۼ� ////////////////////

    	MyGlobals.getInstance().setPriceSum(MyFrame.priceSum);
    	NoobChain.Auto(Main.userdata[0],"Mart",MyGlobals.getInstance().getPriceSum());
    	//NoobChain.walletHash.get("Kimheewon").getBalance();
    	
    	/////////////////////////////////////////////////////////////////
		
    	
		//back4.setBounds(88, 567, 1092, 264); 
    	//back4.setOpaque(true);
    	//back4.setFont(new Font("���� ����� 230", Font.PLAIN, 20));
    	//back4.setBackground(new Color(63,60,82));
    	
    	MyFrame.back3.setBackground(new Color(63,60,82));
    	MyFrame.back3.setText("������ �Ϸ�Ǿ����ϴ�!");
    	MyFrame.back3.setForeground(new Color(245,248,6));
    	
    	/////////////////////////////////���ü�� ���� �Ϸ� �� �ߴ� ȭ��////////////
    	/////////////////////////////////���ü�� ���� �Ϸ� �� �ߴ� ȭ��////////////
    	MyFrame.back5_complete.setFont(new Font("���� ����� 230", Font.PLAIN, 40));
    	MyFrame.back5_complete.setOpaque(true);
    	MyFrame.back5_complete.setText("���� ����");
    	MyFrame.back5_complete.setBounds(510,556,296,70);
    	MyFrame.back5_complete.setBackground(new Color(36,23,93));
    	MyFrame.back5_complete.setForeground(new Color(255,255,255));
    	MyFrame.back5_complete.setHorizontalAlignment(JLabel.CENTER);
    	MyFrame.checked.setBounds(112,423,61,61);
		
    	MyFrame.back6_payment.setFont(new Font("���� ����� 230", Font.PLAIN, 40));
    	MyFrame.back6_payment.setForeground(new Color(255,255,255));
    	MyFrame.back6_payment.setOpaque(true);
    	MyFrame.back6_payment.setBounds(264,636,296,70);
    	MyFrame.back6_payment.setBackground(new Color(36,23,93));
    	MyFrame.back6_payment.setText("���� �ݾ�");
    	MyFrame.back6_payment.setHorizontalAlignment(JLabel.CENTER);
		
		
    	MyFrame.back7_jan.setFont(new Font("���� ����� 230", Font.PLAIN, 40));
    	MyFrame.back7_jan.setForeground(new Color(255,255,255));
    	MyFrame.back7_jan.setOpaque(true);
    	MyFrame.back7_jan.setBounds(264,718,296,70);
    	MyFrame.back7_jan.setBackground(new Color(36,23,93));
    	MyFrame.back7_jan.setText("�ܾ�");
    	MyFrame.back7_jan.setHorizontalAlignment(JLabel.CENTER);
		
		
    	MyFrame.back8_payment2.setFont(new Font("���� ����� 230", Font.PLAIN, 40));
    	MyFrame.back8_payment2.setForeground(new Color(255,255,255));
    	MyFrame.back8_payment2.setOpaque(true);
    	MyFrame.back8_payment2.setBounds(606,636,422,70);
    	MyFrame.back8_payment2.setBackground(new Color(36,23,93));
    	MyFrame.back8_payment2.setText(Integer.toString(MyFrame.priceSum));
    	MyFrame.back8_payment2.setHorizontalAlignment(JLabel.CENTER);

    	MyFrame.back9_jan2.setFont(new Font("���� ����� 230", Font.PLAIN, 40));
    	MyFrame.back9_jan2.setForeground(new Color(255,255,255));
    	MyFrame.back9_jan2.setOpaque(true);
    	MyFrame.back9_jan2.setBounds(606,718,422,70);
		MyFrame.back9_jan2.setBackground(new Color(36,23,93));
		MyFrame.back9_jan2.setText(Integer.toString((int)NoobChain.walletHash.get(Main.userdata[0]).getBalance()));
		MyFrame.back9_jan2.setHorizontalAlignment(JLabel.CENTER);
		
    	/////////////////////////////////���� �Ϸ� �� �ߴ� ȭ��////////////
    	/////////////////////////////////���� �Ϸ� �� �ߴ� ȭ��////////////
		
	}
}
