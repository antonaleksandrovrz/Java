import java.util.ArrayList;
import java.util.Scanner;

import CarTypes.CarExtends.ELECTRIC_CAR;
import CarTypes.CarExtends.GAS_CAR;
import CarTypes.CarExtends.HYBRID_CAR;
import ReadWrite.ReadWrite;
import VehicleTypes.Vehicle;

public class Menu {

	public static void ShowMenu() {
		System.out.println("1 - Show the entire Mobility4You catalogue\r\n"
				+ "2 – Add a new electric car\r\n"
				+ "3 – Add a new gas-powered car\r\n"
				+ "4 – Add a new hybrid car\r\n"
				+ "5 - Show the entire Mobility4You catalogue sorted by car-type\r\n"
				+ "6 – Show the entire Mobility4You catalogue sorted by brand\r\n"
				+ "(alphabetically)\r\n"
				+ "7 – Write to file\r\n"
				+ "8 – Stop the program");
	}
	
	public static void ReadCommand() {
		Scanner in = new Scanner(System.in); 
		String command;
		
		do {
		command = in.nextLine();
		}while(!isInteger(command));
		
		
		switch (Integer.parseInt(command)) {
		case 1: {
			
			for (String car : ReadWrite.GetCarsData()) {
				System.out.println(car);
			}
			
			break;
		}
		
		case 2: {
			System.out.println("Adding electric car...");
			in = new Scanner(System.in); 
			
			String brand,model,power,btCapacity,price;
			
			
			System.out.print("Brand:");
			brand = in.nextLine();
			
			System.out.print("Model:");
			model = in.nextLine();
			
			do {
			System.out.print("Power (KW):");
			power = in.nextLine();
			}while(!isNumber(power));
			
			do {
			System.out.print("Battery capacity (KW/h):");
			btCapacity = in.nextLine();
			}while(!isNumber(btCapacity));
			
			do {
			System.out.print("Price (euro):");
			price = in.nextLine();
			}while(!isNumber(price));
			
			
			try {
				ELECTRIC_CAR elcar = new ELECTRIC_CAR(brand,model,Float.parseFloat(power),Float.parseFloat(btCapacity),Float.parseFloat(price));
				ReadWrite.AddVehicleToList(elcar);
				
			} catch (Exception e) {
				System.out.println("Incorrect format!");
				ShowMenu();
				ReadCommand();
				break;
			}
			
			break;
		}
		
		case 3: {
			System.out.println("Adding gas car...");
			in = new Scanner(System.in); 
			
			String brand,model,engineDispl,power,price;
			
			
			System.out.print("Brand:");
			brand = in.nextLine();
			
			System.out.print("Model:");
			model = in.nextLine();
			
			do {
			System.out.print("Engine displacement (L):");
			engineDispl = in.nextLine();
			}while(!isNumber(engineDispl));
			
			do {
			System.out.print("Power (KW):");
			power = in.nextLine();
			}while(!isNumber(power));
			
			do {
			System.out.print("Price (euro):");
			price = in.nextLine();
			}while(!isNumber(price));
			

			
			try {
				GAS_CAR gasCar = new GAS_CAR(brand,model,Float.parseFloat(engineDispl),Float.parseFloat(power),Float.parseFloat(price));
				ReadWrite.carsObjects.add(gasCar);
			} catch (Exception e) {
				System.out.println("Incorrect format!");
				ShowMenu();
				ReadCommand();
				break;
			}
			
			break;
		}
		
		case 4: {
			
			System.out.println("Adding hybrid car...");
			in = new Scanner(System.in); 
			
			String brand,model,engineDispl,power,btCapacity,price;
			
			
			System.out.print("Brand:");
			brand = in.nextLine();
			
			System.out.print("Model:");
			model = in.nextLine();
			
			do {
			System.out.print("Engine displacement (L):");
			engineDispl = in.nextLine();
			}while(!isNumber(engineDispl));
			
			do {
			System.out.print("Power(KW):");
			power = in.nextLine();
			}while(!isNumber(power));
			
			do {
				System.out.print("Battery capacity (KW/h):");
				btCapacity = in.nextLine();
				}while(!isNumber(btCapacity));
			
			do {
			System.out.print("Price (euro):");
			price = in.nextLine();
			}while(!isNumber(price));
			

			
			try {
				HYBRID_CAR hybridCar = new HYBRID_CAR(brand,model,Float.parseFloat(engineDispl),Float.parseFloat(power),Float.parseFloat(btCapacity),Float.parseFloat(price));
				ReadWrite.carsObjects.add(hybridCar);
			} catch (Exception e) {
				System.out.println("Incorrect format!");
				ShowMenu();
				ReadCommand();
				break;
			}
			
			break;
		}
		
		//Show the entire Mobility4You catalogue sorted by car-type
		case 5: {
			ReadWrite.GetCarsCatalogue();
			ArrayList<Vehicle> cars = ReadWrite.carsObjects;
			cars.sort(new VehicleCompareByType());
			
			for (Vehicle vehicle : cars) {
				System.out.println(vehicle);
			}
			break;
		}
		
		//Show the entire Mobility4You catalogue sorted by brand (alphabetically)
		case 6: {
			ReadWrite.GetCarsCatalogue();
			ArrayList<Vehicle> cars = ReadWrite.carsObjects;
			cars.sort(new VehicleCompareByBrand());
			
			for (Vehicle vehicle : cars) {
				System.out.println(vehicle);
			}
			break;
		}
		
		//Write to file
		case 7: {
			ReadWrite.GetCarsCatalogue();
			ArrayList<Vehicle> cars = ReadWrite.carsObjects;
			ReadWrite.AddCars(cars);
			break;
		}
		
		//8 – Stop the program
		case 8: {
			System.exit(1);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + command);
		}
		
	}
	
	private static boolean isNumber(String information) {
		try {  
	         Float.parseFloat(information);  
	         return true;  
	      } catch (NumberFormatException e) {  
	    	 System.out.println("Input was not in a correct format!");
	         return false;  
	      }  
	}
	
	private static boolean isInteger(String information) {
		try {  
	         Integer.parseInt(information);  
	         return true;  
	      } catch (NumberFormatException e) {  
	    	 System.out.println("Input was not in a correct format!");
	         return false;  
	      }  
	}
}
