package savingsaccount;

public class SavingsAccount {
	
	static double annualInterestRate = 0;
	private double savingsBalance;
	
	public SavingsAccount(double money) {
		savingsBalance = money;
	}
	
	public void calculateMonthlyInterest() {
		System.out.println("���~�Q�v : " + annualInterestRate * 100 + "%");
		System.out.println("�o�Ӥ�Q�� : " + savingsBalance*annualInterestRate/12);
		System.out.println("�W�Ӥ�l�B : " + savingsBalance);
		savingsBalance += savingsBalance*annualInterestRate/12;
		System.out.println("�o�Ӥ�l�B : " + savingsBalance);
		
	}
	
	public static void modifyInterestRate(double newRate) {
		annualInterestRate = newRate;
		System.out.println("�~�Q�v�լ�" + annualInterestRate * 100 + "%");
		
	}
	
	
	
}
