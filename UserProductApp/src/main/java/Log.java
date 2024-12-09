public class Log {
    private String timestamp;
    private String event;
    private String user;
    private String action;

    // Constructeur avec paramètres
    public Log(String timestamp, String event, String user, String action) {
        this.timestamp = timestamp;
        this.event = event;
        this.user = user;
        this.action = action;
    }

    // Getters et setters
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    // Méthode pour afficher les informations du log (optionnel)
    @Override
    public String toString() {
        return "Timestamp: " + timestamp + ", Event: " + event + ", User: " + user + ", Action: " + action;
    }
}
