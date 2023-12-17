package com.tld;

import java.sql.SQLException;
import java.util.Scanner;

import com.tld.dao.ProductDAOImpl;
import com.tld.model.Product;

// Classe principale de l'application.
public class MainApp {

    // Méthode principale exécutée lorsqu'on lance l'application.
    public static void main(String[] args) throws SQLException {
        // Création d'une instance de Scanner pour lire l'entrée de l'utilisateur.
        Scanner key = new Scanner(System.in);
        System.out.println("[+] Lancement du script de connexion");

        // Déclaration d'un objet de type Product (peut être utilisé pour stocker des données de produit).
        Product product = null;

        // Création d'une instance de ProductDAOImpl pour interagir avec la base de données.
        ProductDAOImpl dao = new ProductDAOImpl();
    }
}
