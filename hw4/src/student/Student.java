package student;

public class Student {
	private String name;
	private int age;
	private String degree;
	
	public Student(String name, int age, String degree) {
		this.name = name;
		this.age = age;
		this.degree = degree;
	}
	
	public void show() {
		//System.out.println("Student Info: ");
		System.out.println("	Name : " + name);
		System.out.println("	Age : " + age);
		System.out.println("	Degree : " + degree);
	}
	
}