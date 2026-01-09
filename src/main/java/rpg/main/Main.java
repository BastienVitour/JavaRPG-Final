import main.java.rpg.console.Console;

void main() {

    Scanner scanner = new Scanner(System.in);

    boolean mainMenu = true;
    while (mainMenu) {
        System.out.println("Menu");
        System.out.println("1 - Gérer les personnages");
        System.out.println("2 - Gérer les guildes");
        System.out.println("3 - Gérer les armées");
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
                Console.CharacterMenu(scanner);
                break;
            case 2:
                Console.GuildMenu(scanner);
                break;
            case 3:
                Console.ArmyMenu(scanner);
                break;
            default:
                mainMenu = false;
                break;
        }
    }

}
