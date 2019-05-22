package role;

public class Manager extends Employee{

	private int teamSize;
	private String position;
	public Manager(String name, int age, String sex, int salary, int teamSize, String position) {
		super(name, age, sex, salary);
		this.teamSize = teamSize;
		this.position = position;
	}
	
	public int GetTeamSize() {
		return teamSize;
	}
	
	public void SetTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	
	public String GetPosition() {
		return position;
	}
	
	public void SetPosition(String position) {
		this.position = position;
	}
	
	public void showManagerInfo() {
		super.showEmployeeInfo();
		System.out.println("	Teamsize : " + teamSize + " persons");
		System.out.println("	Position :" + position);
	}

}
