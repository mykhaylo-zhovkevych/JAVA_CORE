package brocode.generics;

public class GenerMethods {
    public static void main(String args[] ) {

        Player player = new Player();
        Enemy enemy  = new Enemy();
        Item item = new Item(); 
        Tree tree = new Tree();

        draw(player);
        draw(enemy);
        draw(item);
        draw(tree);
        
    }

    // Generic draw method constrained to Drawable types
    public static <T extends Drawable> void draw(T x) {
        x.draw();
    }
}

// Define the Drawable interface
interface Drawable {
    void draw();
}

// Implement Drawable in Player class
class Player implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a player");
    }
}

// Implement Drawable in Enemy class
class Enemy implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing an enemy");
    }
}

// Implement Drawable in Item class
class Item implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing an item");
    }
}

// Implement Drawable in Tree class
class Tree implements Drawable {
    @Override
    public void draw() {
        System.out.println("Drawing a tree");
    }
}

