package bank;

public class oneyearNationaldebtAccount extends Bank{

	public oneyearNationaldebtAccount(double saving) {
		super.saving = saving;
		System.out.println("oneyearNationaldebtAccount存入 " + super.saving + " RMB");
	}
	@Override
	void count() {
		// TODO Auto-generated method stub
		super.saving += super.saving * super.oneyearNationaldebt;
	}

	@Override
	void show() {
		// TODO Auto-generated method stub
		System.out.println("oneyearNationaldebtAccount的存款為 " + super.saving + " RMB");
	}

}
