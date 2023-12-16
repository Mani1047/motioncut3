import java.util.*;

public class ExpenseTracker {
    private double balance;
    private Map<String, Double> expensesByCategory;

    public ExpenseTracker(double initialBalance) {
        this.balance = initialBalance;
        this.expensesByCategory = new HashMap<>();
    }

    public void addExpense(double amount, String category) {
        balance -= amount;
        expensesByCategory.put(category, expensesByCategory.getOrDefault(category, 0.0) + amount);
    }

    public void displayBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    public void displayExpenseSummaries() {
        System.out.println("---- Expense Summaries ----");
        if (expensesByCategory.isEmpty()) {
            System.out.println("No expenses recorded yet.");
        } else {
            for (Map.Entry<String, Double> entry : expensesByCategory.entrySet()) {
                System.out.println("Category: " + entry.getKey() + " | Total Expenses: $" + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: $");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        ExpenseTracker tracker = new ExpenseTracker(initialBalance);

        while (true) {
            System.out.println("\n1. Add Expense");
            System.out.println("2. Display Balance");
            System.out.println("3. Display Expense Summaries");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1/2/3/4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter expense amount: $");
                    double expenseAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter expense category: ");
                    String category = scanner.nextLine();

                    tracker.addExpense(expenseAmount, category);
                    System.out.println("Expense added successfully.");
                    break;
                case 2:
                    tracker.displayBalance();
                    break;
                case 3:
                    tracker.displayExpenseSummaries();
                    break;
                case 4:
                    System.out.println("Exiting the expense tracker. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
