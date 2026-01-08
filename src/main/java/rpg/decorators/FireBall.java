package main.java.rpg.decorators;

import main.java.rpg.core.Character;

public class FireBall extends CharacterDecorator {
    public FireBall(Character character) {
        super(character);
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Ce personnage peut lancer des boules de feu");
    }
}
