import main.java.rpg.core.Character;

void main() {

    Character character = new Character.CharacterBuilder("Basvit")
            .setStrength(0)
            .setAgility(15)
            .setIntelligence(30)
            .build();

    character.getDescription();

}
