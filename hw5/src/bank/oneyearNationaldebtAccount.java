package bank;

public class oneyearNationaldebtAccount extends Bank{

	public oneyearNationaldebtAccount(double saving) {
		super.saving = saving;
		System.out.println("oneyearNationaldebtAccount�s�J " + super.saving + " RMB");
	}
	@Override
	void count() {
		// TODO Auto-generated method stub
		super.saving += super.saving * super.oneyearNationaldebt;
	}

	@Override
	void show() {
		// TODO Auto-generated method stub
		System.out.println("oneyearNationaldebtAccount���s�ڬ� " + super.saving + " RMB");
	}

}
