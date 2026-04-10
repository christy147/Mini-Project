import java.util.*;

class Expense {
    String date, category, description;
    double amount;

    Expense(String date, String category, double amount, String description) {
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.description = description;
    }
}

class Income {
    String date, source;
    double amount;

    Income(String date, String source, double amount) {
        this.date = date;
        this.source = source;
        this.amount = amount;
    }
}

class BudgetManager {
    private List<Expense> expenses = new ArrayList<>();
    private List<Income> incomes = new ArrayList<>();
    private double monthlyBudget;

    BudgetManager(double monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    void addExpense(Expense e) {
        expenses.add(e);
    }

    void addIncome(Income i) {
        incomes.add(i);
    }

    double getTotalExpenses() {
        return expenses.stream().mapToDouble(e -> e.amount).sum();
    }

    double getTotalIncome() {
        return incomes.stream().mapToDouble(i -> i.amount).sum();
    }

    double getSavings() {
        return getTotalIncome() - getTotalExpenses();
    }

    void generateReport() {
        System.out.println("=== Monthly Report ===");
        System.out.println("Total Income: " + getTotalIncome());
        System.out.println("Total Expenses: " + getTotalExpenses());
        System.out.println("Savings: " + getSavings());

        if (getTotalExpenses() > monthlyBudget) {
            System.out.println("⚠️ Warning: Expenses exceeded budget!");
        }
    }
}

public class ExpenseTracker {
    public static void main(String[] args) {
        BudgetManager bm = new BudgetManager(50000);

        bm.addIncome(new Income("2026-04-01", "Salary", 60000));
        bm.addExpense(new Expense("2026-04-05", "Food", 5000, "Groceries"));
        bm.addExpense(new Expense("2026-04-10", "Rent", 15000, "Monthly rent"));

        bm.generateReport();
    }
}