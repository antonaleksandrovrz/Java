import java.util.Comparator;

import VehicleTypes.Vehicle;

public class VehicleCompareByType  implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle o1,Vehicle o2) {
		return o2.VehicleType.compareToIgnoreCase(o1.VehicleType);
	}

}
