package bank;

public class interestAccount extends Bank{

	public interestAccount(double saving) {
		super.saving = saving;
		System.out.println("interestAccount存入 " + super.saving + " RMB");
	}
	
	@Override
	void count() {
		// TODO Auto-generated method stub
		super.saving += super.saving * super.interestRate;
	}

	@Override
	void show() {
		// TODO Auto-generated method stub
		System.out.println("interestAccount的存款為 " + saving + " RMB");
	}

}
