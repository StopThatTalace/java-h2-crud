package com.tld.request;

import com.tld.dao.ProductDAO;
import com.tld.dao.ProductDAOImpl;
import com.tld.model.Product;

import java.util.Scanner;

// Classe représentant une requête pour récupérer un produit par son identifiant.
public class getProductById {

    // Méthode principale exécutée lorsqu'on lance cette classe.
    public static void main(String[] args) {
        // Création d'une instance de ProductDAO pour interagir avec la base de données.
        ProductDAO dao = new ProductDAOImpl();

        // Création d'une instance de Scanner pour lire l'entrée de l'utilisateur.
        Scanner key = new Scanner(System.in);

        // Demande à l'utilisateur d'entrer l'identifiant du produit à récupérer.
        System.out.print("[+] Enter the product ID to retrieve: ");
        int keyId = key.nextInt();

        // Récupération du produit par son identifiant.
        Product product = dao.getProductById(keyId);

        // Vérification si le produit a été trouvé.
        if (product == null) {
            System.out.println("[-] No product found for this ID!");
        } else {
            // Affichage des informations du produit.
            System.out.println("[+] Information about the product with ID " + keyId + ":");
            System.out.println(product.toString());
        }

        // Fermeture du scanner pour éviter les fuites de ressources.
        key.close();
    }
}
