package groupfortyone.group41_starmaker.Youshra;

public class Refund {
    private String name;
    private String amount;
    private String type;

    public Refund(String amount, String name, String type) {
        this.amount = amount;
        this.name = name;
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Refund{" +
                "amount=" + amount +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
