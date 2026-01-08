import main.java.rpg.core.Character;
import main.java.rpg.core.CharacterClass;
import main.java.rpg.decorators.FireBall;
import main.java.rpg.decorators.Invisibility;
import main.java.rpg.decorators.Shield;

void main() {

    CharacterClass character1 = new CharacterClass.CharacterBuilder("Basvit")
            .setStrength(0)
            .setAgility(15)
            .setIntelligence(30)
            .build();

    Character fire = new FireBall(character1);

    fire.getDescription();

    CharacterClass character2 = new CharacterClass.CharacterBuilder("Adam")
            .setStrength(20)
            .setAgility(5)
            .setIntelligence(5)
            .build();

    Character untouchable = new Invisibility(new Shield(character2));

    untouchable.getDescription();

}
