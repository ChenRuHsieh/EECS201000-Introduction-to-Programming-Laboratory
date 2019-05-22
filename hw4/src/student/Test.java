package student;

public class Test {
	public static void main(String[] args) {
		Student student = new Student("Eva", 17, "SunHome");
		Undergraduate undergraduate = new Undergraduate("Peter", 20, "NTHU", "Computer Science");
		Graduate graduate = new Graduate("Joe", 24, "MIT", "Deep Learning");
		
		System.out.println("Student Info : ");
		student.show();
		
		System.out.println("Undergraduate Info : ");
		undergraduate.show();
		
		System.out.println("Graduate Info : ");
		graduate.show();
		
	}
}
