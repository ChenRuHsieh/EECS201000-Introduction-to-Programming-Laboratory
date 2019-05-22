package lab6;

import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		int value = 0;
		boolean io_wrong = true;
		//boolean appro_wrong = true;		
		while(io_wrong) {
			try {
				System.out.printf("請輸入value : ");
				value = Lab.readKeyboardInt();
				io_wrong = false;
			} catch (IOException e) {
				System.out.println("IO Error");
				e.printStackTrace();
			}
		}
		
		
		try {
			System.out.println("2的10次方 = " + Lab.exp(2, 10));
			System.out.printf("若做exp時，次方小於0 :");
			Lab.exp(value, -1);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		for(double i = 0; i <= 1.3; i += 0.4) {
			int times = 0;
			try {
				times = Lab.approach(i);
				System.out.println(i + "的" + times + "次方最接近0.1");
				//appro_wrong = false;
			} catch(MyException e){}
		}
		
	}
}
