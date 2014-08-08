package code.designpatterns;

interface Vehicle {
	public void drive();

	public void clean();
}

class Car implements Vehicle {
	@Override
	public void drive() {
		System.out.println("Driving a car...");
	}

	@Override
	public void clean() {
		System.out.println("Cleaning a car...");
	}
}

class Bus implements Vehicle {
	@Override
	public void drive() {
		System.out.println("Driving a Bus...");
	}

	@Override
	public void clean() {
		System.out.println("Cleaning a Bus...");
	}
}

abstract class VehicleDriver {
	public abstract Vehicle getVehicle();

	public void driveVehicle() {
		getVehicle().drive();
	}

	public void cleanVehicle() {
		getVehicle().clean();
	}
}

class CarDriver extends VehicleDriver {
	@Override
	public Vehicle getVehicle() {
		return new Car();
	}
}

class BusDriver extends VehicleDriver {
	@Override
	public Vehicle getVehicle() {
		return new Bus();
	}
}

public class FactoryMethodPattern {
	public static void main(String[] args) {

		handleVehicle(new CarDriver());
		handleVehicle(new BusDriver());
	}

	static void handleVehicle(VehicleDriver vDriver) {
		System.out.println("Handling a new vehicle. Pre lambda way");
		vDriver.driveVehicle();
		vDriver.cleanVehicle();
	}
}