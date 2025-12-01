package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";


    public static void main(String[] args) {
        Connection connection = null;

        try {

            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion réussie à PostgreSQL !");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver PostgreSQL non trouvé.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Erreur de connexion.");
            e.printStackTrace();

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Connexion fermée.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

