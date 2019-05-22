package simplenotepad;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



public class SimpleNotepad extends JFrame implements ActionListener{
	static String strFile = "File";
	static String strOpen = "Open";
	static String strSave = "Save";
	static String newline = "\n";
	JMenuBar menuBar;
	JMenu menu, submenu;
	JMenuItem menuitem;
	JTextArea log;
    JFileChooser fc;
    
	public SimpleNotepad() {
		super("SimpleNotepad");
		JPanel cp = (JPanel) this.getContentPane();
		
		log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(true);
        JScrollPane logScrollPane = new JScrollPane(log);
		
        fc = new JFileChooser();
        
		//Create the menu bar.
		menuBar = new JMenuBar();
		//Build the Main menu.
		menu = new JMenu(strFile);
		menu.setMnemonic(KeyEvent.VK_F);
		menu.setActionCommand(strFile);
		menu.add(MenuItem(strOpen));
		menu.addSeparator();
		menu.add(MenuItem(strSave));
		menuBar.add(menu);
		cp.add(menuBar, BorderLayout.PAGE_START);
        cp.add(logScrollPane, BorderLayout.CENTER);
		
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
        if(actionCommand.equals(strOpen)) {
        	int returnVal = fc.showOpenDialog(SimpleNotepad.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File load = fc.getSelectedFile();
                log.setText("");
                System.out.print("Opening: " + load.getName() + "." + newline);
                try {
					readFile(load);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.print("Read Err!");
					e1.printStackTrace();
				}
            } else {
            	System.out.print("Open command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
        }
        else if (actionCommand.equals(strSave)) {
            int returnVal = fc.showSaveDialog(SimpleNotepad.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File save = fc.getSelectedFile();
                System.out.print("Saving: " + save.getName() + "." + newline);
                try {
					saveFile(save);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println("Save Err!");
					e1.printStackTrace();
				}
            } else {
            	System.out.print("Save command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
        }
	}
	
	private void readFile(File readFile) throws FileNotFoundException {
		//Scanner input = new Scanner(new BufferedReader(new FileReader(readFile)));
		Scanner input = new Scanner(readFile, "UTF-8");
		System.out.println("readFile Path : " + readFile.getAbsolutePath());
		//System.out.println(input.hasNextLine());
		if(!readFile.exists()) {
			try {
				readFile.createNewFile();
				System.out.println("readFile not existed, so created");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Save new file failed!!!");
				//e.printStackTrace();
			}
		}
		while(input.hasNextLine()) {
			String str = input.nextLine();
			System.out.println(str);
			log.append(str + newline);
		}
		input.close();
	}
	
	private void saveFile(File saveFile) throws FileNotFoundException {
		if(!saveFile.exists()) {
			try {
				saveFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Save new file failed!!!");
				//e.printStackTrace();
			}
		}
		
		String[] strs = log.getText().split("\n");
		PrintStream out = new PrintStream(saveFile);
		for(int i = 0; i < strs.length; i++) {
			out.println(strs[i]);
		}
		out.close();
	}
}
