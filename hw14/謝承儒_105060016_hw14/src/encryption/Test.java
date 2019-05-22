package encryption;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Encryption e = new Encryption();
		boolean isEncode = false;
		while(true) {
			System.out.print("choose e(encode) or d(decode) or exit : " );
			String input = scan.nextLine();
			if(input.equals("exit")) { 
				break;
			}
			else if(input.equals("e")) {
				isEncode = true;
			}
			else if(input.equals("d")) {
				isEncode = false;
			}
			
			String result;
			if(isEncode) {
				System.out.print("加密前 : ");
				input = scan.nextLine();
				result = e.encode(input);
				System.out.println("加密後 : " + result);
			}
			else {

				System.out.print("解密前 : ");
				input = scan.nextLine();
				result = e.decode(input);
				System.out.println("解密後 : " + result);
			}
			
		}
		System.out.println("Program Exited");
		scan.close();
	}
}
