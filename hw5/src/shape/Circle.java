package shape;

public class Circle implements Shape{
	
	double r;
	
	public Circle(double r) {
		this.r = r;
		System.out.println("該圓形的半徑為 : " + this.r);
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		double area;
		
		area = r * r * PI;
		
		return area;
	}

}
