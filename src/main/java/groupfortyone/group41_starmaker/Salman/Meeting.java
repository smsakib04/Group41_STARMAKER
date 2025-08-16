package groupfortyone.group41_starmaker.Salman;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Meeting implements Serializable {
    public String meetingTopic;
    public LocalDate meetingDate;

    public Meeting(String meetingTopic, LocalDate meetingDate) {
        this.meetingTopic = meetingTopic;
        this.meetingDate = meetingDate;
    }

    public String getMeetingTopic() {
        return meetingTopic;
    }

    public void setMeetingTopic(String meetingTopic) {
        this.meetingTopic = meetingTopic;
    }

    public LocalDate getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(LocalDate meetingDate) {
        this.meetingDate = meetingDate;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meetingTopic='" + meetingTopic + '\'' +
                ", meetingDate=" + meetingDate +
                '}';
    }

    public static ArrayList<Meeting> meetingList = new ArrayList<>();
}
