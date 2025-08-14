package groupfortyone.group41_starmaker.Samanta;


public class Rank {
    private String userID;
    private int rank;

    public Rank(String userID, int rank) {
        this.userID = userID;
        this.rank = rank;
    }

    public  String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public  int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}