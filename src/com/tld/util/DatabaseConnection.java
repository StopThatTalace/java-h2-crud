package com.tld.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// Classe utilitaire pour gérer la connexion à la base de données.
public class DatabaseConnection {

    // URL JDBC pour la connexion à la base de données.
    private static final String JDBC_URL = "jdbc:h2:tcp://localhost:8802/products";

    // Identifiants de connexion à la base de données.
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";

    // Objets de connexion et de déclaration SQL.
    private static Connection connection;
    private static Statement statement;

    // Constructeur privé pour appliquer le modèle de conception Singleton.
    private DatabaseConnection() {
        // Constructeur privé pour éviter l'instanciation directe.
    }

    // Méthode pour obtenir l'instance unique de la classe DatabaseConnection.
    public static DatabaseConnection getInstance() {
        return DatabaseConnectionHolder.INSTANCE;
    }

    // Classe interne pour contenir l'instance unique de DatabaseConnection de manière sécurisée.
    private static class DatabaseConnectionHolder {
        private static final DatabaseConnection INSTANCE = new DatabaseConnection();
    }

    // Méthode pour obtenir une connexion à la base de données.
    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            // Création d'une nouvelle connexion si elle est nulle ou fermée.
            connection = DriverManager.getConnection(JDBC_URL, LOGIN, PASSWORD);
            System.out.println("[+] Connexion réussie");
        }
        return connection;
    }

    // Méthode pour créer une déclaration SQL en utilisant une connexion fournie.
    public Statement createStatement(Connection connection) throws SQLException {
        if (statement == null || statement.isClosed()) {
            // Création d'une nouvelle déclaration si elle est nulle ou fermée.
            statement = connection.createStatement();
        }
        return statement;
    }
}
