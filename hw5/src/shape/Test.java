package shape;

public class Test {
	public static void main(String[] args) {
		
		Circle c = new Circle(5);
		double c_area = c.getArea();
		System.out.println("�Ӷꪺ���n�� : " + c_area);
		
		System.out.println();
		
		Square s = new Square(5);
		double s_area = s.getArea();
		System.out.println("�ӥ���Ϊ����n�� : " + s_area);
		
	}
}
