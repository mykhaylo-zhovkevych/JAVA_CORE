package patern;

public class House {
    private String foundation;
    private String structure;
    private String roof;
    private boolean hasGarage;
    private boolean hasGarden;

    // Private constructor to prevent direct instantiation
    private House() {}

    // Getters for the fields (optional, for demonstration)
    public String getFoundation() {
        return foundation;
    }

    public String getStructure() {
        return structure;
    }

    public String getRoof() {
        return roof;
    }

    public boolean hasGarage() {
        return hasGarage;
    }

    public boolean hasGarden() {
        return hasGarden;
    }

    @Override
    public String toString() {
        return "House [foundation=" + foundation + ", structure=" + structure + 
               ", roof=" + roof + ", hasGarage=" + hasGarage + ", hasGarden=" + hasGarden + "]";
    }

    // Builder static inner class
    public static class Builder {
        private House house;

        public Builder() {
            this.house = new House();
        }

        public Builder buildFoundation(String foundation) {
            house.foundation = foundation;
            return this;
        }

        public Builder buildStructure(String structure) {
            house.structure = structure;
            return this;
        }

        public Builder buildRoof(String roof) {
            house.roof = roof;
            return this;
        }

        public Builder buildGarage(boolean hasGarage) {
            house.hasGarage = hasGarage;
            return this;
        }

        public Builder buildGarden(boolean hasGarden) {
            house.hasGarden = hasGarden;
            return this;
        }

        public House build() {
            return house;
        }
    }
}
