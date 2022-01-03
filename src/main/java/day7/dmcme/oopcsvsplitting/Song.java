package day7.dmcme.oopcsvsplitting;

public class Song {

    private String title;
    private String artist;
    private String highestPosition;

    public Song(String title, String artist, String highestPosition) {
        this.setTitle(title);
        this.setArtist(artist);
        this.setHighestPosition(highestPosition);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getHighestPosition() {
        return highestPosition;
    }

    public void setHighestPosition(String highestPosition) {
        this.highestPosition = highestPosition;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", highestPosition=" + highestPosition +
                '}';
    }
}
