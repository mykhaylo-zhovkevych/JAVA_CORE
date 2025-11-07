package memento;

public class GameStateMemento {
    private final int health;
    private final int mana;
    private final int gold;

    public GameStateMemento(int health, int mana, int gold) {
        this.health = health;
        this.mana = mana;
        this.gold = gold;
    }

    protected int getHealth() {
        return health;
    }

    protected int getMana() {
        return mana;
    }
    
    protected int getGold() {
        return gold;
    }
}