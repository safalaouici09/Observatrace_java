import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ProductRepository {
    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class); // Initialisation du logger
    private List<Product> products;
    private static final String FILE_PATH = "products.json";
    private final Gson gson;

    public ProductRepository() {
        this.gson = new Gson();
        this.products = loadProductsFromFile();
        logger.info("ProductRepository initialisé avec succès.");
    }

    // Ajouter un produit à la liste (et sauvegarder)
    public void addProduct(Product product) {
        products.add(product);
        saveProductsToFile();
        logger.info("Produit ajouté: ID = {}, Nom = {}", product.getId(), product.getName());
    }

    // Afficher tous les produits
    public void displayProducts() {
        if (products.isEmpty()) {
            logger.info("Aucun produit disponible.");
            System.out.println("Aucun produit disponible.");
        } else {
            for (Product product : products) {
                System.out.println("ID: " + product.getId() + ", Nom: " + product.getName() +
                        ", Prix: " + product.getPrice() + ", Date d'expiration: " + product.getExpirationDate());
                logger.info("Produit affiché: ID = {}, Nom = {}", product.getId(), product.getName());
            }
        }
    }

    // Récupérer un produit par son ID
    public Product fetchProductById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                logger.info("Produit récupéré: ID = {}", id);
                return product;
            }
        }
        logger.warn("Produit avec l'ID {} non trouvé.", id);
        return null;
    }

    // Supprimer un produit par son ID
    public void deleteProductById(String id) {
        Product productToRemove = null;
        for (Product product : products) {
            if (product.getId().equals(id)) {
                productToRemove = product;
                break;
            }
        }

        if (productToRemove != null) {
            products.remove(productToRemove);
            saveProductsToFile();
            logger.info("Produit supprimé avec succès: ID = {}", id);
            System.out.println("Produit avec ID " + id + " supprimé.");
        } else {
            logger.warn("Produit avec l'ID {} non trouvé lors de la suppression.", id);
            System.out.println("Produit avec l'ID " + id + " non trouvé.");
        }
    }

    // Mettre à jour un produit existant
    public void updateProduct(String id, String newName, double newPrice, java.util.Date newExpirationDate) {
        Product productToUpdate = fetchProductById(id);
        if (productToUpdate != null) {
            productToUpdate.setName(newName);
            productToUpdate.setPrice(newPrice);
            productToUpdate.setExpirationDate(newExpirationDate);
            saveProductsToFile();
            logger.info("Produit mis à jour avec succès: ID = {}", id);
            System.out.println("Produit mis à jour avec succès.");
        } else {
            logger.warn("Produit avec l'ID {} non trouvé lors de la mise à jour.", id);
            System.out.println("Produit avec l'ID " + id + " non trouvé.");
        }
    }

    // Charger les produits depuis le fichier JSON
    private List<Product> loadProductsFromFile() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type productListType = new TypeToken<ArrayList<Product>>() {}.getType();
            List<Product> loadedProducts = gson.fromJson(reader, productListType);
            logger.info("Produits chargés depuis le fichier.");
            return loadedProducts;
        } catch (FileNotFoundException e) {
            logger.warn("Le fichier des produits n'a pas été trouvé, création d'une nouvelle liste vide.");
            return new ArrayList<>();
        } catch (IOException e) {
            logger.error("Erreur lors du chargement des produits depuis le fichier.", e);
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Sauvegarder les produits dans le fichier JSON
    private void saveProductsToFile() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(products, writer);
            logger.info("Produits sauvegardés dans le fichier.");
        } catch (IOException e) {
            logger.error("Erreur lors de la sauvegarde des produits dans le fichier.", e);
            e.printStackTrace();
        }
    }
}
