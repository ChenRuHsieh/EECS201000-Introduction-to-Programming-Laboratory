package drawarc;

import java.awt.*;
import javax.swing.*;

public class DrawArc extends JFrame {
	public DrawArc() {
		super("DrawArc");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 1080, 1080);
		int width = 20, height = 300;
		int recPointx = 250 - width / 2;
		int recPointy = 250;
		g.setColor(new Color(150,0,250));
		g.fillRect(recPointx, recPointy, width, height);
	
		/*g.setColor(Color.RED);
		g.fillOval(50, 50, 20, 20);
		*/
	}
	
	public void rotate(Graphics g) {
		int outR = 250;
		int recOutPoint = 250 -  outR/2; 
		int inR = 150;
		int recInPoint = 250 - inR/2;
		int j = 0;
		while(true) {
			j = (j + 1) % 360;
			int[] startAngle = {0+j, 90+j, 180+j, 270+j};
			int[] drawAngle = {23, 23, 23, 23};
			for(int i = 0; i < startAngle.length; i++) {
				g.setColor(Color.WHITE);
				g.fillArc(recOutPoint, recOutPoint, outR, outR, startAngle[i], drawAngle[i]);
				g.setColor(Color.ORANGE);
				g.fillArc(recInPoint, recInPoint, inR, inR, startAngle[i], drawAngle[i]);
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int i = 0; i < startAngle.length; i++) {
				g.setColor(Color.BLUE);
				g.fillArc(recOutPoint, recOutPoint, outR, outR, startAngle[i], drawAngle[i]);
				g.fillArc(recInPoint, recInPoint, inR, inR, startAngle[i], drawAngle[i]);
			}
			int width = 20, height = 300;
			int recPointx = 250 - width / 2;
			int recPointy = 250;
			g.setColor(new Color(150,0,250));
			g.fillRect(recPointx, recPointy, width, height);
		}
	}
}
