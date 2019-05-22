package student;

public class Undergraduate extends Student{
	
	private String specialty;
	
	public Undergraduate(String name, int age, String degree, String specialty) {
		super(name, age, degree);
		this.specialty = specialty;
	}
	
	public void show() {
		super.show();
		//System.out.println("Undergraduate Info: ");
		System.out.println("	Specialty : " + specialty);
	}
	
	
	
}
