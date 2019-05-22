package role;

public class Role {
	
	private String name;
	private int age;
	private String sex;
	
	public Role(String name, int age, String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	public String GetName() {
		return name;
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	
	public int GetAge() {
		return age;
	}
	
	public void SetAge(int age) {
		this.age = age;
	}
	
	public String GetSex() {
		return sex;
	}
	
	public void SetSex(String sex) {
		this.sex = sex;
	}
	
	public void showInfo() {
		System.out.println("	Name : " + name);
		System.out.println("	Age : " + age + " years old");
		System.out.println("	Sex : " + sex);
	}
}

