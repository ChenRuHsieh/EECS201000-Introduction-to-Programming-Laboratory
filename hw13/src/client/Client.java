package client;

import java.io.IOException;

public class Client {
	public static void main(String[] arg0) {
		ClientUI ui = new ClientUI();
		ClientSocket c = new ClientSocket();
		ui.setSocket(c);
		
		String strNewClick = "";
		while(true) {
			if(Data.isWrite) {
				Data.isWrite = false;
				try {
					System.out.println("等待Server訊息...");
					strNewClick = c.reader.readLine();
					System.out.println("接收Server訊息成功...");
					System.out.println("Server : " + strNewClick);
				} catch (IOException e) {
					System.out.println("接收Server訊息失敗...");
					e.printStackTrace();
				}
				Data.put(strNewClick);
				Data.changePlayer();
				ui.resetButton();
				ui.resetLabel();
			}
			else {
				System.out.print("");
			}
		}
	}
}
