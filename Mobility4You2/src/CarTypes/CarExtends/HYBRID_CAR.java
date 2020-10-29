package CarTypes.CarExtends;

import VehicleTypes.OparateCar;

public class HYBRID_CAR extends GAS_CAR implements OparateCar{

	public float batteryCapacity;
	
	public HYBRID_CAR(String brand, String modelName, float engineDisplacement, float power, float batteryCapacity, float price) {
		super(brand, modelName, engineDisplacement, power, price);
		this.VehicleType = "Hybrid";
		this.batteryCapacity = batteryCapacity;
	}
	
	@Override
	public String StartTheEngine() {
		return this.brand + " engine start: kr kr vrummmmm";
	}
	
	@Override
	public String toString() {
		return brand + ", " + modelName + ", " + engineDisplacement + "L, " + power + "KW, "  + batteryCapacity + "KW/h, " + price + " euro";
	}

}
