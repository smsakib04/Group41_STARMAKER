package groupfortyone.group41_starmaker.Samanta;

public class Gift {

    private String singerName;
    private int amount;
    private String date;

    public Gift(String singerName, int amount, String date) {
        this.singerName = singerName;
        this.amount = amount;
        this.date = date;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "singerName='" + singerName + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}

