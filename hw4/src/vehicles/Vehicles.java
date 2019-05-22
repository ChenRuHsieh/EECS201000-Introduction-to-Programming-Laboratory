package vehicles;

public class Vehicles {
	
	private String brand;
	private String color;
	
	public Vehicles(String brand, String color) {
		this.brand = brand;
		this.color = color;
	}
	
	public void run() {
		System.out.println("我已經開動了");
	}
	
	public void showInfo() {
		//System.out.println("Vehicles Info : ");
		System.out.println("	Brand : " + brand);
		System.out.println("	Color : " + color);
	}
}
