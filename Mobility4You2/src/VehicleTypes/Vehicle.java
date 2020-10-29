package VehicleTypes;


public class Vehicle{
	
	private static final float kwToHp = 1.34102f;
	
	public String VehicleType;
	public String brand;
	public String modelName;
	public float power;
	public float price;
	
	public Vehicle(String brand,String modelName, float power, float price) {
		this.brand = brand;
		this.modelName = modelName;
		this.power = power;
		this.price = price;
	}
	
	public float CalculateHP() {
		return this.power * kwToHp;
	}
	
}
