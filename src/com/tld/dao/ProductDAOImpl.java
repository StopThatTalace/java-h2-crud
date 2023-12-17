/*
Cette classe, `ProductDAOImpl`, fournit une implémentation concrète des opérations définies dans l'interface `ProductDAO`.
Elle permet l'interaction avec une base de données relationnelle pour effectuer des opérations de lecture et d'écriture liées aux produits.
Les méthodes implémentées incluent la récupération d'un produit par son identifiant, la récupération de tous les produits,
l'ajout d'un nouveau produit, la suppression d'un produit par son identifiant, et la mise à jour des informations d'un produit existant.

Chaque méthode utilise des requêtes SQL pour interagir avec la base de données, et des précautions sont prises pour gérer les connexions
et fermer correctement les ressources afin d'éviter les fuites de mémoire et de connexion. Des messages de console sont également
affichés pour informer l'utilisateur du succès ou de l'échec des opérations effectuées sur la base de données.
@Talace
*/

package com.tld.dao;

import com.tld.util.DatabaseConnection;
import com.tld.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Implémentation concrète de l'interface ProductDAO pour interagir avec la base de données des produits.
public class ProductDAOImpl implements ProductDAO {
    // Instance de connexion à la base de données utilisée dans cette implémentation.
    private DatabaseConnection databaseConnection;

    // Constructeur initialisant la connexion à la base de données.
    public ProductDAOImpl() {
        this.databaseConnection = DatabaseConnection.getInstance();
    }

    // Récupère un produit par son identifiant depuis la base de données.
    @Override
    public Product getProductById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Product product = null;

        try {
            connection = databaseConnection.getConnection();

            String sql = "SELECT * FROM Products WHERE product_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Extraction des données du ResultSet pour créer un objet Product.
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                int stockQuantity = resultSet.getInt("stock_quantity");
                boolean isAvailable = resultSet.getBoolean("is_available");
                String creationDate = resultSet.getString("creation_date");

                product = new Product(productId, productName, description, price, stockQuantity, isAvailable, creationDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermeture des ressources pour éviter les fuites de connexion.
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return product;
    }

    // Récupère tous les produits depuis la base de données.
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        try {
            Connection connection = databaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Products");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Extraction des données du ResultSet pour créer une liste d'objets Product.
                Product product = new Product(
                        resultSet.getInt("product_id"),
                        resultSet.getString("product_name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("stock_quantity"),
                        resultSet.getBoolean("is_available"),
                        resultSet.getString("creation_date")
                );

                products.add(product);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    // Ajoute un nouveau produit à la base de données.
    @Override
    public void addProduct(Product product) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = databaseConnection.getConnection();

            String sql = "INSERT INTO Products (product_id, product_name, description, price, stock_quantity, is_available, creation_date) VALUES (?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getStockQuantity());
            preparedStatement.setBoolean(6, product.isAvailable());
            preparedStatement.setDate(7, java.sql.Date.valueOf(java.time.LocalDate.now()));

            int rowsAffected = preparedStatement.executeUpdate();

            // Affichage d'un message indiquant le succès ou l'échec de l'ajout.
            if (rowsAffected > 0) {
                System.out.println("[+] Product added to the database successfully!");
            } else {
                System.out.println("[-] Failed to add the product to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermeture des ressources pour éviter les fuites de connexion.
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Supprime un produit par son identifiant de la base de données.
    @Override
    public boolean deleteProduct(int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = databaseConnection.getConnection();
            String deleteQuery = "DELETE FROM Products WHERE product_id = ?";
            statement = connection.prepareStatement(deleteQuery);
            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();

            // Affichage d'un message indiquant le succès ou l'échec de la suppression.
            if (rowsAffected > 0) {
                System.out.println("[+] Product with ID " + id + " deleted successfully!");
                return true;
            } else {
                System.out.println("[-] Product with ID " + id + " not found. No deletion performed.");
            }

        } catch (SQLException e) {
            System.out.println("[-] Error deleting product with ID " + id + ": " + e.getMessage());
        } finally {
            // Fermeture des ressources pour éviter les fuites de connexion.
            try {
                if (statement != null) statement.close();
                if (connection != null && !connection.isClosed()) connection.close();
            } catch (SQLException e) {
                System.out.println("[-] Error closing resources: " + e.getMessage());
            }
        }
        return false;
    }

    // Met à jour les informations d'un produit dans la base de données.
    @Override
    public boolean updateProduct(int productId, String productName, String description, double price, int stockQuantity, boolean isAvailable) {
        String updateQuery = "UPDATE Products SET product_name = ?, description = ?, price = ?, stock_quantity = ?, is_available = ? WHERE product_id = ?";
        PreparedStatement preparedStatement = null;

        try {
            DatabaseConnection connection = DatabaseConnection.getInstance();
            preparedStatement = connection.getConnection().prepareStatement(updateQuery);

            preparedStatement.setString(1, productName);
            preparedStatement.setString(2, description);
            preparedStatement.setDouble(3, price);
            preparedStatement.setInt(4, stockQuantity);
            preparedStatement.setBoolean(5, isAvailable);
            preparedStatement.setInt(6, productId);

            int affectedRows = preparedStatement.executeUpdate();

            // Renvoie true si la mise à jour a réussi, sinon false.
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Fermeture des ressources pour éviter les fuites de connexion.
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (DatabaseConnection.getInstance().getConnection() != null && !DatabaseConnection.getInstance().getConnection().isClosed())
                    DatabaseConnection.getInstance().getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
