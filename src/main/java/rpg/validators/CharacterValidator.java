package main.java.rpg.validators;

import main.java.rpg.core.CharacterClass;
import main.java.rpg.dao.CharacterDAO;
import main.java.rpg.settings.GameSettings;

public class CharacterValidator {

    private CharacterDAO characterDAO;

    public CharacterValidator(CharacterDAO characterDAO) {
        this.characterDAO = characterDAO;
    }

    public boolean validateCharacter(CharacterClass character) {
        try {
            if(character.getPowerLevel() > GameSettings.maxStatPoints) {
                return false;
            }
            if(this.characterDAO.findByName(character.getName()) != null) {
                return false;
            }
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
}
