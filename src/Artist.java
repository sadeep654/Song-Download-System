public class Artist {
    private int artistId;
    private String name;

    public Artist() {}

    public Artist(int artistId, String name) {
        this.artistId = artistId;
        this.name = name;
    }

    public Artist(String name) {
        this.name = name;
    }

    public int getArtistId() {
        return artistId;
    }
    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return artistId + " | " + name;
    }
}
