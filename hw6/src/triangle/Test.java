package triangle;

public class Test {
	public static void main(String[] args) {
		Triangle A = new Triangle(0, 6, 6);
		System.out.println("Triangle A Info : ");
		A.showInfo();
		System.out.println("Area : " + A.getArea());
		
		System.out.println();
		
		Triangle B = new Triangle(3, 4, 5);
		System.out.println("Triangle B Info : ");
		B.showInfo();
		System.out.println("Area : " + B.getArea());
		
		System.out.println();
		
		Triangle C = new Triangle(1, 2, 3);
		System.out.println("Triangle C Info : ");
		C.showInfo();
		System.out.println("Area : " + C.getArea());
	}
}
