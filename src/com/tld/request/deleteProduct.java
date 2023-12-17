package com.tld.request;

import com.tld.dao.ProductDAOImpl;
import com.tld.model.Product;

import java.util.Scanner;

// Classe représentant une requête pour supprimer un produit.
public class deleteProduct {

    // Méthode principale exécutée lorsqu'on lance cette classe.
    public static void main(String[] args) {
        // Création d'une instance de Scanner pour lire l'entrée de l'utilisateur.
        Scanner scanner = new Scanner(System.in);

        // Demande à l'utilisateur d'entrer l'identifiant du produit à supprimer.
        System.out.print("[?] Enter the ID of the product you want to delete: ");
        int productId = scanner.nextInt();

        // Création d'une instance de ProductDAOImpl pour interagir avec la base de données.
        ProductDAOImpl dao = new ProductDAOImpl();

        // Récupération du produit à supprimer par son identifiant.
        Product productToDelete = dao.getProductById(productId);

        // Vérification si le produit à supprimer a été trouvé.
        if (productToDelete != null) {
            System.out.println("[i] You are about to delete the following product:");
            System.out.println(productToDelete);

            // Demande de confirmation pour la suppression.
            System.out.print("[?] Are you sure you want to delete this product? (y/n): ");
            String confirmation = scanner.next().toLowerCase();

            if (confirmation.equals("y")) {
                // Suppression du produit et affichage d'un message approprié.
                boolean deleted = dao.deleteProduct(productId);

                if (deleted) {
                    System.out.println("[+] Product with ID " + productId + " deleted successfully!");
                } else {
                    System.out.println("[!] Product with ID " + productId + " could not be deleted.");
                }
            } else {
                System.out.println("[-] Deletion canceled. The product was not deleted.");
            }
        } else {
            System.out.println("[!] Product with ID " + productId + " not found.");
        }

        // Fermeture du scanner pour éviter les fuites de ressources.
        scanner.close();
    }
}
