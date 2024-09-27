package com.wiss.m295.sq2a;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class GameItemsController {
    // Schritt 2: Datenbankverbindungsdetails definieren
    static final String DB_URL = "jdbc:mysql://localhost:3306/game_gadgets";
    static final String USER = "root";
    static final String PASS = "test";

    // Schritt 3: Verbindung zur Datenbank herstellen
    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    // Methode zum Anzeigen aller Gadget-Datensätze
    public void printGameItems() throws Exception {
        // Schritt 4: SQL-Abfrage vorbereiten
        String query = "SELECT * FROM game_items";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            // Schritt 5: Abfrage ausführen
            while (rs.next()) {
                System.out.print("ID: " + rs.getInt("item_id"));
                System.out.println(", Name: " + rs.getString("item_name"));
            }
        }
    }

    // Methode zum Hinzufügen eines neuen Gadget-Datensatzes
    public void addGameItems(String item) throws Exception {
        String query = "INSERT INTO game_items (item_name) VALUES (?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, item);
            stmt.executeUpdate();
            System.out.println("Neues Gadget hinzugefügt: " + item);
        }
    }

    // Methode zum Entfernen eines Gadget-Datensatzes anhand der ID
    public void removeGameItems(int item_id) throws Exception {
        String query = "DELETE FROM game_items WHERE item_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, item_id);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Gadget mit ID " + item_id + " wurde entfernt.");
            } else {
                System.out.println("Gadget mit ID " + item_id + " nicht gefunden.");
            }
        }
    }
}