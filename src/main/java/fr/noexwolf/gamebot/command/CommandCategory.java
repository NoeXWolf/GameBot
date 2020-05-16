package fr.noexwolf.gamebot.command;

import com.jagrosh.jdautilities.command.Command;

public enum CommandCategory {
    DEFAULT(new Command.Category("Default")),
    GAME(new Command.Category("Game")),
    ECONOMY(new Command.Category("Economy"));

    private final Command.Category category;

    CommandCategory(Command.Category category) {
        this.category = category;
    }

    public Command.Category getCategory() {
        return category;
    }

}
