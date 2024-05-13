package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/NailSalon";
        String user = "ralucx2";
        String password = "ralucx2";

        try {
            // Conectarea la baza de date
            Connection conn = DriverManager.getConnection(url, user, password);

            // Crearea și pornirea primului fir de execuție pentru inserarea în tabela 1
            Thread thread1 = new Thread(() -> {
                try {
                    ConcurrentProblem.insertIntoTable1(conn);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });

            // Crearea și pornirea celui de-al doilea fir de execuție pentru inserarea în tabela 2
            Thread thread2 = new Thread(() -> {
                try {
                    ConcurrentProblem.insertIntoTable2(conn);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });

            // Pornirea ambelor fire de execuție
            thread1.start();
            thread2.start();

            // Așteptarea ca ambele fire de execuție să se încheie
            thread1.join();
            thread2.join();

            // Închiderea conexiunii
            conn.close();
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}