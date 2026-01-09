package main.java.rpg.console;

import main.java.rpg.controllers.CharacterController;
import main.java.rpg.core.CharacterClass;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CombatConsole {
    public static void CombatMenu(Scanner scanner) {
        CharacterController characterController = new CharacterController();
        List<CharacterClass> allCharacters = characterController.findAll();

        System.out.println("Sélectionner un personnage");
        for(int i = 0; i < allCharacters.size(); i++) {
            System.out.print(i+1 + " - ");
            allCharacters.get(i).getDescription();
        }

        String choice = scanner.nextLine();
        int intChoice = 0;
        try {
            intChoice = Integer.parseInt(choice);
        }
        catch (NumberFormatException ex) {

        }

        CharacterClass selectedCharacter = allCharacters.get(intChoice-1);
        selectedCharacter.getDescription();

        System.out.println("Sélectionner le deuxième personnage");
        for(int i = 0; i < allCharacters.size(); i++) {
            CharacterClass c = allCharacters.get(i);
            if(c.getName() != selectedCharacter.getName()) {
                System.out.print(i+1 + " - ");
                allCharacters.get(i).getDescription();
            }
        }

        choice = scanner.nextLine();
        try {
            intChoice = Integer.parseInt(choice);
        }
        catch (NumberFormatException ex) {

        }

        CharacterClass selectedCharacter2 = allCharacters.get(intChoice-1);
        selectedCharacter2.getDescription();

        boolean combatRunning = true;

        CharacterClass characterTurn = selectedCharacter;

        Random rand = new Random();

        while (combatRunning) {
            System.out.println(selectedCharacter.getName() + " : " + selectedCharacter.getHealthPoints() + "pv restants");
            System.out.println(selectedCharacter2.getName() + " : " + selectedCharacter2.getHealthPoints() + "pv restants");
            System.out.println("Tour de " + characterTurn.getName());
            System.out.println("1 - Attaquer");
            System.out.println("2 - Défendre");
            System.out.println("3 - Utiliser une capacité");
            System.out.println("4 - Passer son tour");
            choice = scanner.nextLine();
            try {
                intChoice = Integer.parseInt(choice);
            }
            catch (NumberFormatException ex) {
                continue;
            }
            switch (intChoice) {
                case 1:
                    int damage = rand.nextInt(5, 10);
                    if(characterTurn == selectedCharacter) {
                        int selectedCharacter2Hp = selectedCharacter2.getHealthPoints() - damage;
                        System.out.println(selectedCharacter.getName() + " attaque ! " + selectedCharacter2.getName() + " perd " + damage + " points de vie");
                        selectedCharacter2.setHealthPoints(selectedCharacter2Hp);
                        if(selectedCharacter2Hp <= 0) {
                            System.out.println(selectedCharacter2.getName() + " n'a plus de points de vie ! " + selectedCharacter.getName() + " remporte le combat !");
                            combatRunning = false;
                        }
                    }
                    else {
                        int selectedCharacterHp = selectedCharacter.getHealthPoints() - damage;
                        System.out.println(selectedCharacter2.getName() + " attaque ! " + selectedCharacter.getName() + " perd " + damage + " points de vie");
                        selectedCharacter.setHealthPoints(selectedCharacterHp);
                        if(selectedCharacterHp <= 0) {
                            System.out.println(selectedCharacter.getName() + " n'a plus de points de vie ! " + selectedCharacter2.getName() + " remporte le combat !");
                            combatRunning = false;
                        }
                    }
                    characterTurn = (characterTurn == selectedCharacter ? selectedCharacter2 : selectedCharacter);
                    break;
                case 2:
                    characterTurn = (characterTurn == selectedCharacter ? selectedCharacter2 : selectedCharacter);
                    break;
                case 3:
                    characterTurn = (characterTurn == selectedCharacter ? selectedCharacter2 : selectedCharacter);
                    break;
                case 4:
                    characterTurn = (characterTurn == selectedCharacter ? selectedCharacter2 : selectedCharacter);
                    break;
                default:
                    continue;
            }
        }
    }
}
