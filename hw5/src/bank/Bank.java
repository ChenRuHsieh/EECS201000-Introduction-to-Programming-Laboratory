package bank;

abstract class Bank {
	
	public static double oneyearRate = 0.0178;
	public static double oneyearNationaldebt = 0.0198;
	public static double interestRate = 0.0078;
	public double saving;
	
	abstract void count();
	abstract void show();
}
