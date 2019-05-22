package savingsaccount;

public class Test {
	public static void main(String[] args) {
		
		System.out.println("");
		SavingsAccount.modifyInterestRate(0.04);
		System.out.println("");
		
		SavingsAccount server1 = new SavingsAccount(2000);
		SavingsAccount server2 = new SavingsAccount(3000);
		
		System.out.println("Server1 :");
		server1.calculateMonthlyInterest();
		System.out.println("Server2 :");
		server2.calculateMonthlyInterest();
		
		System.out.println("");
		SavingsAccount.modifyInterestRate(0.05);
		System.out.println("");
		
		System.out.println("Server1 :");
		server1.calculateMonthlyInterest();
		System.out.println("Server2 :");
		server2.calculateMonthlyInterest();
		
	}
}
