package bank;

public class interestAccount extends Bank{

	public interestAccount(double saving) {
		super.saving = saving;
		System.out.println("interestAccount�s�J " + super.saving + " RMB");
	}
	
	@Override
	void count() {
		// TODO Auto-generated method stub
		super.saving += super.saving * super.interestRate;
	}

	@Override
	void show() {
		// TODO Auto-generated method stub
		System.out.println("interestAccount���s�ڬ� " + saving + " RMB");
	}

}
