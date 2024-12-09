import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class UserRepository {
    private MongoDatabase database;

    public UserRepository() {
        database = MongoDBConnection.connect();  // Utilisation de la connexion à MongoDB
    }

    // Ajouter un utilisateur
    public void addUser(User user) {
        MongoCollection<Document> collection = database.getCollection("users");

        Document document = new Document("id", user.getId())
                .append("name", user.getName())
                .append("age", user.getAge())  // Correction ici, utiliser getAge() pour l'âge
                .append("email", user.getEmail())
                .append("password", user.getPassword());

        collection.insertOne(document);
        System.out.println("Utilisateur ajouté avec succès.");
    }

    // Afficher les utilisateurs
    public void displayUsers() {
        MongoCollection<Document> collection = database.getCollection("users");
        for (Document doc : collection.find()) {
            String id = doc.getString("id");
            String name = doc.getString("name");
            int age = doc.getInteger("age");
            String email = doc.getString("email");
            System.out.println("ID: " + id + ", Nom: " + name + ", Âge: " + age + ", Email: " + email);
        }
    }

    // Récupérer un utilisateur par ID
    public User getUserById(String id) {
        MongoCollection<Document> collection = database.getCollection("users");
        Document doc = collection.find(new Document("id", id)).first();
        if (doc != null) {
            String name = doc.getString("name");
            int age = doc.getInteger("age");
            String email = doc.getString("email");
            String password = doc.getString("password");
            return new User(id, name, age, email, password);
        }
        return null;  // Utilisateur non trouvé
    }

    // Supprimer un utilisateur par ID
    public void deleteUserById(String id) {
        MongoCollection<Document> collection = database.getCollection("users");
        collection.deleteOne(new Document("id", id));
        System.out.println("Utilisateur supprimé avec succès.");
    }
}
