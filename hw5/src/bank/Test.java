package bank;

public class Test {
	public static void main(String[] args) {
		
		oneyearRateAccount Account1 = new oneyearRateAccount(1000);
		Account1.count();
		Account1.show();
		
		System.out.println("");
		
		oneyearNationaldebtAccount Account2 = new oneyearNationaldebtAccount(1000);
		Account2.count();
		Account2.show();
		
		System.out.println("");
		
		interestAccount Account3 = new interestAccount(1000);
		Account3.count();
		Account3.show();
		
		
	}
}
