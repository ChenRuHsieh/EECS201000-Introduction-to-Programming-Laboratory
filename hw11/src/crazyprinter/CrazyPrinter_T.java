package crazyprinter;

import java.io.PrintStream;

public class CrazyPrinter_T extends Thread{
	PrintStream out;
	
	public CrazyPrinter_T(PrintStream out) {
		this.out = out;
	}
	
	public void run() {
		for(int i = 1; i <= 1000; i++) {
			outputFile(i);
			System.out.println("Thread Time : " + i);
		}
	}
	
	private void outputFile(int i) {
		out.println("Thread Time : " + i);
	}
}
