package memento;

public class GameCharacter {
    private int health;
    private int mana;
    private int gold;

    public GameCharacter(int health, int mana, int gold) {
        this.health = health;
        this.mana = mana;
        this.gold = gold;
    
    }

    public void fightMonster() {
        this.health -= 30;
        this.mana -= 15;
        this.gold += 50;
    }
    
    public void castSpell() {
        this.mana -= 40;

    }

    public GameStateMemento createSaveGame() {
        System.out.println("Saves sate ");
        return new GameStateMemento(health, mana, gold);
    }

    public void loadSaveGame(GameStateMemento memento) {
        this.health = memento.getHealth();
        this.mana = memento.getMana();
        this.gold = memento.getGold();
        System.out.println("state saved");
    }


}
