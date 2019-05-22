package vehicles;

public class Test {
	public static void main(String[] args) {
		
		Vehicles bike = new Vehicles("Giant", "Yellow");
		Car car = new Car("BMW", "Black", 4);
		Truck truck = new Truck("BlackCat", "Green", 3); 
		
		System.out.println("Bike Info");
		bike.showInfo();
		System.out.println("Bike 準備開動");
		bike.run();
		
		System.out.println("Car Info");
		car.showCar();
		
		System.out.println("Truck Info");
		truck.showTruck();
	}
}
