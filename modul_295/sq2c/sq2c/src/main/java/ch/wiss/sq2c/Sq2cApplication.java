package ch.wiss.sq2c;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@SpringBootApplication
public class Sq2cApplication {

	private ArrayList<String> categories = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(Sq2cApplication.class, args);
	}



	@GetMapping("/")
	public String index() {
		return "Hello from Spring Boot!";
	}

	@PostMapping("/category")
	public String addCategory(@RequestParam String category) {
		categories.add(category); // Fügt die Kategorie zur Liste hinzu
		return "saved";
	}

	@GetMapping("/categories")
	/*
	* @ResponseBody: Diese Annotation stellt sicher, dass der Rückgabewert der Methode (in diesem Fall ein Iterable<String>)
	* direkt als HTTP-Response an den Client geschickt wird.
	* Es wird keine HTML-Seite gerendert, sondern der Inhalt der categories-Liste
	* (meist als JSON-Format) direkt zurückgesendet
	* */
	public @ResponseBody Iterable<String> getCategories() {
		return categories; // Gibt die Liste der Kategorien zurück
	}

	@DeleteMapping("/category")
	// @RequestParam ist eine Annotation, die verwendet wird, um Daten aus der URL oder dem Body einer Anfrage zu extrahieren und diese Daten als Parameter in die Methode zu übernehmen.
	// POST- oder DELETE-Requests übergib ich beispielsweise den Namen einer Kategorie, und dieser wird dann in der Methode verarbeitet.
	public String removeCategory(@RequestParam String category) {
		if (categories.contains(category)) {
			categories.remove(category);
			return "Category '" + category + "' removed.";
		} else {
			return "Category '" + category + "' not found.";
		}

	}

	/*
	@RestController
	public class UserController {

    @Autowired
    private UserServices services;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(services.getUserList());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return ResponseEntity.ok().body(this.services.getUserById(id));
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(this.services.createUser(user));
    }

    @DeleteMapping("/deleteUsers/{id}")
    public HttpStatus deleteUser(@PathVariable int id) {
        this.services.deleteUserById(id);
        return HttpStatus.OK;
    	}
	}
	Antworten sind in OneNote
	*/


}
