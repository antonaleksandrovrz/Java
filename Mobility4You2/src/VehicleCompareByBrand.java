import java.util.Comparator;

import VehicleTypes.Vehicle;

public class VehicleCompareByBrand implements Comparator<Vehicle>{

	@Override
	public int compare(Vehicle o1,Vehicle o2) {
		return o1.brand.compareToIgnoreCase(o2.brand);
	}
}
