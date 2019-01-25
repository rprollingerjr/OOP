// Raymond Rollinger, IC17, CIS 340, 430pm
import java.util.Scanner;

public class CalorieCalculator {
	
	
	static final double CALORIE_COEFFICIENT = 0.167;
	static final double POUNDKG_COEFFICIENT = 0.453592;
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		double weight;
		int minutes;
		int seconds;
		double totalTime;
		double kilos;
		double caloriesKilled;
		
		displayHeader();
		
		weight = readInteger("Enter runner weight (lbs): ");
		minutes = readInteger("Enter minutes run: ");
		seconds = readInteger("Enter seconds run: ");
		
		totalTime = minutes + (seconds * (1 / 60.0));
		
		kilos = poundsToKilos(weight);
		
		caloriesKilled = caloriesSpentRunning(kilos, totalTime);
		
		System.out.printf("\nIf you run %d minutes and %d seconds at 6mph,\nthe calories burned are approximately %.2f", minutes, seconds, caloriesKilled);
		
		
	}
	
	
	private static void displayHeader() {
		System.out.println("\t\tRunning Calorie Calculator\n\nThis application can calculate calories based on running mileage.\n");
	}

	
	
	
	private static double caloriesSpentRunning(double kg, double minutes) {
		double calories = 0.0;
		
		calories = kg * minutes * CALORIE_COEFFICIENT;
		
		return calories;
	}
	
	
	private static double poundsToKilos(double lbs) {
		
		double kilos = 0.0;
		
		kilos = lbs * POUNDKG_COEFFICIENT;
		
		return kilos;
	}
	
	
	public static int readInteger(String displayString) {
		
		int numberOfErrors = 0;
		int number = 0;
		boolean repeatInput = false;
		
		do {
			
			try {
				System.out.printf("%s", displayString);
				number = Integer.parseInt(sc.nextLine());
					
			}
			catch(NumberFormatException e){
				
				if (numberOfErrors == 2) {
					System.out.print("\nYou are having problems entering an integer value. Press any key to exit.");
					sc.nextLine();
					System.exit(0);
				}
				
				System.out.println("\nInput must be a valid integer!\n");
				repeatInput = true;
				
				
				numberOfErrors++;
			}
			
		}while (repeatInput == true);
		
		return number;
		
	}
	
	
}
