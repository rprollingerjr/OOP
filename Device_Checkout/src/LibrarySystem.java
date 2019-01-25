//Raymond Rollinger, MP2, CIS 340, 430pm
import java.util.Scanner;
import java.util.ArrayList;

public class LibrarySystem {

	Scanner sc = new Scanner(System.in);
	ArrayList<Device> deviceList = new ArrayList<Device>();
	
	private String keyword = "";
	
	public static void main(String[] args) {
		
		LibrarySystem deviceSystem;
		deviceSystem = new LibrarySystem();
		
		deviceSystem.displayHeader();
		// hard-coded devices. this line below
		// establishes those devices within array list
		deviceSystem.configure5Devices();
		deviceSystem.displayMenu();
		

	} // end main method
	
	
	
	public void addDevice() {
		
		Device tempDevice;
		tempDevice = new Device();
		
		System.out.println("\nEntering new device...\n");
		
			System.out.print("SKU: ");
			tempDevice.setSkuCode(sc.nextLine());
			
			System.out.print("Name: ");
			tempDevice.setTitle(sc.nextLine());
			
			tempDevice.setIdNumber(deviceList.size() + 1);
			
			tempDevice.setAvailability(true);
			
			System.out.printf("\nAdded %s to Catalog.\n\n", tempDevice.getTitle());
			
			deviceList.add(tempDevice);
			
			if (deviceList.size() >= 10) {
				displayMenu();
			}
			else if (deviceList.size() < 10) {
			addAnotherDevice();
			}
	}
	
	
	public void addAnotherDevice() {
		
		String decision = "";
		
		System.out.print("Enter another device? (Y/N): ");
		decision = sc.nextLine();

		if (decision.equalsIgnoreCase("Y")) {
			addDevice();
		}
		
	}
	
	
	public void availableDevices() {
		
		String title = "Title";
		String skuCode = "SKU";
		String idNumber = "#";
		
		System.out.println("\nAvailable Devices");
		System.out.printf("\n%-5s%-18s%-32s\n", idNumber, skuCode, title);
		for (Device d : deviceList) {
			if (d.getAvailability() == true) {
				System.out.printf("%-5d%-18s%-32s", d.getIdNumber(), d.getSkuCode(), d.getTitle());
				System.out.println();
				
			}
			
		}
		
	}
	
	
	
	
	public void configure5Devices() {
		
		Device device1 = new Device();
		Device device2 = new Device();
		Device device3 = new Device();
		Device device4 = new Device();
		Device device5 = new Device();
		
		device1.setTitle("Apple iPad Mini 4");
		device2.setTitle("Amazon Kindle Fire HD 8");
		device3.setTitle("RCA Voyager 7\" 16 GB Tablet");
		device4.setTitle("Microsoft Surface Pro 6");
		device5.setTitle("Samsung Galaxy Tab S4");
		
		device1.setSkuCode("46796007");
		device2.setSkuCode("5822969");
		device3.setSkuCode("53990888");
		device4.setSkuCode("6298137");
		device5.setSkuCode("317311");
		
		device1.setIdNumber(1);
		device2.setIdNumber(2);
		device3.setIdNumber(3);
		device4.setIdNumber(4);
		device5.setIdNumber(5);
		
		device1.setAvailability(true);
		device2.setAvailability(true);
		device3.setAvailability(true);
		device4.setAvailability(true);
		device5.setAvailability(true);
		
		
		deviceList.add(device1);
		deviceList.add(device2);
		deviceList.add(device3);
		deviceList.add(device4);
		deviceList.add(device5);
		
		
	}
	
	
	public void displayDevices() {
		
		String title = "Title";
		String skuCode = "SKU";
		String idNumber = "#";
		
		System.out.printf("\n%-5s%-18s%-32s\n", idNumber, skuCode, title);
		for (Device d : deviceList) {
			System.out.printf("%-5d%-18s%-36s%-24s", d.getIdNumber(), d.getSkuCode(), d.getTitle(), d.availabilityValue());
			System.out.println();
		}
		
	}
	
	
	public void displayHeader() {
		System.out.println("\t\tLibrary Device Checkout System");
	}
	
	
	
