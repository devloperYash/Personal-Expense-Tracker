import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String category;
    double amount;

    Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }
}

public class ExpenseTracker {
    private static ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    deleteExpense(scanner);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addExpense(Scanner scanner) {
        System.out.print("Enter category: ");
        String category = scanner.next();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        expenses.add(new Expense(category, amount));
        System.out.println("Expense added successfully.");
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }
        System.out.println("Category\tAmount");
        for (Expense expense : expenses) {
            System.out.println(expense.category + "\t\t" + expense.amount);
        }
    }

    private static void deleteExpense(Scanner scanner) {
        viewExpenses();
        if (expenses.isEmpty()) return;

        System.out.print("Enter the index of the expense to delete (1 to " + expenses.size() + "): ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < expenses.size()) {
            expenses.remove(index);
            System.out.println("Expense deleted successfully.");
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }
}

