package datachooser;

import java.io.FileNotFoundException;

public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		String dataPath = ".\\src\\datachooser\\data.txt";
		DataChooser d = new DataChooser(dataPath);
		
		String resultPath = ".\\src\\datachooser\\.\\newdata.txt";
		d.showDataChooser(resultPath);
	}
}
