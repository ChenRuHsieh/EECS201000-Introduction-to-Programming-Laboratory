package t2;

import java.util.Scanner;

public class T2 {
	public static void main(String[] args){
		int num;
		int[] time = new int[3];
		
		
		System.out.print("Give a nuber:");
		Scanner console = new Scanner(System.in);
		num = console.nextInt();
		
		if(num >= 3600){
			time[2] = num / 3600;
			num = num - 3600*time[2];
			//System.out.println(hr);
		}
		if(num >= 60){
			time[1] = num / 60;
			num = num - 60*time[1];
			//System.out.println(min);
		}
		if(num >= 0){
			time[0] = num;
			//System.out.println(sec);
		}
		
		System.out.print(time[2] + ":" + time[1] + ":" + time[0]);
	}
}
