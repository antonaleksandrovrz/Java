package CarTypes.CarExtends;

import VehicleTypes.OparateCar;
import VehicleTypes.Vehicle;

public class GAS_CAR extends Vehicle implements OparateCar {
	
	//The engine displacement
	
	public float engineDisplacement;

	public GAS_CAR(String brand, String modelName, float engineDisplacement , float power, float price) {
		super(brand, modelName, power, price);
		this.VehicleType = "Gas";
		this.engineDisplacement = engineDisplacement;
	}

	@Override
	public String StartTheEngine() {
		return this.brand + " engine start: kr kr kr VRUUUmm";
	}
	
	@Override
	public String toString() {
		return brand + ", " + modelName + ", " + engineDisplacement + "L, " + power + "KW, " + price + " euro";
	}

}
