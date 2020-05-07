package white_cow_gui;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Security;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;
import org.opencv.highgui.VideoCapture;
import java.io.BufferedReader;


public class Main {
	static DBManager dbManager;
	static String[] userdata;
	static String pwdata;
	static String idfilename = "id.txt";
	static String pwfilename = "password.txt";
	static String text="";
	static int num = 1;
	static int num2 = 1;
	static boolean data_exist = false;
    
    static String file1 = "./password.txt";
    static String password1;
    
    static {
        // Load the native OpenCV library
        System.loadLibrary("opencv_java2411");
    }
 
    public static void main(String[] args) throws FileNotFoundException {
        // Register the default camera
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		
    	dbManager = new DBManager();
    	MainServer mainserver = new MainServer();
    	mainserver.ServerOpen();
		BlockThread.getInstance().start();
		NoobChain.LoadData();
		//NoobChain.InitWallet();
		
    	///id.txt password.txt 둘 다 받은 다음에 실행
    	
    	//dbManager.insert_user_info("Parkmyunghun", "960730", "4", "1234");
    	//dbManager.insert_user_info("Jangsungwon", "961203", "1", "1234");
		//dbManager.delete_user_info("KimHeewon", "960924", "2", "1234");
    	//dbManager.insert_user_info("Kimheewon", "960924", "2", "1234");
    	//dbManager.insert_user_info("Parkhyosang", "960903", "3", "1234");
    	//dbManager.insert_user_info("Seokchanhee", "960723", "5", "1234");
    	//dbManager.insert_user_info("Yoonyoungshin", "961203", "6", "1234");
    	
    	//dbManager.selectAll_user_info();
    	
        VideoCapture cap = new VideoCapture(0);

////*받아오는 password1을 읽어오는 부분 
        /*
        try {
			password1 = readFile(file1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/////
		*/
        
        // Check if video capturing is enabled
        if (!cap.isOpened()) {
            System.exit(-1);
        }
 
        // Matrix for storing image
        Mat image = new Mat();
       
        // Frame for displaying image
        MyFrame frame = new MyFrame(cap, image);
        frame.setVisible(true);
       
        // Main loop
        while (true) {
            // Read current camera frame into matrix
            cap.read(image);
            test1();
           
            // Render frame if the camera is still acquiring images
            if (!image.empty()) {
                frame.render(image);
            } else {
                System.out.println("No captured frame -- camera disconnected");
            }
            
        }
        
    }
    
    public static void test1() {
    	File file = new File("./password.txt");
        FileWriter fileWriterTest = null;
        PrintWriter newLineTest = null;
    	try {
            fileWriterTest = new FileWriter(file);
            fileWriterTest.flush();
            fileWriterTest.write(text);
         }catch(Exception e) {
            e.printStackTrace();
         }finally {
            try {
               if(fileWriterTest != null) {
                  fileWriterTest.close();
               }
               if(newLineTest != null) {
                  fileWriterTest.close();
               }
            }catch(Exception ee) {
               ee.printStackTrace();
               }
         }
    	
    }
    
    public static String readFile(String file) throws IOException {
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
    
    public static void readuserdata()
    {
    	String rawString = null;
    	
    	if ((rawString = dbManager.loadData(idfilename)) == null)
		{
			System.err.println(idfilename + "파일을 읽는 도중 오류가 발생했습니다.");
			return;
		}
		
		userdata = rawString.split("_");
		userdata[2] = userdata[2].trim();
		//userdata[2] = userdata[2].replaceAll(" ", "");
		
		if ((pwdata = dbManager.loadData(pwfilename)) == null)
		{
			System.err.println(pwfilename + "파일을 읽는 도중 오류가 발생했습니다.");	
			return;
		}

    }
    
    
}