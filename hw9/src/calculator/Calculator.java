package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Calculator extends JFrame {
	public Calculator() {
		super("Calculator");
		JPanel cp = (JPanel) this.getContentPane();
		
		
		//Create the menu bar.
		JMenuBar menuBar = new JMenuBar();

		//Build the first menu.
		JMenu menu = new JMenu("View");
		menu.setMnemonic(KeyEvent.VK_V);
		menu.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		menuBar.add(menu);
/*
		//a group of JMenuItems
		JMenuItem menuItem = new JMenuItem("A text-only menu item",
		                         KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
		        "This doesn't really do anything");
		menu.add(menuItem);

		menuItem = new JMenuItem("Both text and icon",
		                         new ImageIcon("images/middle.gif"));
		menuItem.setMnemonic(KeyEvent.VK_B);
		menu.add(menuItem);

		menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
		menuItem.setMnemonic(KeyEvent.VK_D);
		menu.add(menuItem);

		//a group of radio button menu items
		menu.addSeparator();
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
		rbMenuItem.setSelected(true);
		rbMenuItem.setMnemonic(KeyEvent.VK_R);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Another one");
		rbMenuItem.setMnemonic(KeyEvent.VK_O);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);

		//a group of check box menu items
		menu.addSeparator();
		JCheckBoxMenuItem cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
		cbMenuItem.setMnemonic(KeyEvent.VK_C);
		menu.add(cbMenuItem);

		cbMenuItem = new JCheckBoxMenuItem("Another one");
		cbMenuItem.setMnemonic(KeyEvent.VK_H);
		menu.add(cbMenuItem);

		//a submenu
		menu.addSeparator();
		JMenu submenu = new JMenu("A submenu");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("An item in the submenu");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_2, ActionEvent.ALT_MASK));
		submenu.add(menuItem);

		menuItem = new JMenuItem("Another item");
		submenu.add(menuItem);
		menu.add(submenu);
*/
		//Build second menu in the menu bar.
		menu = new JMenu("Edit");
		menu.setMnemonic(KeyEvent.VK_E);
		menu.getAccessibleContext().setAccessibleDescription(
		        "This menu does nothing");
		menuBar.add(menu);
		
		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);
		menu.getAccessibleContext().setAccessibleDescription(
		        "This menu does nothing");
		menuBar.add(menu);

		setJMenuBar(menuBar);
		

		JLabel LB = new JLabel("0");
		cp.add(LB);
		JButton[] BT = new JButton[28];
		String[] str = {
					"MC", "MR", "MS", "M+", "M-",
					"<-", "CE", "C" , "±" , "√" ,
					"7" , "8" , "9" , "/" , "%" ,
					"4" , "5" , "6" , "*" , "1/x",
					"1" , "2" , "3" , "-" , "=" ,
					"0" , "." , "+" 
					};
		
		for(int i = 0; i < str.length; i++) {
			BT[i] = new JButton(str[i]);
			cp.add(BT[i]);
		}
		
		GridBagLayout layout = new GridBagLayout();
		cp.setLayout(layout);
		GridBagConstraints s = new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH;
		s.weightx = 0; s.weighty = 0;
		
		s.gridwidth = 0;
		layout.setConstraints(LB, s);
		
		for(int i = 0; i < 4; i++) {
			s.gridwidth = 1;
			layout.setConstraints(BT[5*i], s);
			layout.setConstraints(BT[5*i + 1], s);
			layout.setConstraints(BT[5*i + 2], s);
			layout.setConstraints(BT[5*i + 3], s);
			s.gridwidth = 0;
			layout.setConstraints(BT[5*i + 4], s);
		}
		/*
		s.gridwidth = 1;
		layout.setConstraints(BT[5], s);
		layout.setConstraints(BT[6], s);
		layout.setConstraints(BT[7], s);
		layout.setConstraints(BT[8], s);
		s.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(BT[9], s);
		
		s.gridwidth = 1;
		layout.setConstraints(BT[10], s);
		layout.setConstraints(BT[11], s);
		layout.setConstraints(BT[12], s);
		layout.setConstraints(BT[13], s);
		s.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(BT[14], s);
		
		s.gridwidth = 1;
		layout.setConstraints(BT[15], s);
		layout.setConstraints(BT[16], s);
		layout.setConstraints(BT[17], s);
		layout.setConstraints(BT[18], s);
		s.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(BT[19], s);
		*/
		s.gridwidth = 1;
		layout.setConstraints(BT[20], s);
		layout.setConstraints(BT[21], s);
		layout.setConstraints(BT[22], s);
		layout.setConstraints(BT[23], s);
		s.gridx = 5; s.gridy = 5;
		s.gridwidth = 0; s.gridheight = 2;
		layout.setConstraints(BT[24], s);// =
		
		s.gridx = 0; s.gridy = 6;
		s.gridwidth = 2; s.gridheight = 1;
		layout.setConstraints(BT[25], s); // 0
		s.gridx = 2; s.gridy = 6;
		s.gridwidth = 1;
		layout.setConstraints(BT[26], s); // .
		s.gridx = 3; s.gridy = 6;
		s.gridwidth = 1;
		layout.setConstraints(BT[27], s); // +

		this.pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	
}
