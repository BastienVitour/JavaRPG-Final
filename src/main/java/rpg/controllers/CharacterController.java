package main.java.rpg.controllers;

import main.java.rpg.core.CharacterClass;
import main.java.rpg.dao.CharacterDAO;
import main.java.rpg.settings.DatabaseConnection;
import main.java.rpg.validators.CharacterValidator;

import java.sql.Connection;
import java.util.List;

public class CharacterController implements Controller<CharacterClass> {

    private CharacterDAO characterDAO;

    public CharacterController() {
        Connection connection = DatabaseConnection.getConnection();
        this.characterDAO = new CharacterDAO(connection);
    }

    @Override
    public List<CharacterClass> findAll() {
        return this.characterDAO.findAll();
    }

    @Override
    public boolean save(CharacterClass character) {
        boolean creationValid = false;

        CharacterValidator characterValidator = new CharacterValidator(this.characterDAO);
        if(characterValidator.validateCharacter(character)) {
            return this.characterDAO.save(character);
        }

        return creationValid;
    }
}
