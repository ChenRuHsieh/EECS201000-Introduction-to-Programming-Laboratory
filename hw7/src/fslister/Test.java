package fslister;

import java.io.File;
import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		String loadPath = ".\\src\\fslister\\load";
		FSLister f = new FSLister(loadPath);
		
		String resultPath = ".\\src\\fslister\\result.txt";
		f.showFileList(resultPath);
	}

}
