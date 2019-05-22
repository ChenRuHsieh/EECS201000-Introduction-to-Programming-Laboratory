package numarraylist;

public class Test {
	public static void main(String[] args) {
		NumArrayList a = new NumArrayList();
		System.out.println("原先的 : ");
		a.show();
		int bound = 500;
		System.out.println("刪掉" + bound + "以下的數字");
		a.delete(bound);
		System.out.println("刪減後 : ");
		a.show();
	}
}
