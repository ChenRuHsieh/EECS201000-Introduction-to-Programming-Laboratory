package fslister;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class FSLister {
	private String directory;
	private String resultPath;
	private int height = 0;
	
	public FSLister(String directory) {
		this.directory = directory;
	}
	
	public void showFileList(String filePath) {
		this.resultPath = filePath;
		File load = new File(directory);
		File resultFile = new File(filePath);
		if(!resultFile.exists()) {
			try {
				resultFile.createNewFile();
			} catch (IOException e) {
				System.out.println("Creat result file failed!!!!!!!!!!!!!");
			}
		}
		
		PrintStream out;
		try {
			out = new PrintStream(resultPath);
			getFile(this.directory, out);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void getFile(String str, PrintStream out) {
		//String path = this.directory + File.separator + str;
		File File = new File(str);
		String[] list = File.list();
		//File resultFile = new File(this.resultPath);
		
		//PrintStream out = new PrintStream(resultPath);
		
		
		for(int i = 0; i < list.length; i++) {
			String nodePath = str + File.separator + list[i];
			File nodeFile = new File(nodePath);
			
			for(int j = 0; j < height; j++ ) {
				System.out.printf("    ");
				out.printf("    ");
			}
			
			if(nodeFile.isFile()) {
				System.out.println(nodeFile.getName());	
				out.println(nodeFile.getName());
			}
			else if(nodeFile.isDirectory()) {
				System.out.println(nodeFile.getName());
				out.println(nodeFile.getName());
				
				height++;
				getFile(nodeFile.getAbsolutePath(), out);
				height--;
			}
		}
		
		
	}
}
