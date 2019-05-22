package crazyprinter;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		String outputPath = ".//src//crazyprinter//writer.txt";
		PrintStream out = new PrintStream(outputPath);
		CrazyPrinter_T thread = new CrazyPrinter_T(out);
		CrazyPrinter_R runnable = new CrazyPrinter_R(out);
		Thread runnableT = new Thread(runnable);
	
		thread.start();
		runnableT.start();
	}
}
