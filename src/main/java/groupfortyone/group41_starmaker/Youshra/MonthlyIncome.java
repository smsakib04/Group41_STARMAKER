package groupfortyone.group41_starmaker.Youshra;

import java.util.ArrayList;

public class MonthlyIncome {
    public String amount;
    public String month;
    public static ArrayList<MonthlyIncome> monthlyIncomeList = new ArrayList<MonthlyIncome>();

    public MonthlyIncome(String amount, String month) {
        this.amount = amount;
        this.month= month;
    }

    public MonthlyIncome() {
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public static ArrayList<MonthlyIncome> getMonthlyIncomeList() {
        return monthlyIncomeList;
    }

    public static void setMonthlyIncomeList(ArrayList<MonthlyIncome> monthlyIncomeList) {
        MonthlyIncome.monthlyIncomeList = monthlyIncomeList;
    }

    @Override
    public String toString() {
        return "MonthlyIncome{" +
                "amount=" + amount +
                ", month='" + month + '\'' +
                '}';
    }
}
