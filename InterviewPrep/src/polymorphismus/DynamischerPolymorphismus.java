package polymorphismus;



class Tier {

	public void machenGeräusch() {
		System.out.println("Ein Tier machen eine Geräusch.");
		
	}
	
}

//Unterklasse 1
class Hund extends Tier {
	 @Override
	    public void machenGeräusch() {
	        System.out.println("Wuff! Wuff!");
	    }
}


//Unterklasse 2
class Katze extends Tier {
 @Override
 public void machenGeräusch() {
     System.out.println("Miau! Miau!");
 }
}

//Unterklasse 3
class Kuh extends Tier {
 @Override
 public void machenGeräusch() {
     System.out.println("Muh! Muh!");
 }
}


public class DynamischerPolymorphismus {
	

    public static void main(String[] args) {
    		
    	Tier meinTier;
    	
    	meinTier = new Hund();
    	meinTier.machenGeräusch(); // Ausgabe: Wuff! Wuff!
    
    	meinTier = new Katze();
        meinTier.machenGeräusch(); // Ausgabe: Miau! Miau!
        
        meinTier = new Kuh();
        meinTier.machenGeräusch(); // Ausgabe: Muh! Muh!

        // Oder alternativ:
        Tier[] tiere = {new Hund(), new Katze(), new Kuh()};
        for (Tier tier : tiere) {
            tier.machenGeräusch();
        }
        // Ausgabe:
        // Wuff! Wuff!
        // Miau! Miau!
        // Muh! Muh!
        
    }
	
	
	
}
