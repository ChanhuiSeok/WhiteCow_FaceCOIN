package white_cow_gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ReceiveThread extends Thread{

	private Socket m_Socket;
	
	static String id;
	
	public static ReceiveThread temp = null;
	public static ReceiveThread getInstance()
	{
		if(temp!=null)
			return temp;
		else
		{
				temp = new ReceiveThread();
			return temp;
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
			//BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_Socket.getInputStream()));
			
			InputStream receiver = m_Socket.getInputStream();
		    
			while(true)
			{
				byte[] data = new byte[100];
				receiver.read(data, 0, data.length);
	            
	            String message = new String(data);
	            String out = String.format("recieve - %s", message);
	            //System.out.println(out);
				
				//receiveString = tmpbuf.readLine();
				
				if(message == null)
				{
					System.out.println("상대방 연결이 끊겼습니다.");
					break;
				}else if(message.contains("id"))
				{
		            System.out.println(out);
					id=message.split("-")[1];
					test1();
					
				}
				else
				{
					//System.out.println("상대방 : " + receiveString);
		            System.out.println(out);
				}
				
			}

			receiver.close();
			//tmpbuf.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    public static void test1() {
    	File file = new File("./id.txt");
        FileWriter fileWriterTest = null;
        PrintWriter newLineTest = null;
    	try {
            fileWriterTest = new FileWriter(file);
            fileWriterTest.flush();
            id = id.replaceAll(" ", "");
            MyGlobals.getInstance().setId(id);
            //Main.userdata=id.split("_");
            fileWriterTest.write(id);
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
	
	
	public void setSocket(Socket _socket)
	{
		m_Socket = _socket;
	}

}
