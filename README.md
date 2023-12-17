# Projet JAVA à des fins éducatives ⚒️

## Réalisé avec JDBC, JUnit et une base de données H2! 🤖

### 1. Utilisation du Modèle de Conception DAO
Le modèle DAO (Data Access Object) fournit une interface abstraite à certains types de bases de données ou d'autres mécanismes de stockage. Il sépare la logique métier de l'accès aux données, facilitant ainsi la gestion et la manipulation des données. La classe `ProductDAOImpl` dans notre projet représente une implémentation concrète de ce modèle, permettant d'interagir avec une base de données relationnelle pour effectuer des opérations de lecture et d'écriture liées aux produits.

### 2. Utilisation de JUnit5 pour les Tests de Requêtes à la Base de Données
JUnit5 est un framework de test pour Java facilitant la création et l'exécution de tests unitaires. Dans votre projet, les tests unitaires sont réalisés avec JUnit5 pour s'assurer du bon fonctionnement des méthodes implémentées dans la classe `ProductDAOImpl`. Ces tests garantissent le bon déroulement des opérations sur la base de données, telles que l'ajout, la récupération, la mise à jour et la suppression de produits.

### 3. Définition de la Classe Modèle
La classe modèle (`Product`) définit la structure d'un produit avec des attributs tels que l'identifiant, le nom, la description, le prix, la quantité en stock, la disponibilité et la date de création. Cette classe est utilisée pour représenter les produits dans le contexte d'une application de gestion d'articles, par exemple.

### 4. Scripts de Configuration de la Base de Données
Les scripts mentionnés dans le projet sont probablement des scripts SQL contenant les requêtes nécessaires pour créer les tables et effectuer d'autres opérations sur la base de données H2. Ces scripts sont essentiels pour initialiser et configurer la base de données utilisée dans votre projet.