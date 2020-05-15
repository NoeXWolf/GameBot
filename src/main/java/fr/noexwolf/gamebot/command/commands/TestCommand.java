package fr.noexwolf.gamebot.command.commands;

import com.jagrosh.jdautilities.command.CommandEvent;
import fr.noexwolf.gamebot.command.Command;
import fr.noexwolf.gamebot.command.arguments.Argument;
import fr.noexwolf.gamebot.command.arguments.ArgumentBuilder;
import fr.noexwolf.gamebot.command.arguments.IntArgument;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCommand extends Command {

    public TestCommand() {
        this.name = "test";
        this.help = "Test command to test the command system";
        this.arguments = Collections.singletonList(new IntArgument("number", true));
    }

    @Override
    protected void onCommand(CommandEvent event) {
        event.getChannel().sendMessage("Here is your number: " + arguments.get(0).getValue()).queue();
    }

}
