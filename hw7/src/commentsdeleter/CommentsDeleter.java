package commentsdeleter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class CommentsDeleter {
	private String directory;
	private String resultPath;
	
	public CommentsDeleter(String d) {
		this.directory = d;
	}
	
	public void showCommentsDeleter(String filePath) throws FileNotFoundException {
		this.resultPath = filePath;
		//String testPath2 = ".\\src\\commentsdeleter\\Lab7.java";
		//String resultPath2 = ".\\src\\commentsdeleter\\NewLab7.java";
		File testFile = new File(this.directory);
		File resultFile = new File(this.resultPath);
		boolean isComment = false;
		
		if(!resultFile.exists())
			try {
				resultFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Create New File Error");
				e.printStackTrace();
			}
		
		Scanner input = new Scanner(testFile);
		PrintStream out = new PrintStream(resultFile);
		
		while(input.hasNextLine()) {
			String str = input.nextLine();
			char[] ch = str.toCharArray();
			for(int i = 0; i < ch.length; i++) {
				//System.out.print(ch[i]);
				if(ch[i] == '/' && i != ch.length-1) {
					if(ch[i+1] == '/') { //單行註解
						break;
					}
					else if(ch[i+1] == '*') { //多行註解
						isComment = true;
						break;
					}
					else {
						out.print(ch[i]);
					}
				}
				else if(ch[i] == '*' && isComment && i != ch.length-1) {
					if(ch[i+1] == '/') {
						isComment = false;
						i++;
					}
				}
				else if(isComment) {
				}
				else {
					out.print(ch[i]);
				}
			}
			if(!isComment)
				out.println();
		}
		out.close();
		input.close();
		System.out.println("End");
	}
}
