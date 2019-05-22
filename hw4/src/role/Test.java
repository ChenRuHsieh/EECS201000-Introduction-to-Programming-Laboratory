package role;

public class Test {
	public static void main(String[] args) {
		Role role = new Role("Joe", 30, "Man");
		Employee worker = new Employee("Mark", 25, "Man", 4000);
		Manager ceo = new Manager("Mary", 50, "Woman", 50000000, 200, "CEO");
		
		System.out.println("What is role's name ? ");
		System.out.println(role.GetName());
		System.out.println("Role Info : ");
		role.showInfo();
		
		System.out.println("");
		
		System.out.println("How much this worker' salary ?");
		System.out.println(worker.GetSalary());
		System.out.println("The worker' salary up to 5000 RMB");
		worker.SetSalary(5000);
		System.out.println("Worker Info : ");
		worker.showEmployeeInfo();
		
		System.out.println("");
		
		System.out.println("How many persons this ceo have ?");
		System.out.println(ceo.GetTeamSize());
		System.out.println("The teamsize down to 100");
		ceo.SetTeamSize(100);
		System.out.println("CEO Info : ");
		ceo.showManagerInfo();
		
		
		
	}
}
