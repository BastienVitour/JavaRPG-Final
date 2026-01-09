package main.java.rpg.settings;

public class GameSettings {
    private static GameSettings gameSettings = new GameSettings();
    public static int maxStatPoints = 50;
    public static int maxCharactersByGuild = 5;
    public static int maxGuildsByArmy = 5;

    private GameSettings() {

    }
}
