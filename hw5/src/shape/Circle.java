package shape;

public class Circle implements Shape{
	
	double r;
	
	public Circle(double r) {
		this.r = r;
		System.out.println("�Ӷ�Ϊ��b�|�� : " + this.r);
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		double area;
		
		area = r * r * PI;
		
		return area;
	}

}
