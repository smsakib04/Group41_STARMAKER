package groupfortyone.group41_starmaker.Youshra;

import java.util.ArrayList;

public class Expense {
    private String type;
    private String amount;

    public static ArrayList<Expense> expense = new ArrayList<Expense>();
    public Expense(String type, String amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<Expense> getExpense() {
        return expense;
    }

    public static void setExpense(ArrayList<Expense> expense) {
        Expense.expense = expense;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}
