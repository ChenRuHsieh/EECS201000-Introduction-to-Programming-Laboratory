package client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {
	String IP;
	int port;
	Socket socketClient;
	DataOutputStream writer;
	BufferedReader reader;
	
	public ClientSocket() {
	}
	
	public void connect() {
		System.out.println("Clinet 準備連線...");
		try {
			socketClient = new Socket(IP,port);
			System.out.println("Clinet 連線成功...");
			//System.out.println("IP : " + socketClient.getInetAddress());
			//System.out.println("Port : " + socketClient.getPort());
			
		} catch (UnknownHostException e) {
			System.out.println("Clinet 連線失敗...UnknownHostException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Clinet 連線失敗...IOException");
			e.printStackTrace();
		}
		
		InputStreamReader serverInput = null;
		try {
			System.out.println("Client Reader 建立中...");
			serverInput = new InputStreamReader(socketClient.getInputStream());
			reader = new BufferedReader(serverInput); 
			System.out.println("Client Reader 建立成功...");
		} catch (IOException e) {
			System.out.println("Client Reader 建立失敗...");
			e.printStackTrace();
		}
		
		OutputStream serverOutput = null;
		try {
			System.out.println("Client Writer 建立中...");
			serverOutput = socketClient.getOutputStream();
			writer = new DataOutputStream(serverOutput);
			System.out.println("Client Writer 建立成功...");
		} catch (IOException e1) {
			System.out.println("Client Writer 建立失敗...");
			e1.printStackTrace();
		}
	}
	
	
	
}
