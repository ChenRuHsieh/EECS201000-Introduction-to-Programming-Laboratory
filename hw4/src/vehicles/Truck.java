package vehicles;

public class Truck extends Vehicles{

	private float load;
	
	public Truck(String brand, String color, float load) {
		super(brand, color);
		this.load = load;
	}
	
	public void showTruck() {
		super.showInfo();
		System.out.println("	Load : " + load);
	}

}
