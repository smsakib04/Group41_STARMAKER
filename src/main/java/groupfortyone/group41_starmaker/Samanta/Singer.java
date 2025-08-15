package groupfortyone.group41_starmaker.Samanta;

public class Singer {
    private String singerName;
    private String singerID;
    private String status;

    public Singer(String singerName, String singerID, String status) {
        this.singerName = singerName;
        this.singerID = singerID;
        this.status = status;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSingerID() {
        return singerID;
    }

    public void setSingerID(String singerID) {
        this.singerID = singerID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "singerName='" + singerName + '\'' +
                ", singerID='" + singerID + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
