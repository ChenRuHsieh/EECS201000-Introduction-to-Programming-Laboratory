package t4;

import java.util.Scanner;

public class T4 {
	public static void main(String[] args){
		//int[] num = new int[3];
		int i, j, n;
		double num_dec = 0;
		String[] str_in = new String[20];
		String[] str_oct = new String[20]; 
		Scanner times = new Scanner(System.in);
		n = times.nextInt();
		
		for(i = 0; i < n; i++){
			Scanner console = new Scanner(System.in);
			str_in[i] = console.next();
			//System.out.println(str_in[i]);
			num_dec = 0;
			char[] num = str_in[i].toCharArray();
			String str_two = new String();
			/*
			num_dec = num[0] * 10;
			System.out.print(num_dec);
			*/
			for(j = 0; j < num.length; j++){ 
				if(num[j] == '0') {
					num_dec += 0 * Math.pow(16, num.length - j - 1) ;
					str_two = str_two + "0000";
				}
				else if(num[j] == '1') {
					num_dec += 1 * Math.pow(16, num.length - j - 1) ;
					str_two = str_two + "0001";
				}
				else if(num[j] == '2') {
					num_dec += 2 * Math.pow(16, num.length - j - 1) ;
					str_two = str_two + "0010";
				}
				else if(num[j] == '3') {
					num_dec += 3 * Math.pow(16, num.length - j - 1) ;
					str_two = str_two + "0011";
				}
				else if(num[j] == '4') {
					num_dec += 4 * Math.pow(16, num.length - j - 1) ;
					str_two = str_two + "0100";
				}
				else if(num[j] == '5') {
					num_dec += 5 * Math.pow(16, num.length - j - 1) ;
					str_two = str_two + "0101";
				}
				else if(num[j] == '6') {
					num_dec += 6 * Math.pow(16, num.length - j - 1) ;
					str_two = str_two + "0110";
				}
				else if(num[j] == '7') {
					num_dec += 7 * Math.pow(16, num.length - j - 1) ;
					str_two = str_two + "0111";
				}
				else if(num[j] == '8') {
					num_dec += 8 * Math.pow(16, num.length - j - 1) ;
					str_two = str_two + "1000";
				}
				else if(num[j] == '9') {
					num_dec += 9 * Math.pow(16, num.length - j - 1) ;
					str_two = str_two + "1001";
				}
				else if(num[j] == 'A') {
					num_dec += 10 * Math.pow(16, num.length - j - 1) ;
					str_two = str_two + "1010";
				}
				else if(num[j] == 'B') {
					num_dec += 11 * Math.pow(16, num.length - j - 1) ;
					str_two = str_two + "1011";
				}
				else if(num[j] == 'C') {
					num_dec += 12 * Math.pow(16, num.length - j - 1) ;
					str_two = str_two + "1100";
				}
				else if(num[j] == 'D') {
					num_dec += 13 * Math.pow(16, num.length - j - 1) ;
					str_two = str_two + "1101";
				}
				else if(num[j] == 'E') {
					num_dec += 14 * Math.pow(16, num.length - j - 1) ;
					str_two = str_two + "1110";
				}
				else if(num[j] == 'F') {
					num_dec += 15 * Math.pow(16, num.length - j - 1) ;
					str_two = str_two + "1111";
				}
				//System.out.println(num_dec);
			}
			
			//System.out.println("str_two = " + str_two);
			
			
			if(str_two.length()%3 == 1) {
				str_two = "00" + str_two;
			}
			else if(str_two.length()%3 ==2) {
				str_two = "0" + str_two;
			}
			
			//System.out.println("str_two = " + str_two);
			
			//2Тр8
			for(j = 0; j <= str_two.length()-3; j+=3) {
				
				String tmp = str_two.substring(j, j+3);
				
				if(tmp.equals("000")) {
					if(j==0)
						str_oct[i] = "";
					else
						str_oct[i] += "0";
				}
				else if(tmp.equals("001")) {
					if(j==0)
						str_oct[i] = "1";
					else
						str_oct[i] += "1";
				}
				else if(tmp.equals("010")) {
					if(j==0)
						str_oct[i] = "2";
					else
						str_oct[i] += "2";
				}
				else if(tmp.equals("011")) {
					if(j==0)
						str_oct[i] = "3";
					else
						str_oct[i] += "3";
				}
				else if(tmp.equals("100")) {
					if(j==0)
						str_oct[i] = "4";
					else
						str_oct[i] += "4";
				}
				else if(tmp.equals("101")) {
					if(j==0)
						str_oct[i] = "5";
					else
						str_oct[i] += "5";
				}
				else if(tmp.equals("110")) {
					if(j==0)
						str_oct[i] = "6";
					else
						str_oct[i] += "6";
				}
				else if(tmp.equals("111")) {
					if(j==0)
						str_oct[i] = "7";
					else
						str_oct[i] += "7";
				}
			}
			
			//System.out.println(DecToOctal((int)num_dec));
		}
		
		
		
		for(i = 0; i < n; i++)
			System.out.println(str_oct[i]);
		
	}
	

	public static String DecToOctal(int dec) {
		
		String str_octal = new String();
		
		//int max = dec / 8;
		int i, j, tmp;
		
		while(dec != 0) {
			tmp = dec % 8;
			str_octal = tmp + str_octal;
			dec -= tmp;
			dec /= 8;
		}
		
		return str_octal;
		
	}
}
