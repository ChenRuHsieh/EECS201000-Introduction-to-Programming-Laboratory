package bank;

public class oneyearRateAccount extends Bank{
	
	public oneyearRateAccount(double saving) {
		super.saving = saving;
		System.out.println("oneyearRateAccounth存入 " + super.saving + " RMB");
	}
	
	@Override
	void count() {
		// TODO Auto-generated method stub
		super.saving += super.saving * super.oneyearRate;
	}

	@Override
	void show() {
		// TODO Auto-generated method stub
		System.out.println("oneyearRateAccounth的存款為 " + super.saving + " RMB");
	}

}
