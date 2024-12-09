import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialisation des services
        ProductRepository productRepository = new ProductRepository();
        ProfileService profileService = new ProfileService();
        Scanner scanner = new Scanner(System.in);

        // Charger les profils utilisateur
        profileService.loadProfiles();
        List<UserProfile> users = profileService.getProfiles();

        // Étape 1 : Exécution des scénarios divers pour chaque utilisateur
        for (UserProfile user : users) {
            System.out.println("Exécution des scénarios pour : " + user.getName());
            user.addAction("viewed product with ID 1");
            user.addAction("added product with ID 2");
            user.addAction("deleted product with ID 3");
            profileService.saveProfile(user);
        }

        // Menu pour tester les fonctionnalités
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Afficher tous les produits");
            System.out.println("2. Récupérer un produit par ID");
            System.out.println("3. Ajouter un nouveau produit");
            System.out.println("4. Supprimer un produit par ID");
            System.out.println("5. Mettre à jour un produit");
            System.out.println("6. Afficher tous les profils utilisateur");
            System.out.println("7. Ajouter une action à un utilisateur");
            System.out.println("8. Quitter");

            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Pour gérer l’entrée de ligne

            try {
                switch (choix) {
                    case 1:
                        productRepository.displayProducts();
                        break;

                    case 2:
                        System.out.print("Entrez l'ID du produit : ");
                        String fetchId = scanner.nextLine();
                        Product product = productRepository.fetchProductById(fetchId);
                        if (product != null) {
                            System.out.println("Produit trouvé : " + product.getName() + ", Prix : " + product.getPrice());
                        } else {
                            System.out.println("Produit non trouvé.");
                        }
                        break;

                    case 3:
                        System.out.print("Entrez l'ID du produit : ");
                        String id = scanner.nextLine();
                        System.out.print("Entrez le nom du produit : ");
                        String name = scanner.nextLine();

                        double price = 0;
                        boolean validPrice = false;
                        while (!validPrice) {
                            System.out.print("Entrez le prix du produit : ");
                            if (scanner.hasNextDouble()) {
                                price = scanner.nextDouble();
                                validPrice = true;
                            } else {
                                System.out.println("Erreur : Veuillez entrer un prix valide.");
                                scanner.nextLine(); // Consommer l'entrée incorrecte
                            }
                        }
                        scanner.nextLine(); // Pour gérer l’entrée de ligne

                        System.out.print("Entrez la date d'expiration (format: yyyy-MM-dd) : ");
                        String expirationDateStr = scanner.nextLine();
                        try {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            Date expirationDate = dateFormat.parse(expirationDateStr);
                            Product newProduct = new Product(id, name, price, expirationDate);
                            productRepository.addProduct(newProduct);
                            System.out.println("Produit ajouté avec succès.");
                        } catch (Exception e) {
                            System.out.println("Erreur de format de date : " + e.getMessage());
                        }
                        break;

                    case 4:
                        System.out.print("Entrez l'ID du produit à supprimer : ");
                        String deleteId = scanner.nextLine();
                        productRepository.deleteProductById(deleteId);
                        break;

                    case 5:
                        System.out.print("Entrez l'ID du produit à mettre à jour : ");
                        String updateId = scanner.nextLine();
                        System.out.print("Entrez le nouveau nom du produit : ");
                        String newName = scanner.nextLine();

                        double newPrice = 0;
                        validPrice = false;
                        while (!validPrice) {
                            System.out.print("Entrez le nouveau prix du produit : ");
                            if (scanner.hasNextDouble()) {
                                newPrice = scanner.nextDouble();
                                validPrice = true;
                            } else {
                                System.out.println("Erreur : Veuillez entrer un prix valide.");
                                scanner.nextLine(); // Consommer l'entrée incorrecte
                            }
                        }
                        scanner.nextLine(); // Pour gérer l’entrée de ligne

                        System.out.print("Entrez la nouvelle date d'expiration (format: yyyy-MM-dd) : ");
                        String newExpirationDateStr = scanner.nextLine();
                        try {
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            Date newExpirationDate = dateFormat.parse(newExpirationDateStr);
                            productRepository.updateProduct(updateId, newName, newPrice, newExpirationDate);
                        } catch (Exception e) {
                            System.out.println("Erreur de format de date : " + e.getMessage());
                        }
                        break;

                    case 6:
                        // Afficher les profils des utilisateurs
                        System.out.println("Profils utilisateur :");
                        for (UserProfile userProfile : users) {
                            System.out.println("ID : " + userProfile.getUserId());
                            System.out.println("Nom : " + userProfile.getName());
                            System.out.println("Rôle : " + userProfile.getRole());
                            System.out.println("Actions : " + String.join(", ", userProfile.getActions()));
                            System.out.println("---------------------------");
                        }
                        break;

                    case 7:
                        // Ajouter une action à un utilisateur
                        System.out.print("Entrez l'ID de l'utilisateur : ");
                        String userId = scanner.nextLine();
                        UserProfile userProfile = profileService.getProfileById(userId);
                        if (userProfile != null) {
                            System.out.print("Entrez l'action à ajouter : ");
                            String action = scanner.nextLine();
                            userProfile.addAction(action);
                            System.out.println("Action ajoutée avec succès.");
                        } else {
                            System.out.println("Utilisateur non trouvé.");
                        }
                        break;

                    case 8:
                        System.out.println("Fermeture de l’application.");
                        scanner.close();
                        return; // La fermeture de l'application se produit ici

                    default:
                        System.out.println("Option invalide.");
                }
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }
}
