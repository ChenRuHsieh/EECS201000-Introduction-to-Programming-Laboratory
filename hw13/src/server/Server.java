package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server{
	int port;
	ServerSocket socket;
	
	public Server() {
	}
	
	
	public void setup(int port)  {
		try {
			System.out.println("Server 建立中...");
			socket= new ServerSocket(port);
			System.out.println("Server 建立成功...");
			System.out.println("Server IP : " + socket.getInetAddress().getHostAddress());
		} catch (IOException e) {
			System.out.println("Server 建立失敗...");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)  {
		
		Server server = new Server();
		ServerUI ui = new ServerUI(server);
		
		while(true) {
			if(Data.isSetup) {
				Socket socketServer = null;
				try {
					System.out.println("等待與客戶端連接...");
					socketServer = server.socket.accept();
					System.out.println("與客戶端連接成功...");
				} catch (IOException e2) {
					System.out.println("與客戶端連接失敗...");
					e2.printStackTrace();
				}
				ui.setSocket(socketServer);
				
				BufferedReader reader = null;
				try {
					System.out.println("Reader 建立中...");
					InputStreamReader clientInput = new InputStreamReader(socketServer.getInputStream());
					reader = new BufferedReader(clientInput); 
					System.out.println("Reader 建立成功...");
				} catch (IOException e1) {
					System.out.println("Reader 建立失敗...");
					e1.printStackTrace();
				} 
				
				String strNewClick = "";
				do {
					if(Data.isRead) {
						try {
							System.out.println("等待接受Client訊息...");
							strNewClick = reader.readLine();
							System.out.println("接受Client訊息成功...");
							System.out.println("Client : " + strNewClick);
						} catch (IOException e) {
							System.out.println("接受Client訊息失敗...");
							e.printStackTrace();
						}
						Data.put(strNewClick);
						Data.changePlayer();
						Data.isRead = false;
						ui.resetButton();
						ui.resetLabel();
					}
					else {
						System.out.print("");
					}
				} while(!strNewClick.equals("bye"));
				
				try {
					socketServer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				System.out.print("");
			}
		}
	}
}
