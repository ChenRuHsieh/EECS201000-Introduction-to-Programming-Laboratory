package commentsdeleter;

import java.io.FileNotFoundException;


public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		String testPath = ".\\src\\commentsdeleter\\Lab7.java";
		CommentsDeleter c = new CommentsDeleter(testPath);
		
		String resultPath = ".\\src\\commentsdeleter\\NewLab7.java";
		c.showCommentsDeleter(resultPath);
	}
}
