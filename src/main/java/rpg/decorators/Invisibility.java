package main.java.rpg.decorators;

import main.java.rpg.core.Character;

public class Invisibility extends CharacterDecorator {
    public Invisibility(Character character) {
        super(character);
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Ce personnage peut devenir invisible");
    }
}