	public void displayMenu() {
		
		int menuChoice = 0;
		int numberOfErrors = 0;
		boolean repeatInput = false;
	do {	
		do {
			try {
			System.out.println("\n\n\tProgram Menu\n");
			System.out.print("1. List Devices by Title\n"
					+ "2. Add New Devices\n"
					+ "3. Edit Device Information\n"
					+ "4. Search by Device Name\n"
					+ "5. Check Out Devices\n"
					+ "6. Check In Devices\n"
					+ "7. Exit\n\n"
					+ "Select menu options 1-7: ");
			menuChoice = Integer.parseInt(sc.nextLine());
			
			switch (menuChoice) {
			
			case 1:
				displayDevices();
				break;
			case 2:
				if (deviceList.size() >= 10) {
					System.out.println("Max number of devices in system.");
				}
				else {
				addDevice();
				}
				break;
			case 3:
				editInfo();
				break;
			case 4:
				searchDevice();
				break;
			case 5:
				checkOut();
				break;
			case 6:
				checkIn();
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.out.print("Number is not a menu option. Press Enter to continue.");
				sc.nextLine();
				break;
				}
			}
			catch (NumberFormatException e) {
				if (numberOfErrors == 2) {
					System.out.println("Integer value required. Press any key to exit.");
					sc.nextLine();
					System.exit(0);
				}
				
				System.out.println("Input must be a valid integer!");
				repeatInput = true;
				
				numberOfErrors++;
				
			}
			
		} while ( repeatInput == true);
	} while (! (menuChoice == 7));
	}
	
	
	
	public void editInfo() {
		
		int idNumber;
		int numberOfErrors = 0;
		boolean repeatInput = false;
		
		displayDevices();
		
		do {
			try{
		
		System.out.printf("\nEnter Device number to edit (1-%d): ", deviceList.size());
		idNumber = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < deviceList.size(); i ++) {
			if (idNumber == deviceList.get(i).getIdNumber()) {
				
				System.out.printf("\nEntering new information for device %d.\n\n", deviceList.get(i).getIdNumber());
				
				System.out.print("SKU: ");
				deviceList.get(i).setSkuCode(sc.nextLine());
				
				System.out.print("Name: ");
				deviceList.get(i).setTitle(sc.nextLine());
				
				System.out.println("\nDevice information updated.\n\nPress Enter to continue...");
				sc.nextLine();
			}
		}
			}
			catch(NumberFormatException e) {
				if (numberOfErrors == 2) {
					System.out.println("Input must be a valid integer! Press Enter to exit.");
				sc.nextLine();
				System.exit(0);
				}	
				
				System.out.println("Input must be a valid integer!");
				repeatInput = true;
				
				numberOfErrors++;
				
			}
		} while (repeatInput == true);
		
	} // end editInfo()
		
	
	
	public void checkOut() {
		
		int deviceChoice = 0;
		
		availableDevices();
		
		System.out.print("\nEnter Device number: ");
		deviceChoice = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < deviceList.size(); i++) {
			
			if (deviceChoice == i + 1 && deviceList.get(i).availabilityValue().equals("Checked Out")) {
				System.out.println("Device is unavailable.");
				checkOut();
			}
			else if (deviceChoice == i + 1 && deviceList.get(i).availabilityValue().equals("Available")) {
				deviceList.get(i).setAvailability(false);
				System.out.println("Device checked out."
						+ "\n\nPress Enter to continue...");
					sc.nextLine();
			}
			
		}

	}
	
	
	
	public void checkIn() {
		
		int deviceChoice = 0;
		
		unavailableDevices();
		
		System.out.print("\nEnter Device number: ");
		deviceChoice = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < deviceList.size(); i++) {
			
			if (deviceChoice == i + 1 && deviceList.get(i).availabilityValue().equals("Available")) {
				System.out.println("Device is still available.");
				checkIn();
			}
			else if (deviceChoice == i + 1 && deviceList.get(i).availabilityValue().equals("Checked Out")) {
				deviceList.get(i).setAvailability(true);
				System.out.println("Device checked in. Thank you."
						+ "\n\nPress Enter to continue...");
					sc.nextLine();
			}
			
		}
		
	}
	
	

	
	public void searchDevice() {	
		
		System.out.println("\n\n\t\tLibrary Device Checkout System - Search");
		
		System.out.print("\nEnter Device to search for: ");
		keyword = sc.nextLine().toLowerCase();
		
		returnSearch();
		
	}

	
	public void returnSearch() {
		
		String title = "Title";
		String skuCode = "SKU";
		String idNumber = "#";
		
		System.out.printf("\nListings for '%s'", keyword);
		System.out.printf("\n%-5s%-18s%-32s\n", idNumber, skuCode, title);
		for(Device d : deviceList) {
			if (d.getTitle().toLowerCase().contains(keyword)) {
				System.out.printf("%-5d%-18s%-36s\n", d.getIdNumber(), d.getSkuCode(), d.getTitle());
			}
			
		}//ends for
		
	}
	
	
	public void unavailableDevices() {
		
		String title = "Title";
		String skuCode = "SKU";
		String idNumber = "#";
		
		System.out.println("\nChecked Out Devices");
		System.out.printf("\n%-5s%-18s%-32s\n", idNumber, skuCode, title);
		for (Device d : deviceList) {
			if (d.getAvailability() == false) {
				System.out.printf("%-5d%-18s%-32s", d.getIdNumber(), d.getSkuCode(), d.getTitle());
				System.out.println();
				
			}
			
		}
		
	}
	
	

} // end class block
