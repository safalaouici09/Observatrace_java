import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private static final String URI = "mongodb://localhost:27017"; // Adresse locale par défaut de MongoDB
    private static final String DB_NAME = "productdb"; // Nom de la base de données

    public static MongoDatabase connect() {
        MongoClient client = MongoClients.create(URI);
        return client.getDatabase(DB_NAME);
    }
}
