package com.tld.request;

import com.tld.dao.ProductDAOImpl;
import com.tld.model.Product;

import java.util.Scanner;

// Classe représentant une requête pour ajouter un nouveau produit.
public class addProduct {

    // Méthode principale exécutée lorsqu'on lance cette classe.
    public static void main(String[] args) {
        // Création d'une instance de Scanner pour lire l'entrée de l'utilisateur.
        Scanner scanner = new Scanner(System.in);

        System.out.println("[?] Enter the following information to add a new product:");

        // Demande à l'utilisateur d'entrer les informations du nouveau produit.
        System.out.print("[+] Enter the product name: ");
        String productName = scanner.nextLine();

        System.out.print("[+] Enter the product description: ");
        String description = scanner.nextLine();

        System.out.print("[+] Enter the product price: ");
        double price = scanner.nextDouble();

        System.out.print("[+] Enter the product stock quantity: ");
        int stockQuantity = scanner.nextInt();

        System.out.print("[+] Is the product available? (true/false): ");
        boolean isAvailable = scanner.nextBoolean();

        // Création d'une instance de ProductDAOImpl pour interagir avec la base de données.
        ProductDAOImpl dao = new ProductDAOImpl();

        // Création d'une instance de Product avec les informations fournies par l'utilisateur.
        Product product = new Product(null, productName, description, price, stockQuantity, isAvailable, null);

        // Ajout du produit à la base de données.
        dao.addProduct(product);

        System.out.println("[+] Product added successfully!");

        // Fermeture du scanner pour éviter les fuites de ressources.
        scanner.close();
    }
}
