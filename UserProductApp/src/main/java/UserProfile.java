import java.util.ArrayList;
import java.util.List;

public class UserProfile {
    private String userId;
    private String name;
    private String role;
    private List<String> actions;

    // Constructeur
    public UserProfile(String userId, String name, String role, List<String> actions) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        // Si la liste des actions est nulle, on initialise une liste vide
        this.actions = actions != null ? actions : new ArrayList<>();
    }

    // Getters et setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions != null ? actions : new ArrayList<>();
    }

    // Méthode pour ajouter une action
    public void addAction(String action) {
        if (action != null && !action.isEmpty()) {
            actions.add(action);
            System.out.println("Action ajoutée : " + action);
        } else {
            System.out.println("Action invalide. Elle ne peut pas être vide.");
        }
    }

    // Méthode pour afficher toutes les actions de l'utilisateur
    public void displayActions() {
        System.out.println("Actions pour " + name + " :");
        for (String action : actions) {
            System.out.println("- " + action);
        }
    }
}
