package white_cow_gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.BufferedReader;
import java.io.DataInput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;
 
public class MyFrame extends JFrame {
 
	
    private final JFrame frame;
    
    private final MyPanel panel;
    //private JButton exitButton = new JButton("사진 촬영 ! ");
    ImageIcon background = new ImageIcon("./picture/background.png");
    JScrollPane scrollPane;
    ImageIcon button0_basic_image = new ImageIcon("./picture/0button_basic.png");
    ImageIcon button0_enter_image = new ImageIcon("./picture/0button_enter.png");
    ImageIcon button1_basic_image = new ImageIcon("./picture/1button_basic.png");
    ImageIcon button1_enter_image = new ImageIcon("./picture/1button_enter.png");
    ImageIcon button2_basic_image = new ImageIcon("./picture/2button_basic.png");
    ImageIcon button2_enter_image = new ImageIcon("./picture/2button_enter.png");
    ImageIcon button3_basic_image = new ImageIcon("./picture/3button_basic.png");
    ImageIcon button3_enter_image = new ImageIcon("./picture/3button_enter.png");
    ImageIcon button4_basic_image = new ImageIcon("./picture/4button_basic.png");
    ImageIcon button4_enter_image = new ImageIcon("./picture/4button_enter.png");
    ImageIcon button5_basic_image = new ImageIcon("./picture/5button_basic.png");
    ImageIcon button5_enter_image = new ImageIcon("./picture/5button_enter.png");
    ImageIcon button6_basic_image = new ImageIcon("./picture/6button_basic.png");
    ImageIcon button6_enter_image = new ImageIcon("./picture/6button_enter.png");
    ImageIcon button7_basic_image = new ImageIcon("./picture/7button_basic.png");
    ImageIcon button7_enter_image = new ImageIcon("./picture/7button_enter.png");
    ImageIcon button8_basic_image = new ImageIcon("./picture/8button_basic.png");
    ImageIcon button8_enter_image = new ImageIcon("./picture/8button_enter.png");
    ImageIcon button9_basic_image = new ImageIcon("./picture/9button_basic.png");
    ImageIcon button9_enter_image = new ImageIcon("./picture/9button_enter.png");
    
    ImageIcon paybutton_basic_image = new ImageIcon("./picture/paybutton_basic.png");
    ImageIcon paybutton_enter_image = new ImageIcon("./picture/paybutton_enter.png");
    
    ImageIcon transp = new ImageIcon("./picture/trans.png");
    
    ImageIcon backutton_basic_image = new ImageIcon("./picture/backbutton_basic.png");
    ImageIcon backbutton_enter_image = new ImageIcon("./picture/backbutton_basic2.png");
    ImageIcon check_basic_image = new ImageIcon("./picture/checkbutton_basic.png");
    ImageIcon check_enter_image = new ImageIcon("./picture/checkbutton_enter.png");
    ImageIcon exitenter_image = new ImageIcon("./picture/exitbutton_enter.png");
    ImageIcon exitbasic_image = new ImageIcon("./picture/exitbutton_basic.png");
    
    static ImageIcon loading_image = new ImageIcon("./picture/loading.png");
    static ImageIcon checked_image = new ImageIcon("./picture/checked.png");
    static ImageIcon unchecked_image = new ImageIcon("./picture/unchecked.png");
    
	private JButton button0_basic = new JButton(button0_basic_image);
	private JButton exitButton = new JButton(exitbasic_image);
	private JButton button1_basic = new JButton(button1_basic_image);
	private JButton button2_basic = new JButton(button2_basic_image);
	private JButton button3_basic = new JButton(button3_basic_image);
	private JButton button4_basic = new JButton(button4_basic_image);
	private JButton button5_basic = new JButton(button5_basic_image);
	private JButton button6_basic = new JButton(button6_basic_image);
	private JButton button7_basic = new JButton(button7_basic_image);
	private JButton button8_basic = new JButton(button8_basic_image);
	private JButton button9_basic = new JButton(button9_basic_image);
	private JButton backbutton_basic = new JButton(backutton_basic_image);
	private JButton checkbutton_basic = new JButton(check_basic_image);
	private JButton paybutton_basic = new JButton(paybutton_basic_image);
	private JLabel menuBar = new JLabel(new ImageIcon("./picture/menuBar.png"));
	private JTextField textfield = new JTextField("");
	public static JLabel status = new JLabel("");
	
	public static JLabel pro1 = new JLabel("");
	public static JLabel pro2 = new JLabel("");
	public static JLabel pro3 = new JLabel("");
	public static JLabel pro4 = new JLabel("");
	public static JLabel pro5 = new JLabel("");
	public static JLabel pro6 = new JLabel("");
	public static JLabel message = new JLabel("");
	public static JLabel SUM = new JLabel("");
	
	public static JLabel timer = new JLabel("");
	public static JLabel random = new JLabel("");
	
	public static JLabel resultback = new JLabel("");
	
	public static JLabel back1 = new JLabel("");
	public static JLabel back2 = new JLabel("");
	public static JLabel back3 = new JLabel("");
	public static JLabel back4 = new JLabel("");
	
	public static JLabel back5_complete = new JLabel("");
	public static JLabel back6_payment = new JLabel("");
	public static JLabel back7_jan = new JLabel();
	
	public static JLabel back8_payment2 = new JLabel("");
	public static JLabel back9_jan2 = new JLabel("");
	
	public static JLabel Loading = new JLabel(loading_image);
	public static JLabel Loading_message = new JLabel("");
	
	public static JLabel checked = new JLabel(checked_image);
	public static JLabel unchecked = new JLabel(unchecked_image);
	
	private int mouseX, mouseY;
	
	static String thing = null;
	static String init = null;
	static String str;
    static int num =1;
    
    static int i = 0;
    static int flag1 = 0;
    static int flag2 = 0;
    static int flag3 = 0;
    static int flag4 = 0;
    static int flag5 = 0;
    static int flag6 = 0;
    static int priceSum = 0;
    
    static int exitflag = 0;
    public static int timer_time = 3;
    
    String[][] name_num_array  = {
    		//[name[0]] [price[1]] [count[2]] [proNo[3]]
    		{"초콜렛빈츠","8801062634453"},
    		{"미네랄워터","8809032983037"},
    		{"밀크티하임","8801111928328"},
    		{"복숭아젤리","8801117334703"},
    		{"포도맛젤리","8801117332709"},
    };
    int[][] price_cnt_array  = {
    		//[name[0]] [price[1]] [count[2]] [proNo[3]]
    		{4500, 0},
    		{1000, 0},
    		{5000, 0},
    		{3000, 0},
    		{80000, 0},
    };

    
	String s;
	
	private JLabel password = new JLabel("");
	int a = 0;
	RandomAccessFile file = new RandomAccessFile("./test.txt","r");
    String password_enter;

