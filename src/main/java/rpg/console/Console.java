package main.java.rpg.console;

import main.java.rpg.controllers.ArmyController;
import main.java.rpg.controllers.CharacterController;
import main.java.rpg.controllers.GuildController;
import main.java.rpg.core.Army;
import main.java.rpg.core.CharacterClass;
import main.java.rpg.core.Guild;

import java.util.List;
import java.util.Scanner;

public class Console {

    public static void CharacterMenu(Scanner scanner) {
        CharacterController characterController = new CharacterController();
        boolean characterMenu = true;
        while (characterMenu) {
            System.out.println("Menu des personnages");
            System.out.println("1 - Voir les personnages");
            System.out.println("2 - Créer un personnage");
            System.out.println("0 - Retour");
            String choice = scanner.nextLine();
            int intChoice = 0;
            try {
                intChoice = Integer.parseInt(choice);
            }
            catch (NumberFormatException ex) {
                continue;
            }

            switch (intChoice) {
                case 1:
                    List<CharacterClass> allCharacters = characterController.findAll();
                    for(CharacterClass character: allCharacters) {
                        character.getDescription();
                    }
                    break;
                case 2:
                    System.out.print("Nom du personnage : ");
                    String characterName = scanner.nextLine();
                    System.out.print("Force : ");
                    int characterStrength = scanner.nextInt();
                    System.out.print("Agilité : ");
                    int characterAgility = scanner.nextInt();
                    System.out.print("Intelligence : ");
                    int characterIntelligence = scanner.nextInt();
                    CharacterClass createdCharacter = new CharacterClass.CharacterBuilder(characterName)
                            .setStrength(characterStrength)
                            .setAgility(characterAgility)
                            .setIntelligence(characterIntelligence)
                            .build();
                    if(characterController.save(createdCharacter)) {
                        System.out.println("Le personnage a bien été ajouté");
                    }
                    else {
                        System.out.println("Le personnage n'a pas pu être ajouté");
                    }
                    break;
                default:
                    characterMenu = false;
            }
        }
    }

    public static void GuildMenu(Scanner scanner) {
        GuildController guildController = new GuildController();
        boolean guildMenu = true;
        while (guildMenu) {
            System.out.println("Menu des guildes");
            System.out.println("1 - Voir les guildes");
            System.out.println("2 - Créer une guilde");
            System.out.println("0 - Retour");
            String choice = scanner.nextLine();
            int intChoice = 0;
            try {
                intChoice = Integer.parseInt(choice);
            }
            catch (NumberFormatException ex) {
                continue;
            }
            switch (intChoice) {
                case 1:
                    List<Guild> allGuilds = guildController.findAll();
                    if(!allGuilds.isEmpty()) {
                        for(Guild guild: allGuilds) {
                            guild.getDescription();
                        }
                    }
                    else {
                        System.out.println("Aucune guilde n'a été créée");
                    }
                    break;
                case 2:
                    System.out.print("Nom de la guilde : ");
                    String guildName = scanner.nextLine();
                    Guild guild = new Guild(guildName);

                    if(guildController.save(guild)) {
                        System.out.println("La guilde a bien été ajoutée");
                    }
                    else {
                        System.out.println("La guilde n'a pas pu être ajoutée");
                    }
                    break;
                default:
                    guildMenu = false;
            }
        }
    }

    public static void ArmyMenu(Scanner scanner) {
        ArmyController armyController = new ArmyController();
        boolean armyMenu = true;
        while (armyMenu) {
            System.out.println("Menu des armées");
            System.out.println("1 - Voir les armées");
            System.out.println("2 - Créer une armée");
            System.out.println("0 - Retour");
            String choice = scanner.nextLine();
            int intChoice = 0;
            try {
                intChoice = Integer.parseInt(choice);
            }
            catch (NumberFormatException ex) {
                continue;
            }
            switch (intChoice) {
                case 1:
                    List<Army> allArmies = armyController.findAll();
                    if(!allArmies.isEmpty()) {
                        for(Army army: allArmies) {
                            army.getDescription();
                        }
                    }
                    else {
                        System.out.println("Aucune armée n'a été créée");
                    }
                    break;
                case 2:
                    System.out.print("Nom de l'armée : ");
                    String armyName = scanner.nextLine();
                    Army army = new Army(armyName);

                    if(armyController.save(army)) {
                        System.out.println("L'armée a bien été ajoutée");
                    }
                    else {
                        System.out.println("L'armée n'a pas pu être ajoutée");
                    }
                    break;
                default:
                    armyMenu = false;
            }
        }
    }

}
