package savingsaccount;

public class SavingsAccount {
	
	static double annualInterestRate = 0;
	private double savingsBalance;
	
	public SavingsAccount(double money) {
		savingsBalance = money;
	}
	
	public void calculateMonthlyInterest() {
		System.out.println("今年利率 : " + annualInterestRate * 100 + "%");
		System.out.println("這個月利息 : " + savingsBalance*annualInterestRate/12);
		System.out.println("上個月餘額 : " + savingsBalance);
		savingsBalance += savingsBalance*annualInterestRate/12;
		System.out.println("這個月餘額 : " + savingsBalance);
		
	}
	
	public static void modifyInterestRate(double newRate) {
		annualInterestRate = newRate;
		System.out.println("年利率調為" + annualInterestRate * 100 + "%");
		
	}
	
	
	
}