    public MyFrame( VideoCapture cap, Mat image) throws FileNotFoundException {
    	

                // JFrame which holds JPane
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(1700,900));
        frame.getContentPane().setLayout(new FlowLayout());
        
    	frame.setUndecorated(true);
    	frame.setResizable(false);
    	//frame.setLocationRelativeTo(null);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
    	
        panel = new MyPanel();
        panel.setLayout(null);
    	password.setFont(new Font("HY견고딕", Font.PLAIN, 40));
    	status.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 60));
    	status.setForeground(new Color(255,255,255));
    	status.setText("결제 대기중입니다");
    	
    	message.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 20));
    	message.setForeground(new Color(255,255,255));
    	message.setText("얼굴 인식을 위해 모니터에 얼굴을 가까이 대 주세요");
    	
    	time t = new time();
        
    	
    	timer.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 80));
    	timer.setForeground(new Color(255,255,255));
    	timer.setText(Integer.toString(timer_time));
    	
    	t.start();
    	
    	textfield.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 40));
    	textfield.setBorder(javax.swing.BorderFactory.createEmptyBorder());
    	
    	random.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 30));
    	random.setForeground(new Color(255,255,255));
    	
    	
    	pro1.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 20));
    	pro2.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 20));
    	pro3.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 20));
    	pro4.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 20));
    	pro5.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 20));
    	pro6.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 20));
    	pro1.setForeground(new Color(255,255,255));
    	pro2.setForeground(new Color(255,255,255));
    	pro3.setForeground(new Color(255,255,255));
    	pro4.setForeground(new Color(255,255,255));
    	pro5.setForeground(new Color(255,255,255));
    	pro6.setForeground(new Color(255,255,255));
    	
    	SUM.setFont(new Font("한컴 윤고딕 230", Font.BOLD, 30));
    	SUM.setForeground(new Color(255,255,255));
    	
 
    	
    	exitButton.setBounds(1600, 0, 70, 54);
		/* 버튼 이미지 자체만을 출력하고자 할 때 아래 코드 사용(이상한 default 뒷배경이나 테두리 없이) */
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		///////////////////////////////////////
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitenter_image);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonSound.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitbasic_image);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Thread.sleep(100);
				}catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
    	
    	
                // JPanel which is used for drawing image
        button1_basic.setBorderPainted(false);
        button1_basic.setContentAreaFilled(false);
        button1_basic.setFocusPainted(false);
        button1_basic.setBounds(1306,335,95,94);
        button1_basic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button1_basic.setIcon(button1_enter_image);
				button1_basic.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button1_basic.setIcon(button1_basic_image);
				button1_basic.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonSound.mp3",false);
				buttonEnteredMusic.start();
			   int n0 = 1;
       		   s = Integer.toString(n0);
       		   Main.text = Main.text + s;
       		a++;
            int i;
            for(i=0;i<a;i++) 
               ;
            if(i==0)
               password.setText("");
            else if(i==1)
            	password.setText("*");
            else if(i==2)
            	password.setText("**");
            else if(i==3)
            	password.setText("***");
            else if(i==4)
            	password.setText("****");
            else if(i==5)
            	password.setText("*****");
            else if(i==6)
            	password.setText("******");
            else if(i==7)
            	password.setText("*******");
            else if (i==8)
            	password.setText("********");

       		  
       		   //Main.text = Main.text.concat("9");
			}
		});
        
        button2_basic.setBorderPainted(false);
        button2_basic.setContentAreaFilled(false);
        button2_basic.setFocusPainted(false);
        button2_basic.setBounds(1426,335,95,94);
        button2_basic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button2_basic.setIcon(button2_enter_image);
				button2_basic.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button2_basic.setIcon(button2_basic_image);
				button2_basic.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonSound.mp3",false);
				buttonEnteredMusic.start();
				int n0 = 2;
	       		   s = Integer.toString(n0);
	       		   Main.text = Main.text + s;
	       		a++;
	            int i;
	            for(i=0;i<a;i++) 
	               ;
	            if(i==0)
	               password.setText("");
	            else if(i==1)
	            	password.setText("*");
	            else if(i==2)
	            	password.setText("**");
	            else if(i==3)
	            	password.setText("***");
	            else if(i==4)
	            	password.setText("****");
	            else if(i==5)
	            	password.setText("*****");
	            else if(i==6)
	            	password.setText("******");
	            else if(i==7)
	            	password.setText("*******");
	            else if (i==8)
	            	password.setText("********");
			}
		});
        
        button3_basic.setBorderPainted(false);
        button3_basic.setContentAreaFilled(false);
        button3_basic.setFocusPainted(false);
        button3_basic.setBounds(1546,335,95,94);
        button3_basic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button3_basic.setIcon(button3_enter_image);
				button3_basic.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button3_basic.setIcon(button3_basic_image);
				button3_basic.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonSound.mp3",false);
				buttonEnteredMusic.start();
				int n0 = 3;
	       		   s = Integer.toString(n0);
	       		   Main.text = Main.text + s;
	       		a++;
	            int i;
	            for(i=0;i<a;i++) 
	               ;
	            if(i==0)
	               password.setText("");
	            else if(i==1)
	            	password.setText("*");
	            else if(i==2)
	            	password.setText("**");
	            else if(i==3)
	            	password.setText("***");
	            else if(i==4)
	            	password.setText("****");
	            else if(i==5)
	            	password.setText("*****");
	            else if(i==6)
	            	password.setText("******");
	            else if(i==7)
	            	password.setText("*******");
	            else if (i==8)
	            	password.setText("********");
			}
		});
        
        button4_basic.setBorderPainted(false);
        button4_basic.setContentAreaFilled(false);
        button4_basic.setFocusPainted(false);
        button4_basic.setBounds(1306,455,95,94);
        button4_basic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button4_basic.setIcon(button4_enter_image);
				button4_basic.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button4_basic.setIcon(button4_basic_image);
				button4_basic.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonSound.mp3",false);
				buttonEnteredMusic.start();
				int n0 = 4;
	       		   s = Integer.toString(n0);
	       		   Main.text = Main.text + s;
	       		a++;
	            int i;
	            for(i=0;i<a;i++) 
	               ;
	            if(i==0)
	               password.setText("");
	            else if(i==1)
	            	password.setText("*");
	            else if(i==2)
	            	password.setText("**");
	            else if(i==3)
	            	password.setText("***");
	            else if(i==4)
	            	password.setText("****");
	            else if(i==5)
	            	password.setText("*****");
	            else if(i==6)
	            	password.setText("******");
	            else if(i==7)
	            	password.setText("*******");
	            else if (i==8)
	            	password.setText("********");
			}
		});
        
        button5_basic.setBorderPainted(false);
        button5_basic.setContentAreaFilled(false);
        button5_basic.setFocusPainted(false);
        button5_basic.setBounds(1426,455,95,94);
        button5_basic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button5_basic.setIcon(button5_enter_image);
				button5_basic.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button5_basic.setIcon(button5_basic_image);
				button5_basic.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonSound.mp3",false);
				buttonEnteredMusic.start();
				int n0 = 5;
	       		   s = Integer.toString(n0);
	       		   Main.text = Main.text + s;
	       		a++;
	            int i;
	            for(i=0;i<a;i++) 
	               ;
	            if(i==0)
	               password.setText("");
	            else if(i==1)
	            	password.setText("*");
	            else if(i==2)
	            	password.setText("**");
	            else if(i==3)
	            	password.setText("***");
	            else if(i==4)
	            	password.setText("****");
	            else if(i==5)
	            	password.setText("*****");
	            else if(i==6)
	            	password.setText("******");
	            else if(i==7)
	            	password.setText("*******");
	            else if (i==8)
	            	password.setText("********");
			}
		});
        
        button6_basic.setBorderPainted(false);
        button6_basic.setContentAreaFilled(false);
        button6_basic.setFocusPainted(false);
        button6_basic.setBounds(1546,455,95,94);
        button6_basic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button6_basic.setIcon(button6_enter_image);
				button6_basic.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button6_basic.setIcon(button6_basic_image);
				button6_basic.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonSound.mp3",false);
				buttonEnteredMusic.start();
				int n0 = 6;
	       		   s = Integer.toString(n0);
	       		   Main.text = Main.text + s;
	       		a++;
	            int i;
	            for(i=0;i<a;i++) 
	               ;
	            if(i==0)
	               password.setText("");
	            else if(i==1)
	            	password.setText("*");
	            else if(i==2)
	            	password.setText("**");
	            else if(i==3)
	            	password.setText("***");
	            else if(i==4)
	            	password.setText("****");
	            else if(i==5)
	            	password.setText("*****");
	            else if(i==6)
	            	password.setText("******");
	            else if(i==7)
	            	password.setText("*******");
	            else if (i==8)
	            	password.setText("********");
			}
		});
        
        button7_basic.setBorderPainted(false);
        button7_basic.setContentAreaFilled(false);
        button7_basic.setFocusPainted(false);
        button7_basic.setBounds(1306,575,95,94);
        button7_basic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button7_basic.setIcon(button7_enter_image);
				button7_basic.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button7_basic.setIcon(button7_basic_image);
				button7_basic.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonSound.mp3",false);
				buttonEnteredMusic.start();
				int n0 = 7;
	       		   s = Integer.toString(n0);
	       		   Main.text = Main.text + s;
	       		a++;
	            int i;
	            for(i=0;i<a;i++) 
	               ;
	            if(i==0)
	               password.setText("");
	            else if(i==1)
	            	password.setText("*");
	            else if(i==2)
	            	password.setText("**");
	            else if(i==3)
	            	password.setText("***");
	            else if(i==4)
	            	password.setText("****");
	            else if(i==5)
	            	password.setText("*****");
	            else if(i==6)
	            	password.setText("******");
	            else if(i==7)
	            	password.setText("*******");
	            else if (i==8)
	            	password.setText("********");
			}
		});
        
        button8_basic.setBorderPainted(false);
        button8_basic.setContentAreaFilled(false);
        button8_basic.setFocusPainted(false);
        button8_basic.setBounds(1426,575,95,94);
        button8_basic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button8_basic.setIcon(button8_enter_image);
				button8_basic.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button8_basic.setIcon(button8_basic_image);
				button8_basic.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonSound.mp3",false);
				buttonEnteredMusic.start();
				int n0 = 8;
	       		   s = Integer.toString(n0);
	       		   Main.text = Main.text + s;
	       		a++;
	            int i;
	            for(i=0;i<a;i++) 
	               ;
	            if(i==0)
	               password.setText("");
	            else if(i==1)
	            	password.setText("*");
	            else if(i==2)
	            	password.setText("**");
	            else if(i==3)
	            	password.setText("***");
	            else if(i==4)
	            	password.setText("****");
	            else if(i==5)
	            	password.setText("*****");
	            else if(i==6)
	            	password.setText("******");
	            else if(i==7)
	            	password.setText("*******");
	            else if (i==8)
	            	password.setText("********");
			}
		});
        
        button9_basic.setBorderPainted(false);
        button9_basic.setContentAreaFilled(false);
        button9_basic.setFocusPainted(false);
        button9_basic.setBounds(1546,575,95,94);
        button9_basic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button9_basic.setIcon(button9_enter_image);
				button9_basic.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button9_basic.setIcon(button9_basic_image);
				button9_basic.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonSound.mp3",false);
				buttonEnteredMusic.start();
				int n0 = 9;
	       		   s = Integer.toString(n0);
	       		   Main.text = Main.text + s;
	       		a++;
	            int i;
	            for(i=0;i<a;i++) 
	               ;
	            if(i==0)
	               password.setText("");
	            else if(i==1)
	            	password.setText("*");
	            else if(i==2)
	            	password.setText("**");
	            else if(i==3)
	            	password.setText("***");
	            else if(i==4)
	            	password.setText("****");
	            else if(i==5)
	            	password.setText("*****");
	            else if(i==6)
	            	password.setText("******");
	            else if(i==7)
	            	password.setText("*******");
	            else if (i==8)
	            	password.setText("********");
			}
		});
        
        button0_basic.setBorderPainted(false);
        button0_basic.setContentAreaFilled(false);
        button0_basic.setFocusPainted(false);
        button0_basic.setBounds(1306,695,95,94);
        button0_basic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button0_basic.setIcon(button0_enter_image);
				button0_basic.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button0_basic.setIcon(button0_basic_image);
				button0_basic.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonSound.mp3",false);
				buttonEnteredMusic.start();
				int n0 = 0;
	       		   s = Integer.toString(n0);
	       		   Main.text = Main.text + s;
	       		a++;
	            int i;
	            for(i=0;i<a;i++) 
	               ;
	            if(i==0)
	               password.setText("");
	            else if(i==1)
	            	password.setText("*");
	            else if(i==2)
	            	password.setText("**");
	            else if(i==3)
	            	password.setText("***");
	            else if(i==4)
	            	password.setText("****");
	            else if(i==5)
	            	password.setText("*****");
	            else if(i==6)
	            	password.setText("******");
	            else if(i==7)
	            	password.setText("*******");
	            else if (i==8)
	            	password.setText("********");
			}
		});
        
       
        
        /// 결제버튼
        paybutton_basic.setBounds(308, 754, 99, 64);
		/* 버튼 이미지 자체만을 출력하고자 할 때 아래 코드 사용(이상한 default 뒷배경이나 테두리 없이) */
        paybutton_basic.setBorderPainted(false);
        paybutton_basic.setContentAreaFilled(false);
        paybutton_basic.setFocusPainted(false);
		///////////////////////////////////////
        paybutton_basic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				paybutton_basic.setIcon(paybutton_enter_image);
				paybutton_basic.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonSound.mp3",false);
				buttonEnteredMusic.start();
				
				if(exitflag == 1)
					paybutton_basic.setIcon(transp);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				paybutton_basic.setIcon(paybutton_basic_image);
				paybutton_basic.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
				if(exitflag == 1)
					paybutton_basic.setIcon(transp);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
				exitflag = 1;
				
				cap.retrieve(image);
				Highgui.imwrite("test.jpg", image);
				
				SendThread.getInstance().sendMessage("image");
				SendThread.getInstance().sendFile();
				
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
	    		paybutton_basic.setIcon(transp);
	    		
	    		//얼굴 인식중...이 중앙에 뜨는 부분
	    		panel.add(Loading);
	    		
	    		//panel.add(unchecked);
	    		//panel.add(Loading_message);
	    		panel.add(resultback);
	    		
	    		Loading L = new Loading();
	    		L.start();
	    		
	 

	    		/*
	    		resultback.setOpaque(true);
	        	resultback.setBounds(13,82,1236,776);
	        	resultback.setBackground(new Color(35,31,56));
	    		panel.add(resultback);
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

				paybutton_basic.setIcon(transp);
				
	//////////////결과 화면 라벨들 //////////////////////////////////////
		    	//////////////결과 화면 라벨들 //////////////////////////////////////
		    	
		    	/*back1.setBounds(88, 132, 1092, 80); 
		    	back1.setOpaque(true);
		    	back1.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 35));
		    	back1.setBackground(new Color(63,60,82));
		    	back1.setText( "님 - 얼굴인식 완료!");
		    	back1.setHorizontalAlignment(JLabel.CENTER);
		    	back1.setForeground(new Color(245,248,6));
		    	
		    	back2.setBounds(88, 277, 1092, 80); 
		    	back2.setOpaque(true);
		    	back2.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 40));
		    	back2.setBackground(new Color(63,60,82));
		    	back2.setText("결제 비밀번호를 입력해 주십시오.");
		    	back2.setHorizontalAlignment(JLabel.CENTER);
		    	back2.setForeground(new Color(255,255,255));
		    	
		    	back3.setBounds(88, 422, 1092, 80); 
		    	back3.setOpaque(true);
		    	back3.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 20));
		    	back3.setBackground(new Color(63,60,82));*/
	    		//////////////////////////////////
		    	
		    	//back4.setBounds(88, 567, 1092, 264); 
		    	//back4.setOpaque(true);
		    	//back4.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 20));
		    	//back4.setBackground(new Color(63,60,82));

		    	//////////////결과 화면 라벨들 //////////////////////////////////////
		    	//////////////결과 화면 라벨들 //////////////////////////////////////
				
			}
		});
    	
        checkbutton_basic.setBorderPainted(false);
        checkbutton_basic.setContentAreaFilled(false);
        checkbutton_basic.setFocusPainted(false);
        checkbutton_basic.setBounds(1426,695,213,94);
        checkbutton_basic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				checkbutton_basic.setIcon(check_enter_image);
				checkbutton_basic.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				checkbutton_basic.setIcon(check_basic_image);
				checkbutton_basic.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonSound.mp3",false);
				buttonEnteredMusic.start();

				Main.readuserdata();
				
				for(String s : Main.userdata) {
					System.out.println(s);
				}
				
				
		    	if (Main.dbManager.select_with_condition_user_info(Main.userdata[0], Main.userdata[1], Main.userdata[2], Main.pwdata))
		    	{
		    		LoadingTwo L2 = new LoadingTwo();
		    		L2.start();
		    		/*
		    		System.out.println("성공!!!");
		    		Main.data_exist = true;
		    		//status.setText("결제 진행중입니다");
		    		//status.setForeground(new Color(255,227,70));
		    		
		    		MyFrame.checked.setBounds(112,276,61,61);
		    		back2.setText("비밀번호가 일치합니다.");
		    		back2.setForeground(new Color(245,248,6)); //폰트색상
		    		

		    		back2.setBackground(new Color(63,60,82)); // 라벨배경 원래 색으로 복귀

		    		
		    		MyFrame.checked.setBounds(112,413,61,61);
		    		
		    		back3.setBounds(186, 422, 989, 80); 
		        	back3.setOpaque(true);
		        	back3.setBackground(new Color(6,99,76));
		        	back3.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 40));
		    		back3.setText("블록체인 결제 진행중입니다");
			    	back3.setHorizontalAlignment(JLabel.CENTER);
			    	back3.setForeground(new Color(255,255,255));
			    	
			    	
		    		///////////////////////////블록체인 결제 진행 하는 코드 작성 ////////////////////

                	MyGlobals.getInstance().setPriceSum(priceSum);
			    	NoobChain.Auto(Main.userdata[0],"Mart",MyGlobals.getInstance().getPriceSum());
			    	//NoobChain.walletHash.get("Kimheewon").getBalance();
			    	
			    	/////////////////////////////////////////////////////////////////
		    		
			    	
		    		//back4.setBounds(88, 567, 1092, 264); 
			    	//back4.setOpaque(true);
			    	//back4.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 20));
			    	//back4.setBackground(new Color(63,60,82));
			    	
			    	back3.setBackground(new Color(63,60,82));
			    	back3.setText("결제가 완료되었습니다!");
			    	back3.setForeground(new Color(245,248,6));
			    	
			    	/////////////////////////////////블록체인 결제 완료 시 뜨는 화면////////////
			    	/////////////////////////////////블록체인 결제 완료 시 뜨는 화면////////////
			    	back5_complete.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 40));
			    	back5_complete.setOpaque(true);
			    	back5_complete.setText("결제 내역");
			    	back5_complete.setBounds(510,556,296,70);
			    	back5_complete.setBackground(new Color(36,23,93));
			    	back5_complete.setForeground(new Color(255,255,255));
			    	back5_complete.setHorizontalAlignment(JLabel.CENTER);
			    	MyFrame.checked.setBounds(112,312,61,61);
		    		
		    		back6_payment.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 40));
		    		back6_payment.setForeground(new Color(255,255,255));
		    		back6_payment.setOpaque(true);
		    		back6_payment.setBounds(264,636,296,70);
		    		back6_payment.setBackground(new Color(36,23,93));
		    		back6_payment.setText("결제 금액");
		    		back6_payment.setHorizontalAlignment(JLabel.CENTER);
		    		
		    		
		    		back7_jan.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 40));
		    		back7_jan.setForeground(new Color(255,255,255));
		    		back7_jan.setOpaque(true);
		    		back7_jan.setBounds(264,718,296,70);
		    		back7_jan.setBackground(new Color(36,23,93));
		    		back7_jan.setText("잔액");
		    		back7_jan.setHorizontalAlignment(JLabel.CENTER);
		    		
		    		
		    		back8_payment2.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 40));
		    		back8_payment2.setForeground(new Color(255,255,255));
		    		back8_payment2.setOpaque(true);
		    		back8_payment2.setBounds(606,636,422,70);
		    		back8_payment2.setBackground(new Color(36,23,93));
		    		back8_payment2.setText(Integer.toString(priceSum));
		    		back8_payment2.setHorizontalAlignment(JLabel.CENTER);

		    		back9_jan2.setFont(new Font("한컴 윤고딕 230", Font.PLAIN, 40));
		    		back9_jan2.setForeground(new Color(255,255,255));
		    		back9_jan2.setOpaque(true);
		    		back9_jan2.setBounds(606,718,422,70);
		    		back9_jan2.setBackground(new Color(36,23,93));
		    		back9_jan2.setText(Integer.toString((int)NoobChain.walletHash.get(Main.userdata[0]).getBalance()));
		    		back9_jan2.setHorizontalAlignment(JLabel.CENTER);*/
		    		
			    	/////////////////////////////////결제 완료 시 뜨는 화면////////////
			    	/////////////////////////////////결제 완료 시 뜨는 화면////////////
			    	

		    	}
		    	else {
		    		System.out.println("실패!!!");
		    		Main.data_exist = false;
		    		back2.setText("일치하지 않습니다");
		    		back2.setForeground(new Color(255,255,255));
		    		back2.setBackground(new Color(151,57,68));
		    		
		    		MyFrame.checked.setIcon(transp);
		    		MyFrame.unchecked.setBounds(112,276,61,61);
		    	}
			}
		});
        
        
        
        backbutton_basic.setBorderPainted(false);
        backbutton_basic.setContentAreaFilled(false);
        backbutton_basic.setFocusPainted(false);
        backbutton_basic.setBounds(1582,248,68,56);
        backbutton_basic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backbutton_basic.setIcon(backbutton_enter_image);
				backbutton_basic.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backbutton_basic.setIcon(backutton_basic_image);
				backbutton_basic.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonSound.mp3",false);
				buttonEnteredMusic.start();
