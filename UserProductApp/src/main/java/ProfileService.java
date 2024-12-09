import java.util.ArrayList;
import java.util.List;

public class ProfileService {

    private List<UserProfile> profiles;

    public ProfileService() {
        this.profiles = new ArrayList<>();
    }

    // Simuler le chargement des profils à partir d'un fichier ou d'une source externe
    public void loadProfiles() {
        // Exemple de chargement de profils fictifs
        profiles.add(new UserProfile("user1", "Sarah", "read", new ArrayList<>()));
        profiles.add(new UserProfile("user2", "Safa", "write", new ArrayList<>()));
        profiles.add(new UserProfile("user3", "Sohaib", "read", new ArrayList<>()));
        profiles.add(new UserProfile("user4", "Bilel", "write", new ArrayList<>()));
        profiles.add(new UserProfile("user5", "Malek", "read", new ArrayList<>()));
        profiles.add(new UserProfile("user6", "Merieme", "write", new ArrayList<>()));
        profiles.add(new UserProfile("user7", "Muhammed", "read", new ArrayList<>()));
        profiles.add(new UserProfile("user8", "Yassine", "write", new ArrayList<>()));
        profiles.add(new UserProfile("user9", "Ikrame", "read", new ArrayList<>()));
        profiles.add(new UserProfile("user10", "Rida", "write", new ArrayList<>()));
    }

    // Mettre à jour un profil avec une nouvelle action
    public void updateProfile(UserProfile user, String action) {
        user.getActions().add(action);
    }

    // Sauvegarder un profil (par exemple, dans un fichier)
    public void saveProfile(UserProfile user) {
        // Exemple de sauvegarde d'un profil
        System.out.println("Profil de " + user.getName() + " sauvegardé.");
    }

    // Accéder à la liste des profils
    public List<UserProfile> getProfiles() {
        return profiles;
    }

	public UserProfile getProfileById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
