package memento;

import java.util.HashMap;
import java.util.Map;

public class SaveGameManager {

    private final Map<String, GameStateMemento> saveSlots = new HashMap<>();

    public void save(String slotName, GameStateMemento memento) {
        saveSlots.put(slotName, memento);
        System.out.printf(slotName);
    }

    public GameStateMemento load(String slotName) {
        return saveSlots.get(slotName);
    }
}