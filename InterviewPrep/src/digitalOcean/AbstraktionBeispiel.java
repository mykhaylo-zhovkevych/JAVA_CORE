package digitalOcean;

abstract class Tier {
    private String name;

    public Tier(String name) {
        this.name = name;
    }

    public abstract void machenGeräusch(); // Abstrakte Methode

    public void bewegen() {
        System.out.println(name + " bewegt sich.");
    }
}

class Hund extends Vererbung {
    public Hund(String name) {
        super(name);
    }

   
    public void machenGeräusch() {
        System.out.println("Wuff!");
    }
}

class Katze extends Vererbung {
    public Katze(String name) {
        super(name);
    }

   
    public void machenGeräusch() {
        System.out.println("Miau!");
    }
}

public class AbstraktionBeispiel {
    public static void main(String[] args) {
        Hund hund = new Hund("Bello");
        Katze katze = new Katze("Mimi");

        hund.machenGeräusch();
        katze.machenGeräusch();
        hund.bewegen();
        katze.bewegen();
    }
}
