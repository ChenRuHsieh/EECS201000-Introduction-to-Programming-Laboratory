package lab6;

import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		int value = 0;
		boolean io_wrong = true;
		//boolean appro_wrong = true;		
		while(io_wrong) {
			try {
				System.out.printf("�п�Jvalue : ");
				value = Lab.readKeyboardInt();
				io_wrong = false;
			} catch (IOException e) {
				System.out.println("IO Error");
				e.printStackTrace();
			}
		}
		
		
		try {
			System.out.println("2��10���� = " + Lab.exp(2, 10));
			System.out.printf("�Y��exp�ɡA����p��0 :");
			Lab.exp(value, -1);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		for(double i = 0; i <= 1.3; i += 0.4) {
			int times = 0;
			try {
				times = Lab.approach(i);
				System.out.println(i + "��" + times + "����̱���0.1");
				//appro_wrong = false;
			} catch(MyException e){}
		}
		
	}
}
