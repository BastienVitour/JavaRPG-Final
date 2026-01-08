package main.java.rpg.decorators;

import main.java.rpg.core.Character;

public class Shield extends CharacterDecorator {
    public Shield(Character character) {
        super(character);
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Ce personnage peut créer un bouclier pour se protéger");
    }
}
