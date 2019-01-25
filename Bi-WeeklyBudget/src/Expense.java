
public class Expense {

	String name = "";
	double monthlyAmount = 0.0;
	double biWeeklyAmount = 0.0;
	
	
	public Expense() {
		
	}
	
	
	
	public Expense(String name, double monthlyAmount) {
		this.name = name;
		this.monthlyAmount = monthlyAmount;
	}
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public String getName() {
		return name;
	}
	
	
	
	public void setMonthlyAmount(double monthlyAmount) {
		this.monthlyAmount = monthlyAmount;
	}
	
	
	
	public double getMonthlyAmount() {
		return monthlyAmount;
	}
	
	
	public void setBiWeeklyAmount(double biWeeklyAmount) {
		this.biWeeklyAmount = biWeeklyAmount;
	}
	
	
	public double getBiWeeklyAmount() {
		return biWeeklyAmount;
	}
	
	
	
	
}
