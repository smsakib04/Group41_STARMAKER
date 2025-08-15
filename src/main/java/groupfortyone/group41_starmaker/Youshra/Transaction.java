package groupfortyone.group41_starmaker.Youshra;

import java.util.ArrayList;

public class Transaction {
    private String amount;
    private String type;
    public static ArrayList<Transaction> TransactionList = new ArrayList<Transaction>();

    public Transaction(String amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public static ArrayList<Transaction> getTransactionList() {
        return TransactionList;
    }

    public static void setTransactionList(ArrayList<Transaction> transactionList) {
        TransactionList = transactionList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount='" + amount + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
