package main.java.rpg.console;

import main.java.rpg.controllers.CharacterController;
import main.java.rpg.core.CharacterClass;

import java.util.List;
import java.util.Scanner;

public class CharacterConsole {
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
                    System.out.print("Santé : ");
                    int characterHealth = scanner.nextInt();
                    CharacterClass createdCharacter = new CharacterClass.CharacterBuilder(characterName)
                            .setStrength(characterStrength)
                            .setAgility(characterAgility)
                            .setIntelligence(characterIntelligence)
                            .setHealth(characterHealth)
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
}
