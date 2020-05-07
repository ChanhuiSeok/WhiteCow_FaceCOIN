package white_cow_gui;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MainServer {
	
	public void ServerOpen()
	{
		try {
			ServerSocket s_socket = new ServerSocket(8091);

			System.out.println("서버 오픈");
			Socket c_socket = s_socket.accept();
			System.out.println("클라이언트 연결됨");
			
			
			ReceiveThread.getInstance().setSocket(c_socket);
			SendThread.getInstance().setSocket(c_socket);
			
			ReceiveThread.getInstance().start();
			SendThread.getInstance().start();
			
			//SendThread.getInstance().sendMessage("testMessage");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
