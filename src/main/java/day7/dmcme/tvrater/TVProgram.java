package day7.dmcme.tvrater;

public class TVProgram {

    private String programmeName;
    private String broadcaster;
    private int rating;
    private double averageAudience;

    public TVProgram(String programmeName, String broadcaster, int rating, double averageAudience) {
        this.setProgrammeName(programmeName);
        this.setBroadcaster(broadcaster);
        this.setRating(rating);
        this.setAverageAudience(averageAudience);
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    public String getBroadcaster() {
        return broadcaster;
    }

    public void setBroadcaster(String broadcaster) {
        this.broadcaster = broadcaster;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getAverageAudience() {
        return averageAudience;
    }

    public void setAverageAudience(double averageAudience) {
        this.averageAudience = averageAudience;
    }

    @Override
    public String toString() {
        return "TVProgram{" +
                "programmeName='" + programmeName + '\'' +
                ", broadcaster='" + broadcaster + '\'' +
                ", rating=" + rating +
                ", averageAudience=" + averageAudience +
                '}';
    }

    public String outputProgrammeDetails() {
        return
                "Programme Name \t: " + this.programmeName + "\n" +
                "Broadcaster \t\t: " + this.broadcaster + "\n" +
                "Ratings \t\t\t: " + this.rating + "\n" +
                "Average Audience \t\t: "+ this.averageAudience ;
    }
}
