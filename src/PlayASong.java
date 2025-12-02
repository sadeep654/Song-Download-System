public class Song {
    private int songId;
    private int artistId;
    private String title;
    private double price;
    private String artistName;

    public Song(){}

    // getters & setters
    public int getSongId() { return songId; }
    public void setSongId(int id) { this.songId = id; }
    public int getArtistId() { return artistId; }
    public void setArtistId(int id) { this.artistId = id; }
    public String getTitle() { return title; }
    public void setTitle(String t) { this.title = t; }
    public double getPrice() { return price; }
    public void setPrice(double p) { this.price = p; }
    public String getArtistName() { return artistName; }
    public void setArtistName(String n) { this.artistName = n; }
}

/**
 * PlayASong - simulation that "plays" a song a number of times and calculates revenue.
 */
public class PlayASong {

    /**
     * Simulate playing a song n times and output revenue.
     * Uses Calculations.calculateRevenue for sample platform fee.
     */
    public static void playSimulation(Song s, int plays) {
        System.out.println("Now playing: " + s.getTitle() + " by " + s.getArtistName());
        System.out.println("Price per play: " + s.getPrice() + " | Plays: " + plays);
        double revenue = Calculations.calculateRevenue(s.getPrice(), plays, 0.30); // 30% platform fee
        System.out.printf("Estimated revenue (after 30%% fee): %.2f%n", revenue);
    }
}
