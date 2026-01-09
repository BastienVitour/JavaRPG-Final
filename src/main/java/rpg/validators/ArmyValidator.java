package main.java.rpg.validators;

import main.java.rpg.core.Army;
import main.java.rpg.dao.ArmyDAO;

public class ArmyValidator {

    private ArmyDAO armyDao;

    public ArmyValidator(ArmyDAO armyDao) {
        this.armyDao = armyDao;
    }

    public boolean validateArmy(Army army) {
        try {
            return this.armyDao.findByName(army.getName()) == null;
        }
        catch(Exception e) {
            return false;
        }
    }

}
