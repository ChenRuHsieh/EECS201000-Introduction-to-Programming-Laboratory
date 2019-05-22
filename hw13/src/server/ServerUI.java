package server;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class ServerUI extends JFrame
implements ActionListener{
	JPanel cp;
	JButton[][] bt = new JButton[3][3];
	GridBagLayout layout;
	GridBagConstraints s;
	JLabel winner, player;
	Socket socketServer;
	DataOutputStream writer;
	Server server;
	JTextField portf;
	JButton setupB;
	
	
	public ServerUI(Server server) {
		super("Server X Player");
		this.server = server;
		cp = (JPanel) this.getContentPane();
		
		player = new JLabel("I am X Palyer");
		cp.add(player);
		for(int i = 0; i < Data.size; i++) {
			for(int j = 0; j < Data.size; j++) {
				if(Data.map[i][j] == 0)
					bt[i][j] = new JButton(" ");
				bt[i][j].setSize(50, 50);
				bt[i][j].setActionCommand(Data.strMap[i][j]); //(i,j)
				bt[i][j].addActionListener(this);
				
				cp.add(bt[i][j]);
			}
		}
		winner = new JLabel("O Turn");
		cp.add(winner);
		portf = new JTextField(7);
		portf.setText(Data.port);
		cp.add(portf);
		setupB = new JButton(Data.strSetup);
		setupB.addActionListener(this);
		setupB.setActionCommand(Data.strSetup);
		cp.add(setupB);
		
		layout = new GridBagLayout();
		cp.setLayout(layout);
		s = new GridBagConstraints();
		s.insets  = new Insets(5, 5, 5, 5);
		s.fill = GridBagConstraints.BOTH;
		s.weightx = 0; s.weighty = 0;
		s.gridwidth = 1;
		
		
		for(int i = 0; i < Data.size; i++) {
			s.gridy = i;
			for(int j = 0; j < Data.size; j++) {
				s.gridx = j;
				layout.setConstraints(bt[i][j], s);
				layout.setConstraints(bt[i][j], s);
				layout.setConstraints(bt[i][j], s);
			}
		}
		s.gridy = Data.size; s.gridx = 0;
		s.gridwidth = 0;
		layout.setConstraints(winner, s);
		s.gridy = Data.size + 1; s.gridx = 0;
		layout.setConstraints(player, s);
		s.gridy = Data.size + 2;
		layout.setConstraints(portf, s);
		s.gridy = Data.size + 3;
		layout.setConstraints(setupB, s);
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void setSocket (Socket socket) {
		this.socketServer = socket;
		OutputStream serverOutput;
		try {
			System.out.println("Writer建立中...");
			serverOutput = socketServer.getOutputStream();
			writer = new DataOutputStream(serverOutput);
			System.out.println("Writer建成功...");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(!Data.isSetup) {
			if(command.equals(Data.strSetup)) {
				server.setup(Integer.parseInt(portf.getText()));
				Data.isSetup = true;
			}
		}
		else if(!Data.isOTurn && !Data.isRead && Data.isSetup) {
			Data.step++;
			//(i,j)
			int row = command.charAt(1) - '0';
			int col = command.charAt(3) - '0';
			String strOut = "";
			strOut = "Row : " + row + " Col : " + col + " Be Clicked!";
			try { 
				writer.writeBytes(strOut + "\n");//告訴Client哪裡被點
			} catch (IOException e1) {}
			Data.put(strOut);
			Data.changePlayer();
			resetButton();
			resetLabel();
			Data.isRead = true;
		}
		else {
			System.out.println("Not Your Turn");
			System.out.println("O Turn : " + Data.isOTurn);
			System.out.println("isRead : " + Data.isRead);
		}
	}
	
	public void resetButton() {
		//System.out.println("strIndex : " + index);
		for(int i = 0; i < Data.size; i++) {
			for(int j = 0; j < Data.size; j++) {
				int indexValue = Data.map[i][j];
				if(indexValue== Data.intO)
					bt[i][j].setText("O");
				else if(indexValue == Data.intX)
					bt[i][j].setText("X");
				else if(indexValue == Data.intBlank)
					bt[i][j].setText("  ");
			}
		}
	}
	
	public void resetLabel() {
		if(!Data.winnerExist) { //No O
			if(Data.CheckCircle()) {
				winner.setText("O Win");
				Data.winnerExist = true;
			}
			else if(Data.CheckCross()) {
				winner.setText("X Win");
				Data.winnerExist = true;
			}
			else if(Data.isOTurn) {
				winner.setText("O turn");
			}
			else {
				winner.setText("X turn");
			}
		}
	}
}
