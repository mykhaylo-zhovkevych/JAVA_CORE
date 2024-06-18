package life;


/**
 * Die Klasse LifeCell ist eine konkrete Klasse, die die Attribute des Konstruktors von der Klasse AbstractCell erbt
 * und in dieser Klasse wird eine Methode calculateNextState implementiert und erworbene Attribute aus der Superklassen in Methode eingesetzet.
 * 
 * 
 * @author Mykhaylo Zhovkevych
 * @version 1.0
 */
public class LifeCell extends AbstractCell {

    private boolean nextAlive; // Um den nächsten Zustand zu speichern

    
    /**
     * Konstruktor LifeCell(int x, int y)
     *
     * @param x Die x-Koordinate der Zelle.
     * @param y Die y-Koordinate der Zelle.
     */
    public LifeCell(int x, int y) {
        super(x, y);
        
        /*
		 super refers to the parent class (AbstractCell) constructor
		 super(x, y); explicitly calls the AbstractCell(x, y) constructor
		 The AbstractCell(x, y) constructor receives the arguments x and y from the LifeCell constructor
		 The AbstractCell(x, y) constructor then uses these arguments to initialize its own fields, including x and y
		 The initialization of neighbours and isAlive happens separately within the parent class constructor itself, likely using code outside the super call.
		 */
    }
    
    
    /**
	 * Methode calculateNextState()
	 * 
     * Berechnet den nächsten Zustand der Zelle bassiered auf der Kontrollstruktur
     */
    
    @Override
    public void calculateNextState() {
        int aliveNeighbours = 0;
        for (Cell neighbor : getNeighbours()) {
            if (neighbor.isAlive()) {
                aliveNeighbours++;
            }
        }

        nextAlive = isAlive(); // Standardannahme: bleibt gleich

        if (isAlive() && (aliveNeighbours < 2 || aliveNeighbours > 3)) {
            nextAlive = false; // Stirbt durch Unter- oder Überbevölkerung
        } else if (!isAlive() && aliveNeighbours == 3) {
            nextAlive = true; // Wird lebendig, durch Reproduktion
        }
    }


    @Override
    public void changeState() {
    	
    	isAlive = nextAlive;
        
    } 
}

