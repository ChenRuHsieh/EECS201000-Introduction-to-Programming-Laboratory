package fakemenu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FakeMenu extends JFrame
	implements ActionListener{
	static String strMain = "Main";
	static String strFile = "File";
	static String strNew = "New";
	static String strOpen = "Open";
	static String strSave = "Save";
	static String strEdit = "Edit";
	static String strCopy = "Copy";
	static String strCut = "Cut";
	static String strPaste = "Paste";
	static String strHelp = "Help";
	static String strAbout = "About";
	JMenuBar menuBar;
	JMenu menu, submenu;
	JMenuItem menuitem;
	
	public FakeMenu() {
		super("FakeMenu");
		JPanel cp = (JPanel) this.getContentPane();
		//Create the menu bar.
		menuBar = new JMenuBar();

		//Build the Main menu.
		menu = new JMenu(strMain);
		menu.setMnemonic(KeyEvent.VK_M);
		menu.setActionCommand(strMain);
		menuBar.add(menu);
		
		//Build the File menu.
		submenu = new JMenu(strFile);
		submenu.setMnemonic(KeyEvent.VK_F);
		submenu.setActionCommand(strFile);
		
		submenu.add(MenuItem(strNew));
		submenu.add(MenuItem(strOpen));
		submenu.add(MenuItem(strSave));
		menu.add(submenu);
		
		//Build the Edit menu.
		submenu = new JMenu(strEdit);
		submenu.setMnemonic(KeyEvent.VK_E);
		submenu.setActionCommand(strEdit);
		
		submenu.add(MenuItem(strCopy));
		submenu.add(MenuItem(strCut));
		submenu.add(MenuItem(strPaste));
		menu.add(submenu);
		
		//Build the Help menu.
		submenu = new JMenu(strHelp);
		submenu.setMnemonic(KeyEvent.VK_H);
		submenu.setActionCommand(strHelp);
		
		submenu.add(MenuItem(strAbout));
		menu.add(submenu);
	
		cp.add(menuBar);
		this.pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	private JMenuItem MenuItem(String str) {
		JMenuItem item = new JMenuItem(str);
		item.setActionCommand(str);
		item.addActionListener(this);
		return item;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        String actionCommand = e.getActionCommand();
        System.out.println(actionCommand + " Clicked!!!");
	}
}
