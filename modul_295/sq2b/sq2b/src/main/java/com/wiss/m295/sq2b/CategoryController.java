package com.wiss.m295.sq2b;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class CategoryController {

    public List<Catagories> categories = new ArrayList<>();

    // verbesserte Konstruktor mit veränderbar array
    public CategoryController() {
        List<Questions> matheQuestions = new ArrayList<>(Arrays.asList(
                new Questions(1, "Was ist 2+2?", Arrays.asList("2", "3", "4"), "4"),
                new Questions(2, "Was ist 2+3?", Arrays.asList("2", "3", "5"), "5"),
                new Questions(3, "Was ist 2+4?", Arrays.asList("2", "3", "6"), "6"),
                new Questions(4, "Was ist 2+5?", Arrays.asList("2", "3", "7"), "7"),
                new Questions(5, "Was ist 2+6?", Arrays.asList("2", "3", "8"), "8")
        ));

        categories.add(new Catagories("Mathe", matheQuestions));
    }


    @PostMapping("/check-answer")
    public ResponseEntity<String> checkAnswer(@RequestBody Map<String, String> answerData) {
        // Debugging: Ausgabe der empfangenen Daten
        System.out.println("Empfangene Antwortdaten: " + answerData);

        // Hole die übermittelte Frage-ID und Antwort aus dem Request-Body
        int questionId;
        String givenAnswer;

        try {
            questionId = Integer.parseInt(answerData.get("questionId"));
            givenAnswer = answerData.get("answer");
            // Debugging: Ausgabe der extrahierten Werte
            System.out.println("Frage-ID: " + questionId + ", Gegebene Antwort: " + givenAnswer);
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("Fehler beim Parsen der Anfrage: " + e.getMessage());
            return ResponseEntity.badRequest().body("Ungültige Anfrage");
        }

        // Durchsuche die Kategorien und Fragen
        for (Catagories category : categories) {
            for (Questions question : category.getQuestions()) {
                if (question.getId() == questionId) {
                    // Debugging: Ausgabe, wenn die Frage gefunden wird
                    System.out.println("Frage gefunden: " + question.text);
                    // Überprüfe, ob die gegebene Antwort korrekt ist
                    boolean isCorrect = question.checkAnswer(givenAnswer);
                    System.out.println("Antwort korrekt: " + isCorrect);
                    return ResponseEntity.ok(isCorrect ? "Richtig" : "Falsch");
                }
            }
        }

        // Falls keine Frage gefunden wurde
        System.out.println("Keine Frage mit ID " + questionId + " gefunden.");
        return ResponseEntity.badRequest().body("Frage nicht gefunden");
    }

    // POST-Request zum Hinzufügen einer Frage zu einer Kategorie
    @PostMapping("/category/{name}/question")
    public String addQuestion(@PathVariable String name, @RequestBody Questions question) {
        // Suche die Kategorie nach ihrem Namen
        for (Catagories category : categories) {
        if (category.name.equals(name)) {
            // Frage zur Kategorie hinzufügen
            // Der RequestBody direkt in ein Questions-Objekt gemappt wird
            category.addQuestion(question);
            return "Frage hinzugefügt";
        }
    }
    return "Fehler beim Anfrage";
    }

    // DELETE-Request zum Lösung einer Questions
    @DeleteMapping("/category/{name}/question/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable String name, @PathVariable int id) {
    // Suche die Kategorie mit dem Namen
        for (Catagories category : categories) {
            if (category.name.equals(name)) {
                // Suche die Frage mit der entsprechenden ID in der Kategorie
                List<Questions> questions = category.getQuestions();
                System.out.println(questions);
                for (Questions question : questions) {
                    if (question.getId() == id) {
                        questions.remove(question);
                        return ResponseEntity.ok("Frage mit ID " + id + " wurde gelöscht.");
                    }
                }
                return ResponseEntity.status(404).body("Frage mit ID " + id + " nicht gefunden.");
            }
        }
        return ResponseEntity.status(404).body("Kategorie " + name + " nicht gefunden.");
    }


    // Gibe all Kategorien frei, die Verteilung in fronted wird managt
    @GetMapping("/")
    public List<Catagories> showCategories() {
        // Debugging
        System.out.println("Kategorien werden zurückgegeben: " + categories);
        return categories; // Rückgabe der Liste von Kategorien
    }
}
