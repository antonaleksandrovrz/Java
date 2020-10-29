package CarTypes.CarExtends;

import VehicleTypes.OparateCar;
import VehicleTypes.Vehicle;

public class ELECTRIC_CAR extends Vehicle implements OparateCar {
	
	
	public float batteryCapacity;

	public ELECTRIC_CAR(String brand, String modelName, float power, float batteryCapacity, float price) {
		super(brand, modelName, power, price);
		this.VehicleType = "Electric";
		this.batteryCapacity = batteryCapacity;
	}

	@Override
	public String StartTheEngine() {
		return this.brand + " engine start: Bzzzzzzzzz";
	}
	
	@Override
	public String toString() {
		return brand + ", " + modelName + ", " + power + "KW, " + batteryCapacity + "KW/h, " + price + " euro";
	}


}
