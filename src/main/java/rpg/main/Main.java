import main.java.rpg.console.ArmyConsole;
import main.java.rpg.console.CharacterConsole;
import main.java.rpg.console.CombatConsole;
import main.java.rpg.console.GuildConsole;

void main() {

    Scanner scanner = new Scanner(System.in);

    boolean mainMenu = true;
    while (mainMenu) {
        System.out.println("Menu");
        System.out.println("1 - Gérer les personnages");
        System.out.println("2 - Gérer les guildes");
        System.out.println("3 - Gérer les armées");
        System.out.println("4 - Combattre");
        System.out.println("0 - Quitter");

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
                CharacterConsole.CharacterMenu(scanner);
                break;
            case 2:
                GuildConsole.GuildMenu(scanner);
                break;
            case 3:
                ArmyConsole.ArmyMenu(scanner);
                break;
            case 4:
                CombatConsole.CombatMenu(scanner);
                break;
            default:
                mainMenu = false;
                break;
        }
    }

}
