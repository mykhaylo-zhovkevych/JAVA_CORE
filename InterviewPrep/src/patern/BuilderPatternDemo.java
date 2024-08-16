package patern;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        // Building a simple house without a garage or garden
        House simpleHouse = new House.Builder()
                                .buildFoundation("Concrete")
                                .buildStructure("Wood")
                                .buildRoof("Shingles")
                                .buildGarage(false)
                                .buildGarden(false)
                                .build();
        System.out.println(simpleHouse);

        // Building a luxury house with a garage and a garden
        House luxuryHouse = new House.Builder()
                                .buildFoundation("Concrete and Steel")
                                .buildStructure("Brick")
                                .buildRoof("Tiles")
                                .buildGarage(true)
                                .buildGarden(true)
                                .build();
        System.out.println(luxuryHouse);
    }
}
