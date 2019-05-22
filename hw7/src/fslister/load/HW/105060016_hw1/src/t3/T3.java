package t3;

import java.util.Scanner;

public class T3 {
	public static void main(String[] args){
		//int[] num = new int[3];
		int i, j, k;
		int x, y, z;
		int result = 0;
		
		System.out.print("Give  nubers:");
		Scanner console = new Scanner(System.in);
		x = console.nextInt();
		y = console.nextInt();
		z = console.nextInt();
		
		if(z == 1)
			result = x + y;
		else if(z == 2)
			result = x - y;
		else if(z == 3)
			result = x * y;
		else if(z == 4)
			result = x / y;
		else if(z == 5)
			result = x % y;
		else if(z == 6)
			result = gcd(x, y);
		else if(z == 7)
			result = lcm(x, y);
		
		System.out.println(result);
		
	}
	
	public static int gcd(int x, int y){
		int gcd = 1;
		int i;
		int small;
		
		if(x >= y)
			small = y;
		else
			small = x;
		
		for(i = 2; i <= small; i++){
			while( ((x%i) == 0) && ((y%i) == 0)){
				gcd *= i;
				x /= i;
				y /= i;
				//System.out.println("i = " + i + " gcd = " + gcd);
			}
		}
		
		if(x == 0 || y == 0) {
			return 0;
		}
		
		return gcd;
	}
	
	public static int lcm(int x, int y){
		int lcm = 1;
		int i;
		int small;
		if(x == 0 || y == 0) {
			lcm = 0;
		}
		else{
			lcm = (x * y) / gcd(x, y);
		}
		/*
		if(x >= y)
			small = y;
		else
			small = x;
		
		for(i = 2; i <= small; i++){
			//System.out.println("i = " + i );
			while( ((x%i) == 0) && ((y%i) == 0)){
				lcm *= i;
				x /= i;
				y /= i;
				//System.out.println("i = " + i + " mmb = " + mmb);
			}
		}
		
		return lcm * x * y;
		*/
		
		
		return lcm;
	}
}
