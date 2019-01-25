//Raymond Rollinger, MP2, CIS 340, 430pm

public class Device {

	private String title = "";
	private String skuCode = "";
	private int idNumber = 0;
	private String availability = "";
	private boolean available = true;
	
	
	// constructors listed first
	// method alphabetical and each getter & setter is paired per function
	
	
	
	public Device() {
		
	}
	
	public Device(String title, String skuCode) {
		this.title = title;
		this.skuCode = skuCode;
	}
	
	
	
	public String availabilityValue() {
		return availability;
	}
	
	public boolean getAvailability() {
		return available;
	}
	
	
	// available set to true by default
	public void setAvailability(boolean available) {
		
		
			
			if (available == false) {
				availability = "Checked Out";
			}	
			else {
				availability = "Available";
			}
		this.available = available;
	}
	
	
	public int getIdNumber() {
		return idNumber;
	}
	
	
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	
	
	
	public String getTitle() {
		return title;
	}
	
	
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getSkuCode() {
		return skuCode;
	}
	
	
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	
	

	
	
	
	
	
	
	
}
