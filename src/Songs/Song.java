package Songs;

public class Song {
    private String name;

    private String duration;

    public Song(String name, String title) {
        this.name = name;
        this.duration = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
