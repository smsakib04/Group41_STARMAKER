package groupfortyone.group41_starmaker.Samanta;

public class LiveBroadcast {
    private String title;
    private String description;
    private String date;
    private int gift;
    private String Platform;

    public LiveBroadcast(String title, String description, String date, int gift, String platform) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.gift = gift;
        Platform = platform;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getGift() {
        return gift;
    }

    public void setGift(int gift) {
        this.gift = gift;
    }

    public String getPlatform() {
        return Platform;
    }

    public void setPlatform(String platform) {
        Platform = platform;
    }

    @Override
    public String toString() {
        return "LiveBroadcast{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", gift=" + gift +
                ", Platform='" + Platform + '\'' +
                '}';
    }
}