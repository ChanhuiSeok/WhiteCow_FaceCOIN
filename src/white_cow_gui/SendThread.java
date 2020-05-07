package white_cow_gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SendThread extends Thread{

	private Socket m_Socket;
	
	BufferedReader tmpbuf=null;
	PrintWriter sendWriter=null;
	
	public static SendThread temp = null;
	public static SendThread getInstance()
	{
		if(temp!=null)
			return temp;
		else
		{
				temp = new SendThread();
			return temp;
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			tmpbuf = new BufferedReader(new InputStreamReader(System.in));
			sendWriter = new PrintWriter(m_Socket.getOutputStream());
			String sendString;
			
			while(true)
			{
				sendString = tmpbuf.readLine();
			
				sendWriter.println(sendString);
				sendWriter.flush();
				
				if(sendString.contains("image"))
				{
					SendThread.getInstance().sendFile();
	
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMessage(String s)
	{
		String sendString = s;
		
		sendWriter.println(sendString);
		sendWriter.flush();
	}
	
	public void sendFile()
	{

		  File imgfile = new File("./test.jpg");
		  try {
			FileInputStream fis = new FileInputStream(imgfile);
			OutputStream os = m_Socket.getOutputStream();

			String flen = String.valueOf(imgfile.length());
			String header = "0000000000".substring(0, 10-flen.length()) + flen;
			
			byte buffer[] = new byte[2048];

		    os.write(header.getBytes());
		    
			while (fis.available() > 0) {

			      int readsz = fis.read(buffer);

			      os.write(buffer, 0, readsz);
			      
			      
			    }
				
				os.flush();
			    //fis.close();
			
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void setSocket(Socket _socket)
	{
		m_Socket = _socket;
	}
	
}
