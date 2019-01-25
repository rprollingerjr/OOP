// Raymond Rollinger, A8, CIS 340, 430pm

public class Loan {

	private double loanAmount = 0.0;
	private double years = 0.0;
	private double annualRate = 0.0;
	private double monthlyRate = 0.0;
	private double monthlyPayment = 0.0;
	private double totalPayment = 0.0;
	
	public Loan () {
		annualRate = 5.0;
		
	}
	
	
	// IF value is not being passed from LoanManager class, SETTER is NOT necessary 
	// GET value will be established within Loan class methods
	
	
	// setter not necessary. value obtained behind the scenes
	public double getMonthlyRate() {
		monthlyRate = annualRate / 1200;
		return monthlyRate;
	}
	
	
	public double getMonthlyPayment() {
		monthlyPayment = getLoanAmount() * getMonthlyRate() / (1 -
				 (Math.pow(1 / (1 + getMonthlyRate()), getYears() * 12)));
		return monthlyPayment;
	}
	
	
	
	
	public double getTotalPayment() {
		totalPayment = getMonthlyPayment() * 12 * getYears();
		return totalPayment;
	}
	
	
	
	public double getLoanAmount() {
		return loanAmount;
	}
	
	
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	
	
	public double getYears() {
		return years;
	}
	
	
	public void setYears(double years) {
		this.years = years;
	}
	
	
	
	
	
	
	
}
