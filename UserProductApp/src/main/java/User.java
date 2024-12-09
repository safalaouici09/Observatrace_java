import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;  // ID unique pour l'utilisateur
    private String name;
    private int age;
    private String email;
    private String password;
    private List<String> actions; // Liste des scénarios/actions

    // Constructeur
    public User(String id, String name, int age, String email, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.actions = new ArrayList<>();
    }

    // Getters et Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<String> getActions() {
        return actions;
    }

    public void addAction(String action) {
        this.actions.add(action);
    }

    // Méthode pour convertir un objet User en Document MongoDB
    public Document toDocument() {
        return new Document("_id", id)
                .append("name", name)
                .append("age", age)
                .append("email", email)
                .append("password", password)
                .append("actions", actions);
    }

    // Méthode pour convertir un Document MongoDB en objet User
    public static User fromDocument(Document doc) {
        User user = new User(
                doc.getString("_id"),
                doc.getString("name"),
                doc.getInteger("age"),
                doc.getString("email"),
                doc.getString("password")
        );
        user.actions = (List<String>) doc.get("actions");
        return user;
    }
}
