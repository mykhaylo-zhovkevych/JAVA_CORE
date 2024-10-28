import java.util.regex.*;

public class RegexExample {
    public static void main(String[] args) {
        String text = "Ich liebe Programmieren!";
      
        String pattern = "Programmieren";

        // Pattern erstellen und matcher instanziieren
        Pattern compiledPattern = Pattern.compile(pattern);
      
        Matcher matcher = compiledPattern.matcher(text);

        // Prüfen, ob das Muster gefunden wurde
        if (matcher.find()) {
            System.out.println("Muster gefunden!");
        } else {
            System.out.println("Muster nicht gefunden.");
        }
    }
}
