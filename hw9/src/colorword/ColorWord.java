package colorword;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorWord extends JFrame 
	implements ActionListener{
	
	JTextField TF;
	JRadioButton BLUE;
	JRadioButton RED;
	ButtonGroup group;
	static String strBlue = "BLUE";
	static String strRed = "RED";
	public ColorWord() {
		super("ColorWord");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		JPanel cp = (JPanel) this.getContentPane();
		FlowLayout layout = new FlowLayout();
		cp.setLayout(layout);
		
		//JLabel LB = new JLabel("Hello World!!!");
		cp.add(addTextField());
		
		group = new ButtonGroup();
		
		BLUE = new JRadioButton(strBlue);
		BLUE.setActionCommand(strBlue);
		cp.add(BLUE);
		group.add(BLUE);
		
		RED = new JRadioButton(strRed);
		RED.setActionCommand(strRed);
		group.add(RED);
		cp.add(RED);
		
		
		BLUE.addActionListener(this);
		RED.addActionListener(this);
		
		this.pack();
	}
	
	private JPanel addTextField() {
		JPanel p = new JPanel();
		TF = new JTextField(12);
		p.add(TF);
		return p;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        String actionCommand = e.getActionCommand();
		//System.out.println("Selected Button = " + actionCommand);
        if(actionCommand.equals(strBlue)) {
        	System.out.println("Selected Button = " + actionCommand);
        	TF.setForeground(Color.BLUE);
        }
        else if(actionCommand.equals(strRed)) {
        	System.out.println("Selected Button = " + actionCommand);
        	TF.setForeground(Color.RED);
        }
	}
	
	
	
}
/*
class MyListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stubI
		System.out.println("I am Clicked!!!");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}*/