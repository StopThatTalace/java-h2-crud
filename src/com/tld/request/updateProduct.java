package com.tld.request;

import com.tld.dao.ProductDAOImpl;
import com.tld.model.Product;

import java.util.Scanner;

// Classe représentant une requête pour mettre à jour un produit.
public class updateProduct {

    // Méthode principale exécutée lorsqu'on lance cette classe.
    public static void main(String[] args) {
        // Création d'une instance de Scanner pour lire l'entrée de l'utilisateur.
        Scanner scanner = new Scanner(System.in);

        // Demande à l'utilisateur d'entrer l'identifiant du produit à mettre à jour.
        System.out.print("Enter the ID of the product you want to update: ");
        int productId = scanner.nextInt();

        // Création d'une instance de ProductDAOImpl pour interagir avec la base de données.
        ProductDAOImpl dao = new ProductDAOImpl();

        // Récupération du produit à mettre à jour par son identifiant.
        Product productToUpdate = dao.getProductById(productId);

        // Vérification si le produit à mettre à jour a été trouvé.
        if (productToUpdate != null) {
            System.out.println("You are about to update the following product:");
            System.out.println("----------------------------------------");
            System.out.println(productToUpdate);

            System.out.println("-----------------------------------------");
            System.out.println("Which information do you want to modify?");
            System.out.println("1. Product Name");
            System.out.println("2. Product Description");
            System.out.println("3. Product Price");
            System.out.println("4. Product Stock Quantity");
            System.out.println("5. Product Availability");
            System.out.println("6. Update All");

            System.out.print("Enter your choice (1-6): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            // Initialisation des variables pour les informations mises à jour.
            String updatedProductName = productToUpdate.getProductName();
            String updatedDescription = productToUpdate.getDescription();
            double updatedPrice = productToUpdate.getPrice();
            int updatedStockQuantity = productToUpdate.getStockQuantity();
            boolean updatedAvailability = productToUpdate.isAvailable();

            switch (choice) {
                case 1:
                    System.out.print("Enter the updated Product Name: ");
                    updatedProductName = scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Enter the updated Product Description: ");
                    updatedDescription = scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Enter the updated Product Price: ");
                    updatedPrice = scanner.nextDouble();
                    break;
                case 4:
                    System.out.print("Enter the updated Product Stock Quantity: ");
                    updatedStockQuantity = scanner.nextInt();
                    break;
                case 5:
                    System.out.print("Is the product available? (true/false): ");
                    updatedAvailability = scanner.nextBoolean();
                    break;
                case 6:
                    // Mise à jour de toutes les informations du produit.
                    System.out.print("Enter the updated Product Name: ");
                    updatedProductName = scanner.nextLine();

                    System.out.print("Enter the updated Product Description: ");
                    updatedDescription = scanner.nextLine();

                    System.out.print("Enter the updated Product Price: ");
                    updatedPrice = scanner.nextDouble();

                    System.out.print("Enter the updated Product Stock Quantity: ");
                    updatedStockQuantity = scanner.nextInt();

                    System.out.print("Is the product available? (true/false): ");
                    updatedAvailability = scanner.nextBoolean();
                    break;
                default:
                    System.out.println("Invalid choice. No updates will be made.");
                    break;
            }

            // Affichage des informations mises à jour.
            System.out.println("Updated information:");
            System.out.println("Product Name: " + updatedProductName);
            System.out.println("Product Description: " + updatedDescription);
            System.out.println("Product Price: " + updatedPrice);
            System.out.println("Product Stock Quantity: " + updatedStockQuantity);
            System.out.println("Product Availability: " + updatedAvailability);

            System.out.print("[?] Do you want to apply these updates? (y/n): ");
            String confirmation = scanner.nextLine().toLowerCase();

            if (confirmation.equals("y")) {
                // Mise à jour du produit et affichage d'un message approprié.
                boolean updated = dao.updateProduct(productId, updatedProductName, updatedDescription, updatedPrice, updatedStockQuantity, updatedAvailability);

                if (updated) {
                    System.out.println("[+] Product with ID " + productId + " updated successfully!");
                } else {
                    System.out.println("[-] Product with ID " + productId + " could not be updated.");
                }
            } else {
                System.out.println("[-] Update canceled. The product was not modified.");
            }
        } else {
            System.out.println("[-] Product with ID " + productId + " not found.");
        }

        // Fermeture du scanner pour éviter les fuites de ressources.
        scanner.close();
    }
}
