package student;

public class Graduate extends Student{
	
	private String direction;
	
	public Graduate(String name, int age, String degree, String direction) {
		super(name, age, degree);
		this.direction = direction;
	}
	
	public void show() {
		super.show();
		System.out.println("	Direction : " + direction);
	}

}
