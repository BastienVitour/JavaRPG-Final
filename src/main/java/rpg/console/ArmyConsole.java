package main.java.rpg.console;

import main.java.rpg.controllers.ArmyController;
import main.java.rpg.core.Army;

import java.util.List;
import java.util.Scanner;

public class ArmyConsole {
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
