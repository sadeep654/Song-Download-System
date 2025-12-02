import java.sql.*;
import java.util.ArrayList;

public class SongDAO {

    public void addSong(String title, double price, int artistId) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO songs (title, price, artist_id) VALUES (?,?,?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, title);
        pst.setDouble(2, price);
        pst.setInt(3, artistId);
        pst.executeUpdate();
        con.close();
    }

    public void updateSongPrice(int songId, double newPrice) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "UPDATE songs SET price=? WHERE song_id=?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setDouble(1, newPrice);
        pst.setInt(2, songId);
        pst.executeUpdate();
        con.close();
    }

    public void deleteSong(int songId) throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "DELETE FROM songs WHERE song_id=?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, songId);
        pst.executeUpdate();
        con.close();
    }

    public void listSongs() throws Exception {
        Connection con = DBConnection.getConnection();
        String query = "SELECT s.song_id, s.title, s.price, a.name FROM songs s JOIN artists a ON s.artist_id=a.artist_id";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()) {
            System.out.println(
                rs.getInt("song_id") + " | " +
                rs.getString("title") + " | " +
                rs.getDouble("price") + " | " +
                rs.getString("name")
            );
        }
        con.close();
    }
}
