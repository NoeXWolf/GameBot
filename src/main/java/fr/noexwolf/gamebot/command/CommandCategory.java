package fr.noexwolf.gamebot.command;

public enum CommandCategory {
    DEFAULT("Default", "Basic commands"),
    GAME("Game", "Game commands"),
    ECONOMY("Economy", "Economy commands");

    private final String name;
    private final String description;

    CommandCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
