package crazyprinter;


import java.io.PrintStream;

public class CrazyPrinter_R implements Runnable{
	PrintStream out;
	
	public CrazyPrinter_R(PrintStream out) {
		this.out = out;
	}
	
	public void run() {
		for(int i = 1; i <= 1000; i++) {
			outputFile(i);
			System.out.println("Runnable Time : " + i);
		}
	}
	
	private void outputFile(int i) {
		out.println("Runnable Time : " + i);
	}
}