/* 받아온 password1.txt와 사용자가 입력한 textText1.txt를 비교하는 부분 */
				/*
		    try {
				password_enter = readFile(file2);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		    if(Main.password1.equals(password_enter)==false) {
		    	 JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다", "오류", JOptionPane.ERROR_MESSAGE);
		    }
		  
			*/}
		});
        

     	
        menuBar.setBounds(0, 0, 1700, 54);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				frame.setLocation(x-mouseX, y-mouseY);
			}
		});
		
		  textfield.addKeyListener(new KeyAdapter() {
	           @Override
	           public void keyPressed(KeyEvent e) {
	              try {
	               file.seek(0);
	            } catch (IOException e2) {
	               // TODO Auto-generated catch block
	               e2.printStackTrace();
	            }
	               if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	   num=1;
	                  thing = new String(textfield.getText());
	                  try {
	                  while((str = ((DataInput) file).readLine()) != null) {
	                     if(str.equals(thing)){
	                        if(num == 1) {
	                        	textfield.setText(init);
	                        	price_cnt_array[0][1] += 1; // cnt + 1
	                        	priceSum = priceSum + price_cnt_array[0][0];
	                        	SUM.setText(Integer.toString(priceSum));

	                        	if(pro1.getText()=="" && flag1==0) {
		                        	
	                        		pro1.setText("     "+ name_num_array[0][0]+ "       " + price_cnt_array[0][0]
	                        				+"        "+ price_cnt_array[0][1] );
	                        		flag1=1;
	                        	}
	                        	else if(pro2.getText()=="" && flag1==0) {
	                        		pro2.setText("     "+ name_num_array[0][0]+ "       " + price_cnt_array[0][0]
	                        				+"        "+ price_cnt_array[0][1] );
	                        		flag1=2;
	                        	}
	                        	else if(pro3.getText()=="" && flag1==0) {
	                        		pro3.setText("     "+ name_num_array[0][0] + "       " + price_cnt_array[0][0]
	                        				+"        "+ price_cnt_array[0][1] );
	                        		flag1=3;
	                        	}
	                        	else if(pro4.getText()=="" && flag1==0) {
	                        		pro4.setText("     "+ name_num_array[0][0]+ "       " + price_cnt_array[0][0]
	                        				+"        "+ price_cnt_array[0][1] );
	                        		flag1=4;
	                        	}
	                        	else if(pro5.getText()=="" && flag1==0) {
	                        		pro5.setText("     "+ name_num_array[0][0] + "       " + price_cnt_array[0][0]
	                        				+"        "+ price_cnt_array[0][1] );
	                        		flag1=5;
	                        	}
	                        	else if(pro6.getText()=="" && flag1==0) {
	                        		pro6.setText("     "+ name_num_array[0][0]+ "       " + price_cnt_array[0][0]
	                        				+"        "+ price_cnt_array[0][1] );
	                        		flag1=6;
	                        	}
	                        	
	                        	else if(pro1.getText()!="" && flag1==1) {
		                        	
	                        		pro1.setText("     "+ name_num_array[0][0]+ "       " + price_cnt_array[0][0]
	                        				+"        "+ price_cnt_array[0][1] );
	                        	}
	                        	else if(pro2.getText()!="" && flag1==2) {
	                        		pro2.setText("     "+ name_num_array[0][0] + "       " + price_cnt_array[0][0]
	                        				+"        "+ price_cnt_array[0][1] );
	                        	}
	                        	else if(pro3.getText()!="" && flag1==3) {
	                        		pro3.setText("     "+ name_num_array[0][0] + "       " + price_cnt_array[0][0]
	                        				+"        "+ price_cnt_array[0][1] );
	                        	}
	                        	else if(pro4.getText()!="" && flag1==4) {
	                        		pro4.setText("     "+ name_num_array[0][0] + "       " + price_cnt_array[0][0]
	                        				+"        "+ price_cnt_array[0][1] );
	                        	}
	                        	else if(pro5.getText()!="" && flag1==5) {
	                        		pro5.setText("     "+ name_num_array[0][0] + "       " + price_cnt_array[0][0]
	                        				+"        "+ price_cnt_array[0][1] );
	                        	}
	                        	else if(pro6.getText()!="" && flag1==6) {
	                        		pro6.setText("     "+ name_num_array[0][0] + "       " + price_cnt_array[0][0]
	                        				+"        "+ price_cnt_array[0][1] );
	                        	}
	                           //System.out.println("1번째 물품 일치");
	                           //Thread.sleep(500);

	                           break;
	                        }
	                        else if(num == 2) {
		                        textfield.setText(init);
	                        	price_cnt_array[1][1] += 1; // cnt + 1
	                        	priceSum = priceSum + price_cnt_array[1][0];
	                        	SUM.setText(Integer.toString(priceSum));

	                        	if(pro1.getText()=="" && flag2==0) {
		                        	
	                        		pro1.setText("     "+ name_num_array[1][0]+ "       " + price_cnt_array[1][0]
	                        				+"        "+ price_cnt_array[1][1] );
	                        		flag2=1;
	                        	}
	                        	else if(pro2.getText()=="" && flag2==0) {
	                        		pro2.setText("     "+ name_num_array[1][0]+ "       " + price_cnt_array[1][0]
	                        				+"        "+ price_cnt_array[1][1] );
	                        		flag2=2;
	                        	}
	                        	else if(pro3.getText()=="" && flag2==0) {
	                        		pro3.setText("     "+ name_num_array[1][0] + "       " + price_cnt_array[1][0]
	                        				+"        "+ price_cnt_array[1][1] );
	                        		flag2=3;
	                        	}
	                        	else if(pro4.getText()=="" && flag2==0) {
	                        		pro4.setText("     "+ name_num_array[1][0]+ "       " + price_cnt_array[1][0]
	                        				+"        "+ price_cnt_array[1][1] );
	                        		flag2=4;
	                        	}
	                        	else if(pro5.getText()=="" && flag2==0) {
	                        		pro5.setText("     "+ name_num_array[1][0] + "       " + price_cnt_array[1][0]
	                        				+"        "+ price_cnt_array[1][1] );
	                        		flag2=5;
	                        	}
	                        	else if(pro6.getText()=="" && flag2==0) {
	                        		pro6.setText("     "+ name_num_array[1][0]+ "       " + price_cnt_array[1][0]
	                        				+"        "+ price_cnt_array[1][1] );
	                        		flag2=6;
	                        	}
	                        	
	                        	else if(pro1.getText()!="" && flag2==1) {
		                        	
	                        		pro1.setText("     "+ name_num_array[1][0]+ "       " + price_cnt_array[1][0]
	                        				+"        "+ price_cnt_array[1][1] );
	                        	}
	                        	else if(pro2.getText()!="" && flag2==2) {
	                        		pro2.setText("     "+ name_num_array[1][0] + "       " + price_cnt_array[1][0]
	                        				+"        "+ price_cnt_array[1][1] );
	                        	}
	                        	else if(pro3.getText()!="" && flag2==3) {
	                        		pro3.setText("     "+ name_num_array[1][0] + "       " + price_cnt_array[1][0]
	                        				+"        "+ price_cnt_array[1][1] );
	                        	}
	                        	else if(pro4.getText()!="" && flag2==4) {
	                        		pro4.setText("     "+ name_num_array[1][0] + "       " + price_cnt_array[1][0]
	                        				+"        "+ price_cnt_array[1][1] );
	                        	}
	                        	else if(pro5.getText()!="" && flag2==5) {
	                        		pro5.setText("     "+ name_num_array[1][0] + "       " + price_cnt_array[1][0]
	                        				+"        "+ price_cnt_array[1][1] );
	                        	}
	                        	else if(pro6.getText()!="" && flag2==6) {
	                        		pro6.setText("     "+ name_num_array[1][0] + "       " + price_cnt_array[1][0]
	                        				+"        "+ price_cnt_array[1][1] );
	                        	}
	                          // System.out.println("2번째 물품 일치");
	                           //Thread.sleep(500);

	                           break;
	                        }
	                        else if(num == 3) {
	                        	textfield.setText(init);
	                        	price_cnt_array[2][1] += 1; // cnt + 1
	                        	priceSum = priceSum + price_cnt_array[2][0];
	                        	SUM.setText(Integer.toString(priceSum));

	                        	if(pro1.getText()=="" && flag3==0) {
		                        	
	                        		pro1.setText("     "+ name_num_array[2][0]+ "       " + price_cnt_array[2][0]
	                        				+"        "+ price_cnt_array[2][1] );
	                        		flag3=1;
	                        	}
	                        	else if(pro2.getText()=="" && flag3==0) {
	                        		pro2.setText("     "+ name_num_array[2][0]+ "       " + price_cnt_array[2][0]
	                        				+"        "+ price_cnt_array[2][1] );
	                        		flag3=2;
	                        	}
	                        	else if(pro3.getText()=="" && flag3==0) {
	                        		pro3.setText("     "+ name_num_array[2][0] + "       " + price_cnt_array[2][0]
	                        				+"        "+ price_cnt_array[2][1] );
	                        		flag3=3;
	                        	}
	                        	else if(pro4.getText()=="" && flag3==0) {
	                        		pro4.setText("     "+ name_num_array[2][0]+ "       " + price_cnt_array[2][0]
	                        				+"        "+ price_cnt_array[2][1] );
	                        		flag3=4;
	                        	}
	                        	else if(pro5.getText()=="" && flag3==0) {
	                        		pro5.setText("     "+ name_num_array[2][0] + "       " + price_cnt_array[2][0]
	                        				+"        "+ price_cnt_array[2][1] );
	                        		flag3=5;
	                        	}
	                        	else if(pro6.getText()=="" && flag3==0) {
	                        		pro6.setText("     "+ name_num_array[2][0]+ "       " + price_cnt_array[2][0]
	                        				+"        "+ price_cnt_array[2][1] );
	                        		flag3=6;
	                        	}
	                        	
	                        	else if(pro1.getText()!="" && flag3==1) {
		                        	
	                        		pro1.setText("     "+ name_num_array[2][0]+ "       " + price_cnt_array[2][0]
	                        				+"        "+ price_cnt_array[2][1] );
	                        	}
	                        	else if(pro2.getText()!="" && flag3==2) {
	                        		pro2.setText("     "+ name_num_array[2][0] + "       " + price_cnt_array[2][0]
	                        				+"        "+ price_cnt_array[2][1] );
	                        	}
	                        	else if(pro3.getText()!="" && flag3==3) {
	                        		pro3.setText("     "+ name_num_array[2][0] + "       " + price_cnt_array[2][0]
	                        				+"        "+ price_cnt_array[2][1] );
	                        	}
	                        	else if(pro4.getText()!="" && flag3==4) {
	                        		pro4.setText("     "+ name_num_array[2][0] + "       " + price_cnt_array[2][0]
	                        				+"        "+ price_cnt_array[2][1] );
	                        	}
	                        	else if(pro5.getText()!="" && flag3==5) {
	                        		pro5.setText("     "+ name_num_array[2][0] + "       " + price_cnt_array[2][0]
	                        				+"        "+ price_cnt_array[2][1] );
	                        	}
	                        	else if(pro6.getText()!="" && flag3==6) {
	                        		pro6.setText("     "+ name_num_array[2][0] + "       " + price_cnt_array[2][0]
	                        				+"        "+ price_cnt_array[2][1] );
	                        	}
	                          // System.out.println("2번째 물품 일치");
	                           //Thread.sleep(500);

	                           break;
	                        }
	                        else if(num == 4) {
	                        	textfield.setText(init);
	            				price_cnt_array[3][1] += 1; // cnt + 1
	                        	priceSum = priceSum + price_cnt_array[3][0];
	                        	SUM.setText(Integer.toString(priceSum));

	                        	if(pro1.getText()=="" && flag4==0) {
		                        	
	                        		pro1.setText("     "+ name_num_array[3][0] +  "       " + price_cnt_array[3][0]
	                        				+"        "+  price_cnt_array[3][1] );
	                        		flag4=1;
	                        	}
	                        	else if(pro2.getText()=="" && flag4==0) {
	                        		pro2.setText("     "+ name_num_array[3][0] +  "       " + price_cnt_array[3][0]
	                        				+"        "+  price_cnt_array[3][1] );
	                        		flag4=2;
	                        	}
	                        	else if(pro3.getText()=="" && flag4==0) {
	                        		pro3.setText("     "+ name_num_array[3][0] + "       " + price_cnt_array[3][0]
	                        				+"        "+  price_cnt_array[3][1] );
	                        		flag4=3;
	                        	}
	                        	else if(pro4.getText()=="" && flag4==0) {
	                        		pro4.setText("     "+ name_num_array[3][0] +  "       " + price_cnt_array[3][0]
	                        				+"        "+  price_cnt_array[3][1] );
	                        		flag4=4;
	                        	}
	                        	else if(pro5.getText()=="" && flag4==0) {
	                        		pro5.setText("     "+ name_num_array[3][0] +  "       " + price_cnt_array[3][0]
	                        				+"        "+  price_cnt_array[3][1] );
	                        		flag4=5;
	                        	}
	                        	else if(pro6.getText()=="" && flag4==0) {
	                        		pro6.setText("     "+ name_num_array[3][0] + "       " + price_cnt_array[3][0]
	                        				+"        "+  price_cnt_array[3][1] );
	                        		flag4=6;
	                        	}
	                        	
	                        	else if(pro1.getText()!="" && flag4==1) {
		                        	
	                        		pro1.setText("     "+ name_num_array[3][0] + "       " + price_cnt_array[3][0]
	                        				+"        "+  price_cnt_array[3][1] );
	                        	}
	                        	else if(pro2.getText()!="" && flag4==2) {
	                        		pro2.setText("     "+ name_num_array[3][0] + "       " + price_cnt_array[3][0]
	                        				+"        "+  price_cnt_array[3][1] );
	                        	}
	                        	else if(pro3.getText()!="" && flag4==3) {
	                        		pro3.setText("     "+ name_num_array[3][0] + "       " + price_cnt_array[3][0]
	                        				+"        "+  price_cnt_array[3][1] );
	                        	}
	                        	else if(pro4.getText()!="" && flag4==4) {
	                        		pro4.setText("     "+ name_num_array[3][0] +  "       " + price_cnt_array[3][0]
	                        				+"        "+  price_cnt_array[3][1] );
	                        	}
	                        	else if(pro5.getText()!="" && flag4==5) {
	                        		pro5.setText("     "+ name_num_array[3][0] + "       " + price_cnt_array[3][0]
	                        				+"        "+  price_cnt_array[3][1] );
	                        	}
	                        	else if(pro6.getText()!="" && flag4==6) {
	                        		pro6.setText("     "+ name_num_array[3][0] + "       " + price_cnt_array[3][0]
	                        				+"        "+  price_cnt_array[3][1] );
	                        	}
	                           break;
	                        }
	                        else if(num == 5) {
	                        	textfield.setText(init);
	            				price_cnt_array[4][1] += 1; // cnt + 1
	                        	priceSum = priceSum + price_cnt_array[4][0];
	                        	SUM.setText(Integer.toString(priceSum));

	                        	if(pro1.getText()=="" && flag5==0) {
		                        	
	                        		pro1.setText("     "+ name_num_array[4][0] + "       " + price_cnt_array[4][0]
	                        				+"        "+ price_cnt_array[4][1] );
	                        		flag5=1;
	                        	}
	                        	else if(pro2.getText()=="" && flag5==0) {
	                        		pro2.setText("     "+ name_num_array[4][0] + "       " + price_cnt_array[4][0]
	                        				+"        "+ price_cnt_array[4][1] );
	                        		flag5=2;
	                        	}
	                        	else if(pro3.getText()=="" && flag5==0) {
	                        		pro3.setText("     "+ name_num_array[4][0] +  "       " + price_cnt_array[4][0]
	                        				+"        "+ price_cnt_array[4][1] );
	                        		flag5=3;
	                        	}
	                        	else if(pro4.getText()=="" && flag5==0) {
	                        		pro4.setText("     "+ name_num_array[4][0] +  "       " + price_cnt_array[4][0]
	                        				+"        "+ price_cnt_array[4][1] );
	                        		flag5=4;
	                        	}
	                        	else if(pro5.getText()=="" && flag5==0) {
	                        		pro5.setText("     "+ name_num_array[4][0] +  "       " + price_cnt_array[4][0]
	                        				+"        "+ price_cnt_array[4][1] );
	                        		flag5=5;
	                        	}
	                        	else if(pro6.getText()=="" && flag5==0) {
	                        		pro6.setText("     "+ name_num_array[4][0] +  "       " + price_cnt_array[4][0]
	                        				+"        "+ price_cnt_array[4][1] );
	                        		flag5=6;
	                        	}
	                        	
	                        	else if(pro1.getText()!="" && flag5==1) {
		                        	
	                        		pro1.setText("     "+ name_num_array[4][0] + "       " + price_cnt_array[4][0]
	                        				+"        "+price_cnt_array[4][1] );
	                        	}
	                        	else if(pro2.getText()!="" && flag5==2) {
	                        		pro2.setText("     "+ name_num_array[4][0] + "       " + price_cnt_array[4][0]
	                        				+"        "+ price_cnt_array[4][1] );
	                        	}
	                        	else if(pro3.getText()!="" && flag5==3) {
	                        		pro3.setText("     "+ name_num_array[4][0] + "       " + price_cnt_array[4][0]
	                        				+"        "+ price_cnt_array[4][1] );
	                        	}
	                        	else if(pro4.getText()!="" && flag5==4) {
	                        		pro4.setText("     "+ name_num_array[4][0] + "       " + price_cnt_array[4][0]
	                        				+"        "+ price_cnt_array[4][1] );
	                        	}
	                        	else if(pro5.getText()!="" && flag5==5) {
	                        		pro5.setText("     "+ name_num_array[4][0] + "       " + price_cnt_array[4][0]
	                        				+"        "+ price_cnt_array[4][1] );
	                        	}
	                        	else if(pro6.getText()!="" && flag5==6) {
	                        		pro6.setText("     "+ name_num_array[4][0] + "       " + price_cnt_array[4][0]
	                        				+"        "+ price_cnt_array[4][1] );
	                        	}
	                           break;
	                        }
	                        else if(num == 6) {
	                        	textfield.setText(init);
	            				price_cnt_array[5][1] += 1; // cnt + 1
	                        	priceSum = priceSum + price_cnt_array[5][0];
	                        	SUM.setText(Integer.toString(priceSum));

	                        	if(pro1.getText()=="" && flag6==0) {
		                        	
	                        		pro1.setText("     "+ name_num_array[5][0] + "       " + price_cnt_array[5][0]
	                        				+"        "+price_cnt_array[5][1] );
	                        		flag6=1;
	                        	}
	                        	else if(pro2.getText()=="" && flag6==0) {
	                        		pro2.setText("     "+ name_num_array[5][0] + "       " + price_cnt_array[5][0]
	                        				+"        "+price_cnt_array[5][1] );
	                        		flag6=2;
	                        	}
	                        	else if(pro3.getText()=="" && flag6==0) {
	                        		pro3.setText("     "+ name_num_array[5][0] + "       " + price_cnt_array[5][0]
	                        				+"        "+price_cnt_array[5][1] );
	                        		flag6=3;
	                        	}
	                        	else if(pro4.getText()=="" && flag6==0) {
	                        		pro4.setText("     "+ name_num_array[5][0] + "       " + price_cnt_array[5][0]
	                        				+"        "+price_cnt_array[5][1] );
	                        		flag6=4;
	                        	}
	                        	else if(pro5.getText()=="" && flag6==0) {
	                        		pro5.setText("     "+ name_num_array[5][0] + "       " + price_cnt_array[5][0]
	                        				+"        "+price_cnt_array[5][1] );
	                        		flag6=5;
	                        	}
	                        	else if(pro6.getText()=="" && flag6==0) {
	                        		pro6.setText("     "+ name_num_array[5][0] + "       " + price_cnt_array[5][0]
	                        				+"        "+price_cnt_array[5][1] );
	                        		flag6=6;
	                        	}
	                        	
	                        	else if(pro1.getText()!="" && flag6==1) {
		                        	
	                        		pro1.setText("     "+ name_num_array[5][0] + "       " + price_cnt_array[5][0]
	                        				+"        "+price_cnt_array[5][1] );
	                        	}
	                        	else if(pro2.getText()!="" && flag6==2) {
	                        		pro2.setText("     "+ name_num_array[5][0]+ "       " + price_cnt_array[5][0]
	                        				+"        "+price_cnt_array[5][1] );
	                        	}
	                        	else if(pro3.getText()!="" && flag6==3) {
	                        		pro3.setText("     "+ name_num_array[5][0]+ "       " + price_cnt_array[5][0]
	                        				+"        "+price_cnt_array[5][1] );
	                        	}
	                        	else if(pro4.getText()!="" && flag6==4) {
	                        		pro4.setText("     "+ name_num_array[5][0] + "       " + price_cnt_array[5][0]
	                        				+"        "+price_cnt_array[5][1] );
	                        	}
	                        	else if(pro5.getText()!="" && flag6==5) {
	                        		pro5.setText("     "+ name_num_array[5][0] + "       " + price_cnt_array[5][0]
	                        				+"        "+price_cnt_array[5][1] );
	                        	}
	                        	else if(pro6.getText()!="" && flag6==6) {
	                        		pro6.setText("     "+ name_num_array[5][0] + "       " + price_cnt_array[5][0]
	                        				+"        "+price_cnt_array[5][1] );
	                        	}
	                           break;
	                        }
	                     }
	                        
	                     num++;
	                  }
	               } catch (IOException e1) {
	                  // TODO Auto-generated catch block
	                  e1.printStackTrace();
	               } 
	               }
	             
	           }

	       });

		
		panel.add(exitButton);
		panel.add(menuBar);

        
    	//password.setText("");
    	password.setBounds(1300, 250, 275, 56); 
    	password.setOpaque(false);
    	
    	textfield.setBounds(53, 250, 358, 55); 
    	textfield.setOpaque(false);
    	
    	status.setBounds(620,740, 700, 90);
    	status.setOpaque(false);
    	
    	pro1.setBounds(57, 395, 341, 42); 
    	pro1.setOpaque(false);
    	pro2.setBounds(57, 445, 341, 42); 
    	pro2.setOpaque(false);
    	pro3.setBounds(57, 495, 341, 42); 
    	pro3.setOpaque(false);
    	pro4.setBounds(57, 545, 341, 42); 
    	pro4.setOpaque(false);
    	pro5.setBounds(57, 595, 341, 42); 
    	pro5.setOpaque(false);
    	pro6.setBounds(57, 645, 341, 42); 
    	pro6.setOpaque(false);
    	
    	SUM.setBounds(140, 762, 234, 51); 
    	SUM.setOpaque(false);
    	
    	message.setBounds(635, 99, 572, 66);
    	message.setOpaque(false);
    	
    	timer.setBounds(822, 172, 330, 78);
    	timer.setOpaque(false);
    	
    	random.setBounds(1170, 654, 150, 48);
    	random.setOpaque(false);
    	
    	
    	
    	panel.add(back1);
    	panel.add(back2);
    	panel.add(back3);
    	panel.add(back4);
    	panel.add(back5_complete);
    	panel.add(back6_payment);
    	panel.add(back7_jan);
    	panel.add(back8_payment2);
    	panel.add(back9_jan2);
    	panel.add(Loading_message);
    	
    	
        panel.add(password);
        panel.add(status);
        panel.add(textfield);
        panel.add(random);
        
        panel.add(pro1);
        panel.add(pro2);
        panel.add(pro3);
        panel.add(pro4);
        panel.add(pro5);
        panel.add(pro6);
        panel.add(SUM);
        panel.add(message);
        panel.add(timer);
        
       // panel.add(checked);
       // panel.add(unchecked);
        
        frame.getContentPane().add(panel);
        panel.add(button1_basic);
        panel.add(button2_basic);
        panel.add(button3_basic);
        panel.add(button4_basic);
        panel.add(button5_basic);
        panel.add(button6_basic);
        panel.add(button7_basic);
        panel.add(button8_basic);
        panel.add(button9_basic);
        panel.add(button0_basic);
        panel.add(backbutton_basic);
        panel.add(checkbutton_basic);
        panel.add(paybutton_basic);
        
        panel.add(checked);
       
    }
    
    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }
    
    
 
    public void render(Mat image) {

    	Image i = toBufferedImage(image);
        panel.setImage(i);
        panel.repaint();
        frame.pack();
    }
    
    public String readFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader (file));
        String         line = null;
        StringBuilder  stringBuilder = new StringBuilder();
        String         ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }
 
    public static Image toBufferedImage(Mat m) {
              // Code from http://stackoverflow.com/questions/15670933/opencv-java-load-image-to-gui
              // Check if image is grayscale or color
          int type = BufferedImage.TYPE_BYTE_GRAY;
          if ( m.channels() > 1 ) {
              type = BufferedImage.TYPE_3BYTE_BGR;
          }
 
              // Transfer bytes from Mat to BufferedImage
          int bufferSize = m.channels()*m.cols()*m.rows();
          byte [] b = new byte[bufferSize];
          m.get(0,0,b); // get all the pixels
          BufferedImage image = new BufferedImage(m.cols(), m.rows(), type);
          final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
          System.arraycopy(b, 0, targetPixels, 0, b.length);
          return image;
      }
}

