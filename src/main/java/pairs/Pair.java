package pairs;

public abstract class Pair {
    private String link;

    public Pair(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}
