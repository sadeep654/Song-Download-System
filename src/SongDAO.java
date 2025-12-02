import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * SongDAO - CRUD operations for songs table.
 * songs(song_id, artist_id, title, price)
 */
public class SongDAO {

    public void addSong(String title, double price, int artistId) throws Exception {
        String sql = "INSERT INTO songs (artist_id, title, price) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, artistId);
            pst.setString(2, title);
            pst.setDouble(3, price);
            pst.executeUpdate();
        }
    }

    public void updateSongPrice(int songId, double newPrice) throws Exception {
        String sql = "UPDATE songs SET price = ? WHERE song_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setDouble(1, newPrice);
            pst.setInt(2, songId);
            pst.executeUpdate();
        }
    }

    public void deleteSong(int songId) throws Exception {
        String sql = "DELETE FROM songs WHERE song_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, songId);
            pst.executeUpdate();
        }
    }

    public List<String> listSongs() throws Exception {
        String sql = "SELECT s.song_id, s.title, s.price, a.name " +
                     "FROM songs s JOIN artists a ON s.artist_id = a.artist_id " +
                     "ORDER BY s.song_id";
        List<String> rows = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                String row = rs.getInt("song_id") + " | " +
                             rs.getString("title") + " | " +
                             rs.getDouble("price") + " | " +
                             rs.getString("name");
                rows.add(row);
            }
        }
        return rows;
    }

    public Song getSongById(int songId) throws Exception {
        String sql = "SELECT s.song_id, s.title, s.price, a.artist_id, a.name " +
                     "FROM songs s JOIN artists a ON s.artist_id = a.artist_id WHERE s.song_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, songId);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Song s = new Song();
                    s.setSongId(rs.getInt("song_id"));
                    s.setTitle(rs.getString("title"));
                    s.setPrice(rs.getDouble("price"));
                    s.setArtistId(rs.getInt("artist_id"));
                    s.setArtistName(rs.getString("name"));
                    return s;
                }
            }
        }
        return null;
    }
}
