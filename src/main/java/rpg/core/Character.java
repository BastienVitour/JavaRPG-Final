package main.java.rpg.core;

public class Character {

    private String name;
    private int strength;
    private int agility;
    private int intelligence;

    public Character(CharacterBuilder characterBuilder) {
        this.name = characterBuilder.name;
        this.strength = characterBuilder.strength;
        this.agility = characterBuilder.agility;
        this.intelligence = characterBuilder.intelligence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void getDescription() {
        System.out.println("Personnage " + this.name);
        System.out.println("Stats:");
        System.out.println("- Force : " + this.strength);
        System.out.println("- Agilité : " + this.agility);
        System.out.println("- Intelligence : " + this.intelligence);
        System.out.println("Puissance totale : " + this.getPowerLevel());
    }

    public int getPowerLevel() {
        return this.strength + this.agility + this.intelligence;
    }

    public static class CharacterBuilder {
        private String name;
        private int strength;
        private int agility;
        private int intelligence;

        public CharacterBuilder(String name) {
            this.name = name;
        }

        public CharacterBuilder setStrength(int strength) {
            this.strength = strength;
            return this;
        }

        public CharacterBuilder setAgility(int agility) {
            this.agility = agility;
            return this;
        }

        public CharacterBuilder setIntelligence(int intelligence) {
            this.intelligence = intelligence;
            return this;
        }

        public Character build() {
            return new Character(this);
        }
    }
}
