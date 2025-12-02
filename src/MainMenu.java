import java.util.List;
import java.util.Scanner;

/**
 * MainMenu - Console UI tying DAO and operations together.
 */
public class MainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SongDAO songDAO = new SongDAO();
        ArtistDAO artistDAO = new ArtistDAO();

        System.out.println("=== Java Music Management System (MySQL) ===");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1) Add Artist");
            System.out.println("2) Add Song");
            System.out.println("3) Update Song Price");
            System.out.println("4) Delete Song");
            System.out.println("5) List Songs");
            System.out.println("6) Simulate Play");
            System.out.println("7) List Artists");
            System.out.println("0) Exit");
            System.out.print("Enter choice: ");
            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection.");
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Artist name: ");
                        String name = sc.nextLine();
                        int id = artistDAO.addArtist(name);
                        System.out.println("Added artist with id: " + id);
                        break;
                    case 2:
                        System.out.print("Song title: ");
                        String title = sc.nextLine();
                        System.out.print("Price: ");
                        double price = Double.parseDouble(sc.nextLine());
                        System.out.print("Artist id: ");
                        int aid = Integer.parseInt(sc.nextLine());
                        songDAO.addSong(title, price, aid);
                        System.out.println("Song added.");
                        break;
                    case 3:
                        System.out.print("Song id: ");
                        int sid = Integer.parseInt(sc.nextLine());
                        System.out.print("New price: ");
                        double np = Double.parseDouble(sc.nextLine());
                        songDAO.updateSongPrice(sid, np);
                        System.out.println("Price updated.");
                        break;
                    case 4:
                        System.out.print("Song id: ");
                        int delId = Integer.parseInt(sc.nextLine());
                        songDAO.deleteSong(delId);
                        System.out.println("Deleted (if existed).");
                        break;
                    case 5:
                        List<String> rows = songDAO.listSongs();
                        if (rows.isEmpty()) System.out.println("No songs found.");
                        else rows.forEach(System.out::println);
                        break;
                    case 6:
                        System.out.print("Song id to simulate: ");
                        int psid = Integer.parseInt(sc.nextLine());
                        Song s = songDAO.getSongById(psid);
                        if (s == null) {
                            System.out.println("Song not found.");
                        } else {
                            System.out.print("Number of plays to simulate: ");
                            int plays = Integer.parseInt(sc.nextLine());
                            PlayASong.playSimulation(s, plays);
                        }
                        break;
                    case 7:
                        artistDAO.listArtists();
                        break;
                    case 0:
                        System.out.println("Goodbye.");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
