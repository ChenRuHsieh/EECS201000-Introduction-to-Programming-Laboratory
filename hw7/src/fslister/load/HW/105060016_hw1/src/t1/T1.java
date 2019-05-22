package t1;

import java.util.Scanner;

public class T1 {
	public static void main(String[] args){
		int num;
		int i, j;
		System.out.print("Give a nuber:");
		Scanner console = new Scanner(System.in);
		num = console.nextInt();
		
		for(i = 1, j = 0; i < num; i++){
			//i is 
			if((num % i) == 0){
				j += i;
				//System.out.print(i);
			}
		}
		
		if(j == num)
			System.out.print("Yes");
		else
			System.out.print("No");
	}
}
