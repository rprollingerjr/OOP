// Raymond Rollinger, A8, CIS 340, 430pm
import java.util.Scanner;
import java.util.ArrayList;

public class LoanManager {
	
	Scanner sc = new Scanner(System.in);
	
	ArrayList<Loan> loanList = new ArrayList<Loan>();;


	public static void main(String[] args) {
		
		LoanManager loanSystem1; 
		loanSystem1 = new LoanManager();
		
		loanSystem1.displayHeader();
		loanSystem1.enterLoan();
		

	} // end main
	
	
	
	public void displayHeader() {
		
		System.out.println("\t\tFirst National Loans");
		
	}
	
	
	public void displayLoans() {
		
		System.out.println("\nFollowing are the loans in the system.");
		System.out.println("Amount\t\t\tTotal Payment");
		for (Loan l : loanList) {
			System.out.printf("%-24.2f%-24.2f\n", l.getLoanAmount(), l.getTotalPayment());
		}
		totalAllLoans();
	}
	

	
	public void enterLoan() {
		
		Loan tempLoan = new Loan();
		String decision = "";
		int numberOfErrors = 0;
		boolean repeatInput = false;
				
		System.out.print("\nEnter loan amount: ");
		tempLoan.setLoanAmount(Double.parseDouble(sc.nextLine()));
		
		System.out.print("Enter number of years: ");
		tempLoan.setYears(Double.parseDouble(sc.nextLine()));
		
		loanList.add(tempLoan);
		
		System.out.printf("\nThe total payment on this loan will be $%.2f", tempLoan.getTotalPayment());
		
		do {
		try {
		System.out.print("\n\nDo you want to apply for another loan? (Y/N): ");
		decision = sc.nextLine();
		
		if (decision.equalsIgnoreCase("Y")) {
			if (loanList.size() >= 10) {
				System.out.println("Max number of loans applied for.");
				displayLoans();
			}
			else {
			enterLoan();
			}
		}
		else {
			displayLoans();
		}	
		}// end try
		catch(Exception e){
			if (numberOfErrors == 2) {
				System.out.print("\nYou are having problems entering an acceptable value. Press any key to exit.");
				sc.nextLine();
				displayLoans();
				System.exit(0);
			}
			System.out.println("\nInput must be a valid integer!\n");
			repeatInput = true;
			
			
			numberOfErrors++;
		}
		}while (repeatInput == true);
		
	} // end enterLoan
	
	
	
	public void totalAllLoans() {
		
		double totalAllLoans = 0.0;
		int decision = 0;
		boolean repeatInput = false;
		int numberOfErrors = 0;
		
		for (Loan l : loanList) {
			totalAllLoans += l.getTotalPayment();
		}
		
		System.out.printf("\nThe total payment of all loans combined is $%.2f\nGood luck.", totalAllLoans);
		
		do {
			try {
		System.out.print("\n\nPress Enter to exit or '1' to apply for more loans.");
		decision = Integer.parseInt(sc.nextLine());
			
		
		}
		
			
			catch(NumberFormatException e) {
				if (numberOfErrors == 2) {
					System.out.print("You are having problems entering an integer value. Press any key to exit. ");
					sc.nextLine();
					System.exit(0);
				}
				System.out.println("Input must be a valid integer!");
				repeatInput = true;
				
				numberOfErrors++;
			}
		} while (repeatInput == true);
		
		
		switch (decision) {
		
		case 1:
			if (loanList.size() >= 10) {
				System.out.println("Max number of loans applied for.");
				displayLoans();
			}
			else {
			enterLoan();
			}
			break;
		default:
			System.exit(0);
		}
		
	}
	
	

}
