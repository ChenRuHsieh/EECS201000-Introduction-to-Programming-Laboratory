package lab6;

import java.io.*;

class MyException extends Exception{
	MyException(){ };
	MyException(String msg){
		System.out.println(msg);
	}
}

public class Lab {
    /**   A buffered reader attached to the keyboard. If you store this value
      *   in a variable kbd (say), then
      * 
      *      kbd.readLine()
      * 
      *   will prompt the reader to type a line by putting in the Interactions pane
      *   a field into which to type and will then yield the string of characters
      *   the user typed in.
      */    
    public static BufferedReader getKeyboard()  {
        // Create a link to the keyboard
        return new BufferedReader(new InputStreamReader(System.in));
    }
    
    
    
    /** Prompt the reader to type a line into the interactions pane and
      * return the line that the user types. */
    public static String readKeyboardLine() throws IOException {
        BufferedReader kyboard = getKeyboard();
        String line= kyboard.readLine();
        return line;
    }
    
    /** Prompt the reader to type an integer (an int) into the interactions pane
      * and return the integer that they type. If the user types something that
      * is not an int, then issue a message (System.out.println(...) and prompts
      * again.
      */
    public static int readKeyboardInt() throws IOException {
        BufferedReader kyboard = getKeyboard();
        int ky_value = 0;
        boolean wrong = true;
        
        while(wrong) {
	        try {
	        	String str = kyboard.readLine();
	        	ky_value = Integer.parseInt(str);
	        	System.out.println("你輸入了" + ky_value);
	        	wrong = false;
	        } catch(NumberFormatException e) {
	        	e.getStackTrace();
	        	System.out.println("輸入格式錯誤");
	        }
        }
        return ky_value;
    }
    
    /** = b**c.
          Precondition: c ?0
        */
    public static double exp(double b, int c) throws MyException{
        if(c < 0)
        	throw new MyException("c<0");
    	if (c == 0)
            return 1;
        // c > 0
        if (c%2 == 0)
            return exp(b*b, c / 2);
        // c is odd and > 0
        return b * exp(b, c-1);
    }
    
    /**   The value i such that x**i <= .00000001 but x**(i-1) is not.
          Throw MyException if x <= 0 or 1 <= x. 
       */
    public static int approach(double x) throws MyException {
        int i= 1; // stub; you have to complete this function
        if(x <= 0) {
        	throw new MyException("value <= 0 不合法");
        }
        else if(x >= 1) {
        	throw new MyException("value >= 1 不合法");
        }
        else {
        	boolean wrong = true;
        	while(wrong) {
        		if(exp(x, i) < 0.1 && exp(x, i-1) > 0.1) {
        			wrong = false;
        		}
        		i++;
        	}
        }
        return i;
        
    }
}
