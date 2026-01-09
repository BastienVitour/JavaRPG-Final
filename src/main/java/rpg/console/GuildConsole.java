package main.java.rpg.console;

import main.java.rpg.controllers.GuildController;
import main.java.rpg.core.Guild;

import java.util.List;
import java.util.Scanner;

public class GuildConsole {
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
}
