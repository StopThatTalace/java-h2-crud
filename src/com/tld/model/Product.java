/*
Cette classe définit la structure d'un produit avec ses attributs tels que l'identifiant, le nom,
la description, le prix, la quantité en stock, la disponibilité et la date de création.
Les méthodes getters et setters permettent d'accéder et de modifier ces attributs, et
la méthode toString génère une représentation textuelle de l'objet Product.
Cette classe est utilisée pour représenter les produits dans le contexte d'une application de gestion de magasin, par exemple.
@Talace
*/

package com.tld.model;

// La classe représente un produit avec ses attributs et méthodes associées.
public class Product {

    // Attributs privés représentant les caractéristiques d'un produit.
    private Integer id;
    private String productName;
    private String description;
    private double price;
    private int stockQuantity;
    private boolean isAvailable;
    private String creationDate;

    // Constructeur par défaut.
    public Product() {
        // Laissez vide pour permettre une initialisation par défaut.
    }

    // Constructeur avec des paramètres pour initialiser toutes les propriétés du produit.
    public Product(Integer id, String productName, String description, double price, int stockQuantity, boolean isAvailable, String creationDate) {
        super();
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.isAvailable = isAvailable;
        this.creationDate = creationDate;
    }

    // Getters et setters pour accéder et modifier les attributs du produit.
    // Chaque attribut a ses propres méthodes d'accès et de modification.

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    // Méthode toString pour afficher une représentation textuelle de l'objet Product.
    @Override
    public String toString() {
        return "Product [id=" + id + ", productName=" + productName + ", description=" + description + ", price=" + price
                + ", stockQuantity=" + stockQuantity + ", isAvailable=" + isAvailable + ", creationDate=" + creationDate + "]";
    }
}
