package shape;

public class Square implements Shape{

	double a;
	
	public Square(double edge) {
		this.a = edge;
		System.out.println("該正方形的邊長為 : " + this.a);
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return a * a;
	}

}
