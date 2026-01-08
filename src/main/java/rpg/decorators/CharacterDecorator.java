package main.java.rpg.decorators;

import main.java.rpg.core.Character;

public abstract class CharacterDecorator implements Character {

    protected Character character;

    public CharacterDecorator(Character character) {
        this.character = character;
    }

    @Override
    public void getDescription() {
        this.character.getDescription();
    }
}
