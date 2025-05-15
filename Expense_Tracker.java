// --- Project 3: Expense Tracker ---

import java.io.*;
import java.util.*;

class Expense {
    String date, category;
    double amount;

    public Expense(String date, String category, double amount) {
        this.date = date;
        this.category = category;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return date + ", " + category + ", Rs. " + amount;
    }
}

class ExpenseTracker {
    private List<Expense> expenses = new ArrayList<>();
    private static final String FILE_NAME = "expenses.txt";

    public void addExpense(Expense e) {
        expenses.add(e);
        saveToFile();
    }

    public void listExpenses() {
        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    public void loadFromFile() {
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                expenses.add(new Expense(parts[0].trim(), parts[1].trim(), Double.parseDouble(parts[2].trim())));
            }
        } catch (Exception e) {
            System.out.println("No previous data found.");
        }
    }

    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Expense e : expenses) {
                writer.println(e.date + "," + e.category + "," + e.amount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class ExpenseTrackerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseTracker tracker = new ExpenseTracker();
        tracker.loadFromFile();

        while (true) {
            System.out.println("1. Add Expense\n2. List Expenses\n3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter date (dd-mm-yyyy): ");
                String date = scanner.nextLine();
                System.out.print("Enter category: ");
                String category = scanner.nextLine();
                System.out.print("Enter amount: ");
                double amount = scanner.nextDouble();
                tracker.addExpense(new Expense(date, category, amount));
            } else if (choice == 2) {
                tracker.listExpenses();
            } else {
                break;
            }
        }
    }
}
