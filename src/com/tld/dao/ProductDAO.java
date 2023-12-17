/*
L'interface `ProductDAO` définit un contrat pour les opérations de gestion des produits, en suivant le modèle CRUD.
Chaque méthode dans cette interface représente une opération spécifique sur les données des produits, telles que la récupération par identifiant,
la récupération de tous les produits, l'ajout d'un nouveau produit, la suppression par identifiant, et la mise à jour des informations d'un produit existant.

En définissant cette interface, elle offre une abstraction permettant aux implémentations concrètes, telles que `ProductDAOImpl`,
d'interagir avec diverses sources de données, comme une base de données, sans exposer les détails de mise en œuvre à l'utilisateur du DAO.
Cela favorise la modularité et la flexibilité du code, permettant de changer facilement l'implémentation sous-jacente sans modifier le code client.
@Talace
*/

package com.tld.dao;

import com.tld.model.Product;

import java.util.List;

// Interface décrivant les opérations CRUD (Create, Read, Update, Delete) pour les produits.
public interface ProductDAO {

    // Récupère un produit par son identifiant.
    Product getProductById(int id);

    // Récupère tous les produits disponibles.
    List<Product> getAllProducts();

    // Ajoute un nouveau produit à la base de données.
    void addProduct(Product product);

    // Supprime un produit par son identifiant et renvoie true si la suppression est réussie.
    boolean deleteProduct(int id);

    // Met à jour les informations d'un produit et renvoie true si la mise à jour est réussie.
    boolean updateProduct(int productId, String productName, String description, double price, int stockQuantity, boolean isAvailable);
}
