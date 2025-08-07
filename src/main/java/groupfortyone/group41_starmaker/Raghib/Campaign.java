package groupfortyone.group41_starmaker.Raghib;

import java.time.LocalDate;
import java.util.ArrayList;

public class Campaign {
    private String title;
    private String content;
    private LocalDate date;
    private String status;


    public static ArrayList<Campaign> campaignList=new ArrayList<>();
    public static ArrayList<String> messageList= new ArrayList<>();

    public Campaign(String title, String content, LocalDate date, String status) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.status = status;
    }

    public Campaign() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }



}
