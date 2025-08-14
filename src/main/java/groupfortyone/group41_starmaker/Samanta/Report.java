package groupfortyone.group41_starmaker.Samanta;

public class Report {
    private String singerUsername;
    private String reportCategory;
    private String comment;
    private String status;

    public Report(String singerUsername, String reportCategory, String comment, String status) {
        this.singerUsername = singerUsername;
        this.reportCategory = reportCategory;
        this.comment = comment;
        this.status = status;
    }

    public String getSingerUsername() {
        return singerUsername;
    }

    public void setSingerUsername(String singerUsername) {
        this.singerUsername = singerUsername;
    }

    public String getReportCategory() {
        return reportCategory;
    }

    public void setReportCategory(String reportCategory) {
        this.reportCategory = reportCategory;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
