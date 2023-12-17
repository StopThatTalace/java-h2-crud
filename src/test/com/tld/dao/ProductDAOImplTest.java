package test.com.tld.dao;
// @Talace
import com.tld.dao.ProductDAO;
import com.tld.dao.ProductDAOImpl;
import com.tld.model.Product;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductDAOImplTest {

    private static ProductDAO productDAO;

    @BeforeAll
    public static void setUp() {
        // Initialisation de l'instance du DAO avant les tests.
        productDAO = new ProductDAOImpl();
    }

    @AfterAll
    public static void tearDown() {
        // Nettoyage des ressources après les tests.
    }

    @Test
    public void testGetProductById() {
        // Test de récupération d'un produit par son identifiant
        Product product = productDAO.getProductById(4);

        assertNotNull(product);
        assertEquals("Skateboard", product.getProductName());
    }

    @Test
    public void testGetAllProducts() {
        // Test de récupération de tous les produits
        List<Product> products = productDAO.getAllProducts();

        assertNotNull(products);
        assertFalse(products.isEmpty());
    }

    @Test
    public void testAddProduct() {
        // Test d'ajout d'un nouveau produit
        Product newProduct = new Product(0, "NewProduct", "Description", 25.99, 10, true, "2023-01-01");
        productDAO.addProduct(newProduct);

        // Vérifie si le produit ajouté peut être récupéré par son nom
        Product retrievedProduct = productDAO.getProductById(newProduct.getId());

        assertNotNull(retrievedProduct);
        assertEquals("NewProduct", retrievedProduct.getProductName());
    }

    @Test
    public void testDeleteProduct() {
        // Test de suppression d'un produit par son identifiant
        int productIdToDelete = 3;
        boolean isDeleted = productDAO.deleteProduct(productIdToDelete);

        assertTrue(isDeleted);

        // Vérifie si le produit a été effectivement supprimé en tentant de le récupérer
        Product deletedProduct = productDAO.getProductById(productIdToDelete);
        assertNull(deletedProduct);
    }

    @Test
    public void testUpdateProduct() {
        // Test de mise à jour des informations d'un produit
        int productIdToUpdate = 3;
        boolean isUpdated = productDAO.updateProduct(productIdToUpdate, "UpdatedProduct", "UpdatedDescription", 19.99, 5, false);

        assertTrue(isUpdated);

        // Vérifie si les informations du produit ont été effectivement mises à jour
        Product updatedProduct = productDAO.getProductById(productIdToUpdate);
        assertNotNull(updatedProduct);
        assertEquals("UpdatedProduct", updatedProduct.getProductName());
        assertEquals("UpdatedDescription", updatedProduct.getDescription());
        assertEquals(19.99, updatedProduct.getPrice());
        assertEquals(5, updatedProduct.getStockQuantity());
        assertFalse(updatedProduct.isAvailable());
    }
}
