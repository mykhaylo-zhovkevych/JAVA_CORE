package memento;

public class Main {
    public static void main(String[] args) {

        GameCharacter hero = new GameCharacter(100, 80, 50);
        SaveGameManager manager = new SaveGameManager();

        manager.save("Start", hero.createSaveGame()); 
     
        hero.fightMonster(); 
        manager.save("After_Fight", hero.createSaveGame());

        hero.castSpell();
        
        GameStateMemento loadedMemento = manager.load("After_Fight");
        
        if (loadedMemento != null) {
            hero.loadSaveGame(loadedMemento);
        }
    }
}