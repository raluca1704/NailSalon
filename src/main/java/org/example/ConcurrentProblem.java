package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConcurrentProblem {
    // Metoda pentru inserarea datelor în tabela 1
    public static void insertIntoTable1(Connection conn) throws SQLException {
        String sql = "INSERT INTO Clienti (ID_Client, Nume, Prenume) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, 5); // ID pentru inserare în tabela 1
        stmt.setString(2, "NumeClient1"); // Numele clientului
        stmt.setString(3, "PrenumeClient1"); // Prenumele clientului
        stmt.executeUpdate();
        System.out.println("Clientul a fost adăugat în tabela Clienti.");
    }

    public static void insertIntoTable2(Connection conn) throws SQLException {
        String sql = "INSERT INTO Angajati (ID_Angajat, Nume, Prenume) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, 5); // ID pentru inserare în tabela 2
        stmt.setString(2, "NumeAngajat1"); // Numele angajatului
        stmt.setString(3, "PrenumeAngajat1"); // Prenumele angajatului
        stmt.executeUpdate();
        System.out.println("Angajatul a fost adăugat în tabela Angajati.");
    }
}
