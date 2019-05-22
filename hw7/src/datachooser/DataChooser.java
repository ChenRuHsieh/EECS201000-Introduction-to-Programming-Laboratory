package datachooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class DataChooser {
	private String directory;
	private String resultPath;
	
	public DataChooser(String d) {
		this.directory = d;
	}
	
	public void showDataChooser(String filePath) throws FileNotFoundException {
		this.resultPath = filePath;
		int inputLine = 0;
		int[] dataInt = new int[5];
		String[] dataStr = new String[5];
		int arraySize = 5;
		int i, j;
		
		File dataFile = new File(this.directory);
		File newDataFile = new File(this.resultPath);
		Scanner input = new Scanner(dataFile);
		
		if(!newDataFile.exists())
			try {
				newDataFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Create new file failed!!!");
				//e.printStackTrace();
			}
			
		while(input.hasNextLine()) {
			//if(inputLine == 8)
				//break;
			if(inputLine >= arraySize) {
				int newInt[] = new int[arraySize*2];
				String newStr[] = new String[arraySize*2];
				System.arraycopy(dataInt, 0, newInt, 0, arraySize);
				System.arraycopy(dataStr, 0, newStr, 0, arraySize);
				arraySize *= 2;
				dataInt = newInt;
				dataStr = newStr;
			}
			
			for(i = 0; i < 4; i++){
				if(i == 0)
					dataStr[inputLine] = input.next();
				else if(i == 2) {
					int tmp = input.nextInt();
					if(tmp < 10000)
						dataStr[inputLine] += ("  " + tmp);
					else
						dataStr[inputLine] += (" " + tmp);
				}
				else
					dataStr[inputLine] += ("  " + input.next());
				
				//System.out.println("i = " + i + " " + dataStr[inputLine]);
			}
			dataInt[inputLine] = input.nextInt();
			
			dataStr[inputLine] += "  " + dataInt[inputLine];
			dataStr[inputLine] += input.nextLine();
			//System.out.println("Line " + inputLine + " : " + dataStr[inputLine]);
			//System.out.println("LineInt" + inputLine + " : " + dataInt[inputLine]);
			inputLine++;
		}
		input.close();
		for(i = 0; i < inputLine; i++) {
			for(j = i+1 ; j < inputLine; j++) {
				if(dataInt[i] > dataInt[j]) {
					int tmpInt = dataInt[j];
					dataInt[j] = dataInt[i];
					dataInt[i] = tmpInt;
					
					String tmpStr = dataStr[j];
					dataStr[j] = dataStr[i];
					dataStr[i] = tmpStr;
				}
			}
		}
		PrintStream out = new PrintStream(newDataFile);
		for(i = 0; i < inputLine; i++) {
			out.println(dataStr[i]);
		}
		out.close();
		/*
		for(i = 0; i < 10000; i++)
			System.out.println(dataStr[i]);
		//System.out.println("data line : " + dataLine);
		 */
		System.out.println("The min Line is : \n" + dataStr[0]);
	}
}
