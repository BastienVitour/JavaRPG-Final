package main.java.rpg.core;

public class CharacterClass implements Character {

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int healthPoints;

    public CharacterClass(CharacterBuilder characterBuilder) {
        this.name = characterBuilder.name;
        this.strength = characterBuilder.strength;
        this.agility = characterBuilder.agility;
        this.intelligence = characterBuilder.intelligence;
        this.healthPoints = characterBuilder.healthPoints;
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

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public void getDescription() {
        System.out.println(this.name + "(STR: " + this.strength + ", AGI: " + this.agility + ", INT: " + this.intelligence + ") Total: " + this.getPowerLevel());
    }

    public int getPowerLevel() {
        return this.strength + this.agility + this.intelligence;
    }

    public static class CharacterBuilder {
        private String name;
        private int strength;
        private int agility;
        private int intelligence;
        private int healthPoints;

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

        public CharacterBuilder setHealth(int healthPoints) {
            this.healthPoints = healthPoints;
            return this;
        }

        public CharacterClass build() {
            return new CharacterClass(this);
        }
    }
}
