package date;

public class Test {
	public static void main(String[] args){
		
		Date me = new Date("08", "31", "1998");
		Date sister = new Date("September", 3, 1998);
		Date father = new Date(1976, 2, 29);
		Date wrongDate1 = new Date(1900, 13, 1);
		Date wrongDate2 = new Date(1900, 6, 50);
		
		wrongDate1.print();
		wrongDate2.print();
		
		System.out.printf("我的生日是 ");
		me.print();
		
		System.out.printf("小美的生日是 ");
		sister.print();

		System.out.printf("老爸的生日是 ");
		father.print();
		
		
		
		int dis = me.dateDistance(sister);
		System.out.println("我的生日比小美晚" + dis + "天( - 代表早幾天)");
		
		dis = me.dateDistance(father);
		System.out.println("我的生日比老爸晚" + dis + "天( - 代表早幾天)");
	
	}
}
