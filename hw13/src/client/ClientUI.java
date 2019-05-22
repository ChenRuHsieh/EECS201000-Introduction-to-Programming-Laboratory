package client;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;





public class ClientUI extends JFrame
	implements ActionListener{
	JPanel cp;
	JTextField IPf, portf;
	JButton enter;
	JButton[][] bt = new JButton[3][3];
	GridBagLayout layout;
	GridBagConstraints s;
	JLabel winner, player;
	ClientSocket socket;
	
	public ClientUI() {
		super("Cilent O Player");
		cp = (JPanel) this.getContentPane();
		
		
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
		player = new JLabel("I am O Palyer");
		cp.add(player);
		IPf = new JTextField(20);
		IPf.setText(Data.IP);
		cp.add(IPf);
		portf = new JTextField(6);
		portf.setText(Data.port);
		cp.add(portf);
		enter = new JButton("Enter");
		enter.addActionListener(this);
		enter.setActionCommand(Data.strEnter);
		cp.add(enter);
		
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
		s.gridy = Data.size;s.gridx = 0;
		s.gridwidth = 0;
		layout.setConstraints(winner, s);
		s.gridy = Data.size + 1; s.gridx = 0;
		layout.setConstraints(player, s);
		s.gridy = Data.size + 2; s.gridx = 0;
		layout.setConstraints(IPf, s);
		s.gridy = Data.size + 3;
		layout.setConstraints(portf, s);
		s.gridy = Data.size + 4;
		layout.setConstraints(enter, s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
	}
	
	public void setSocket(ClientSocket socket) {
		this.socket = socket;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(!Data.isConnet) {
			if(command.equals(Data.strEnter)) {
				socket.IP = IPf.getText();
				socket.port = Integer.parseInt(portf.getText());
				socket.connect();
				Data.isConnet = true;
			}
		}
		else if(Data.isOTurn && !Data.isWrite && Data.isConnet) {
			Data.step++;
			//(i,j)
			int row = command.charAt(1) - '0';
			int col = command.charAt(3) - '0';
			String strOut = "";
			strOut = "Row : " + row + " Col : " + col + " Be Clicked!";
			try { 
				socket.writer.writeBytes(strOut + "\n");//告訴Server哪裡被點
				Data.isWrite = true;
			} catch (IOException e1) {}
			Data.put(strOut);
			Data.changePlayer();
			resetButton();
			resetLabel();
		}
		else {
			System.out.println("Not Your Turn");
			System.out.println("O Turn : " + Data.isOTurn);
			System.out.println("isWrite : " + Data.isWrite);
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
