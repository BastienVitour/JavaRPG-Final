import main.java.rpg.core.Character;
import main.java.rpg.core.CharacterClass;
import main.java.rpg.dao.CharacterDAO;
import main.java.rpg.decorators.FireBall;
import main.java.rpg.decorators.Invisibility;
import main.java.rpg.decorators.Shield;
import main.java.rpg.settings.DatabaseConnection;

import java.sql.Connection;

void main() {

    Connection connection = DatabaseConnection.getConnection();

    CharacterDAO dao = new CharacterDAO(connection);

    CharacterClass character1 = new CharacterClass.CharacterBuilder("Basvit")
            .setStrength(0)
            .setAgility(15)
            .setIntelligence(30)
            .build();

    Character fire = new FireBall(character1);

    //fire.getDescription();

    //dao.save(character1);

    CharacterClass character2 = new CharacterClass.CharacterBuilder("Adam")
            .setStrength(20)
            .setAgility(5)
            .setIntelligence(5)
            .build();

    Character untouchable = new Invisibility(new Shield(character2));

    //untouchable.getDescription();

    //dao.save(character2);
    //dao.update(character2);
    CharacterClass character = dao.findByName("Adam");
    character.getDescription();

    List<CharacterClass> allCharacters = dao.findAll();
    for(CharacterClass c: allCharacters) {
        c.getDescription();
    }

}
