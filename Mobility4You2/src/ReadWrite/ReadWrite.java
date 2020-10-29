package ReadWrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import CarTypes.CarExtends.ELECTRIC_CAR;
import CarTypes.CarExtends.GAS_CAR;
import CarTypes.CarExtends.HYBRID_CAR;
import VehicleTypes.Vehicle;

public class ReadWrite {
	
	public static ArrayList<Vehicle> carsObjects;
	
	public static void AddVehicleToList(Vehicle vehicle) {
		carsObjects.add(vehicle);
	}
	
	public static ArrayList<String> GetCarsData() {
 	try {
 		ArrayList<String> cars = new ArrayList<String>();
 		
 		
	      File myObj = new File("C:\\Users\\Nadya\\Desktop\\mobility.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        cars.add(data);
	      }
	      myReader.close();
	      
	      return cars;
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	      return null;
	    }
	}
	
	public static ArrayList<Vehicle> GetCarsCatalogue(){
		carsObjects = new ArrayList<Vehicle>();
		
		for (String car : GetCarsData()) {
			String[] str = car.split(",");
			
			if(str.length== 5){
				if(str[2].substring(str[2].length() - 2).equals("KW")) {
					ELECTRIC_CAR elcar = new ELECTRIC_CAR(str[0], str[1],  
															Float.parseFloat(str[2].substring(0,str[2].length() - 2)), 
																Float.parseFloat(str[3].substring(0,str[3].length() - 4)), 
																	Float.parseFloat(str[4].substring(0,str[4].length() - 5)));
					
					carsObjects.add(elcar);
				}
				
				else {
					GAS_CAR gascar = new GAS_CAR(str[0], str[1],  
							Float.parseFloat(str[2].substring(0,str[2].length() - 1)), 
								Float.parseFloat(str[2].substring(0,str[3].length() - 2)), 
									Float.parseFloat(str[4].substring(0,str[4].length() - 5)));

					carsObjects.add(gascar);
				}
			}
			
			else {
				HYBRID_CAR gascar = new HYBRID_CAR(str[0], str[1],  
						Float.parseFloat(str[2].substring(0,str[2].length() - 1)), 
							Float.parseFloat(str[3].substring(0,str[3].length() - 2)),
								Float.parseFloat(str[4].substring(0,str[4].length() - 4)),
									Float.parseFloat(str[5].substring(0,str[5].length() - 5)));

				carsObjects.add(gascar);
			}
		}
		
		return carsObjects;
	}
	
	public static void AddCars(ArrayList<Vehicle> cars) {
		try {
			File file = new File("C:\\Users\\Nadya\\Desktop\\mobility.txt");

	        if (!file.exists()) {
	            file.createNewFile();
	        }
			
		      FileWriter myWriter = new FileWriter(file.getAbsoluteFile(),true);
		      for (Vehicle car : cars) {
		    	  myWriter.write(car + System.lineSeparator());
		      }
		      myWriter.close();
		      System.out.println("The cars was successfully added.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}
