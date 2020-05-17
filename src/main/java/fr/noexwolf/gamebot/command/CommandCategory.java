package fr.noexwolf.gamebot.command;

import com.jagrosh.jdautilities.command.Command;

import java.util.Arrays;
import java.util.Optional;

public enum CommandCategory {
    DEFAULT(new Command.Category("Default"), "Default commands"),
    GAME(new Command.Category("Game"), "Game commands"),
    ECONOMY(new Command.Category("Economy"), "Economy commands");

    private final Command.Category category;
    private final String description;

    CommandCategory(Command.Category category, String description) {
        this.category = category;
        this.description = description;
    }

    public Command.Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public static Optional<Command.Category> getCategoryFromName(String name) {
        return Arrays.stream(values())
                .filter(commandCategory -> commandCategory.getCategory().getName().equalsIgnoreCase(name))
                .map(CommandCategory::getCategory)
                .findAny();
    }

}
