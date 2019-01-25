import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BudgetSystem {
	
	
	ArrayList <Expense> expenseList = new ArrayList<Expense>();
	
	private double paycheckAmount = 0.0;
	private double totalExpenses = 0.0;
	private double cash = 0.0;
	private double decimalSpent = 0.0;
	private double percentageSpent = 0.0;
	
	Expense expense1 = new Expense();
	Expense expense2 = new Expense();	
	Expense expense3 = new Expense();	
	Expense expense4 = new Expense();	
	Expense expense5 = new Expense();
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		BudgetSystem paulsBiWeeklyBudgeter;
		paulsBiWeeklyBudgeter = new BudgetSystem();
		
		
		paulsBiWeeklyBudgeter.displayHeader();
		paulsBiWeeklyBudgeter.currentDate();
		paulsBiWeeklyBudgeter.configureExpenseList();
		paulsBiWeeklyBudgeter.displayMenu();
		
		
		

	} // end main method
	
	
	
	public void configureExpenseList() {
		
		// expense names
		expense1.setName("Gas");
		expense2.setName("Cricket Wireless (due on 20th)");
		expense3.setName("Capital One (due on 7th)");
		expense4.setName("Progressive (due on 26th)");
		
		
		// monthly expense amounts
		expense1.setMonthlyAmount(100);
		expense2.setMonthlyAmount(50);
		expense3.setMonthlyAmount(100);
		expense4.setMonthlyAmount(62.27);
		
		
		expenseList.add(expense1);
		expenseList.add(expense2);
		expenseList.add(expense3);
		expenseList.add(expense4);
		
		
	}
	
	
	public void currentDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		System.out.println(formatter.format(date));
		
//		if ()
		
		
	}
	
	
	public void displayAmounts() {
		
		System.out.println("Your current monthly expenses are:");
		for(Expense e : expenseList) {
			
			System.out.printf("%-32s%32.2f", e.getName(), e.getMonthlyAmount());
			System.out.println();
		}
	}
	
	
		
	public void displayHeader() {
		System.out.println("\t\t* * * Bi-Weekly Budgeter * * *\n");
	}
	
	
			
	
	
	
	public void enterPaycheck() {
		
		boolean repeatInput = false;
		int numberOfErrors = 0;
		
		do {
			try {
		System.out.print("\nEnter the amount of your paycheck: ");
		paycheckAmount = Double.parseDouble(sc.nextLine());
			}
			catch(NumberFormatException e) {
				System.out.println("Your input was invalid. Please enter a valid financial number.");
			
				numberOfErrors++;
			
				if (numberOfErrors >= 2) {
					repeatInput = true;
				}
			}
			
		}while(repeatInput == true);
		
	}
	
	
	
	public void enterExpenses() {
		
		System.out.println("\nHow much are you taking out this paycheck?");
		for(int i = 0; i < expenseList.size(); i++) {
			System.out.printf("%s: ", expenseList.get(i).getName());
			expenseList.get(i).setBiWeeklyAmount(Double.parseDouble(sc.nextLine()));
			
			totalExpenses += expenseList.get(i).getBiWeeklyAmount();
			
			
			
		}
		
		// amount left over after expenses
			cash = paycheckAmount - totalExpenses;
		
	}
	
	
	
	public void displayPercentages() {
		
		System.out.printf("\nCheck amount was %.2f\nExpenses: %.2f\nRemaining Cash Balance: %.2f", paycheckAmount, totalExpenses, cash);
		
		decimalSpent = totalExpenses / paycheckAmount;
		
		percentageSpent = decimalSpent * 100;
		
		System.out.printf("\n\nYou have spent %.2f%% of your check on expenses.\n\n", percentageSpent);
		
		
	}
	
	
	
	public void displayMenu() {
		
		String menuSelection = "";
	
		
		do {
			System.out.println("\n\tProgram Menu\n");
			System.out.print("1. Enter/Re-Enter Paycheck Amount\n"
					+ "2. Display Monthly Expenses\n"
					+ "3. Enter/Re-Enter Bi-Weekly Expenses\n"
					+ "4. Statistics\n"
					+ "5. Exit Program\n\n"
					+ "Please make a selection: ");
			menuSelection = sc.nextLine();
			System.out.println();
			
			switch (menuSelection) {
			
			case "1": 
				enterPaycheck();
				break;
			case "2":
				displayAmounts();
				break;
			case "3":
				enterExpenses();
				break;
			case "4":
				displayPercentages();
				break;
			case "5":
				System.exit(0);
				break;
			default:
				displayMenu();
				break;
			
			}
			
		} while (!(menuSelection == "5"));
	}
	
	
	
	

} // end class block
