package groupfortyone.group41_starmaker.Raghib;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Message implements Serializable {
    private String username;
    private String messagecontent;

    public static ArrayList<Message> messageList = new ArrayList<>();


    public Message() {
    }

    public Message(String username, String messagecontent) {
        this.username = username;
        this.messagecontent = messagecontent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessagecontent() {
        return messagecontent;
    }

    public void setMessagecontent(String messagecontent) {
        this.messagecontent = messagecontent;
    }

    public static ArrayList<Message> getMessageList() {
        return messageList;
    }

    public static void setMessageList(ArrayList<Message> messageList) {
        Message.messageList = messageList;
    }

    @Override
    public String toString() {
        return "Message{" +
                "username='" + username + '\'' +
                ", messagecontent='" + messagecontent + '\'' +
                '}';
    }
}