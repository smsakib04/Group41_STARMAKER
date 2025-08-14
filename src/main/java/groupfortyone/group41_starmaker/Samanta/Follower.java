package groupfortyone.group41_starmaker.Samanta;
import javafx.scene.control.Button;

public class Follower {

    private String followerName;
    private String followerID;
    private Boolean isBlocked;
    private Button blockButton;
    private Boolean isFollowed;
    private Button followButton;


    public Follower(String followerName, String followerID, Boolean isBlocked) {
        this.followerName = followerName;
        this.followerID = followerID;
        this.isBlocked = isBlocked;
        this.blockButton = blockButton;
        this.isFollowed= isFollowed;
        this.followButton= followButton;
    }

    public void setFollowerName(String followerName) {
        this.followerName = followerName;
    }

    public void setFollowerID(String followerID) {
        this.followerID = followerID;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public Button getBlockButton() {
        return blockButton;
    }

    public void setBlockButton(Button blockButton) {
        this.blockButton = blockButton;
    }

    public Boolean getFollowed() {
        return isFollowed;
    }

    public Button getFollowButton() {
        return followButton;
    }

    public void setFollowButton(Button followButton) {
        this.followButton = followButton;
    }

    public void setFollowed(Boolean followed) {
        isFollowed = followed;
    }


    public String getFollowerName() {
        return followerName;
    }

    public String getFollowerID() {
        return followerID;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

}
