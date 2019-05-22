package role;

public class Employee extends Role{
	
	private int salary;
	
	public Employee(String name, int age, String sex, int salary) {
		super(name, age, sex);
		this.salary = salary;
	}
	
	public int GetSalary() {
		return salary;
	}
	
	public void SetSalary(int salary) {
		this.salary = salary;
	}
	
	public void showEmployeeInfo () {
		super.showInfo();
		System.out.println("	Salary : " + salary + " RMB");
	}
	

}
