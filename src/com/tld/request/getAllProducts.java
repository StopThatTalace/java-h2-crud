package com.tld.request;

import com.tld.dao.ProductDAOImpl;
import com.tld.model.Product;

import java.util.List;

// Classe représentant une requête pour récupérer tous les produits.
public class getAllProducts {

    // Méthode principale exécutée lorsqu'on lance cette classe.
    public static void main(String[] args) {
        try {
            // Création d'une instance de ProductDAOImpl pour interagir avec la base de données.
            ProductDAOImpl dao = new ProductDAOImpl();

            // Récupération de la liste de tous les produits.
            List<Product> products = dao.getAllProducts();

            // Vérification si des produits ont été trouvés.
            if (products == null || products.isEmpty()) {
                System.out.println("[!] No products found.");
            } else {
                // Affichage de la liste des produits.
                System.out.println("[+] List of products:");
                for (Product product : products) {
                    System.out.println(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
