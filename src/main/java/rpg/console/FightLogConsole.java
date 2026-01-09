package main.java.rpg.console;

import main.java.rpg.controllers.FightLogController;
import main.java.rpg.core.FightLog;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FightLogConsole {

    public static void FightLogMenu(Scanner scanner) {

        FightLogController fightLogController = new FightLogController();

        System.out.println("Quel combat voulez vous revoir ?");
        List<FightLog> allFightLogs = fightLogController.findAll();
        if(!allFightLogs.isEmpty()) {
            for(int i = 0; i < allFightLogs.size(); i++) {
                System.out.print(i+1 + " - ");
                allFightLogs.get(i).getBriefDescription();
            }
        }

        String choice = scanner.nextLine();
        int intChoice = 0;
        try {
            intChoice = Integer.parseInt(choice);
        }
        catch (NumberFormatException ex) {

        }

        if(intChoice <= allFightLogs.size()) {
            FightLog selectedFightLog = allFightLogs.get(intChoice - 1);
            String[] actions = selectedFightLog.getActionLog().split("-");

            for(String action: actions) {
                String[] details = action.split("");
                if(Objects.equals(details[0], "1")) {
                    System.out.print(selectedFightLog.getCharacter1());
                }
                else {
                    System.out.print(selectedFightLog.getCharacter2());
                }
                if(Objects.equals(details[1], "A")) {
                    System.out.print(" inflige " + details[2] + " dégâts à ");
                }
                if(Objects.equals(details[0], "1")) {
                    System.out.print(selectedFightLog.getCharacter2());
                }
                else {
                    System.out.print(selectedFightLog.getCharacter1());
                }
                System.out.println();
            }

            System.out.println(selectedFightLog.getWinner() + " remporte le combat");
        }
    }

}
