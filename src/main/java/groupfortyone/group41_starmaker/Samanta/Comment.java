package groupfortyone.group41_starmaker.Samanta;

import java.time.LocalDate;

public class Comment {
    private String commentText;
    private String songName;
    private LocalDate commentDate;

    public Comment(String commentText, String songName, LocalDate commentDate) {
        this.commentText = commentText;
        this.songName = songName;
        this.commentDate = commentDate;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public LocalDate getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDate commentDate) {
        this.commentDate = commentDate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentText='" + commentText + '\'' +
                ", songName='" + songName + '\'' +
                ", commentDate=" + commentDate +
                '}';
    }
}
