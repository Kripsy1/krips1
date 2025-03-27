package cz.veletova.pojisteni.repository;

import cz.veletova.pojisteni.models.Pojistenec;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PojistenecRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/pojisteniapp";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public List<Pojistenec> getAll() {
        List<Pojistenec> pojistenci = new ArrayList<>();
        String sql = "SELECT * FROM pojistenci";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                pojistenci.add(new Pojistenec(
                        rs.getInt("id"),
                        rs.getString("jmeno"),
                        rs.getString("prijmeni"),
                        rs.getString("email"),
                        rs.getString("telefon"),
                        rs.getString("ulice"),
                        rs.getString("mesto"),
                        rs.getString("psc")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pojistenci;
    }

    public void add(Pojistenec p) {
        String sql = "INSERT INTO pojistenci (jmeno, prijmeni, email, telefon, ulice, mesto, psc) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getJmeno());
            stmt.setString(2, p.getPrijmeni());
            stmt.setString(3, p.getEmail());
            stmt.setString(4, p.getTelefon());
            stmt.setString(5, p.getUlice());
            stmt.setString(6, p.getMesto());
            stmt.setString(7, p.getPsc());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteByEmail(String email) {
        String sql = "DELETE FROM pojistenci WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updatePojistenec(Pojistenec p) {
        String sql = "UPDATE pojistenci SET jmeno = ?, prijmeni = ?, telefon = ?, ulice = ?, mesto = ?, psc = ? WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getJmeno());
            stmt.setString(2, p.getPrijmeni());
            stmt.setString(3, p.getTelefon());
            stmt.setString(4, p.getUlice());
            stmt.setString(5, p.getMesto());
            stmt.setString(6, p.getPsc());
            stmt.setString(7, p.getEmail()); // podmínka WHERE email = ?
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

