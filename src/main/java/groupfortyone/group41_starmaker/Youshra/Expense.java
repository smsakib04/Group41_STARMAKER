package groupfortyone.group41_starmaker.Youshra;

import java.util.ArrayList;

public class Expense {
    private String type;
    private Integer amount;

    public static ArrayList<Expense> expense = new ArrayList<Expense>();
    public Expense(String type, int id) {
        this.type = type;
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
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
