import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser {

    // Méthode pour parser une ligne de log
    public Log parseLogLine(String logLine) {
        // Expression régulière pour extraire les informations
        Pattern pattern = Pattern.compile("Timestamp: (\\S+), Event: (\\S+), User: (\\S+), Action: (\\S+)");
        Matcher matcher = pattern.matcher(logLine);

        // Si la ligne correspond à l'expression régulière
        if (matcher.matches()) {
            // Extraction des informations
            String timestamp = matcher.group(1);
            String event = matcher.group(2);
            String user = matcher.group(3);
            String action = matcher.group(4);

            // Créer et retourner un objet Log avec les données extraites
            return new Log(timestamp, event, user, action);
        } else {
            // Si la ligne ne correspond pas, retourner null
            return null;
        }
    }
}
