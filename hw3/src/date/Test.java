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
		
		System.out.printf("�ڪ��ͤ�O ");
		me.print();
		
		System.out.printf("�p�����ͤ�O ");
		sister.print();

		System.out.printf("�Ѫ����ͤ�O ");
		father.print();
		
		
		
		int dis = me.dateDistance(sister);
		System.out.println("�ڪ��ͤ��p����" + dis + "��( - �N���X��)");
		
		dis = me.dateDistance(father);
		System.out.println("�ڪ��ͤ��Ѫ���" + dis + "��( - �N���X��)");
	
	}
}
