package fr.noexwolf.gamebot.command.commands;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.doc.standard.RequiredPermissions;
import fr.noexwolf.gamebot.command.Command;
import fr.noexwolf.gamebot.command.CommandCategory;
import fr.noexwolf.gamebot.command.arguments.IntArgument;
import net.dv8tion.jda.api.Permission;

import java.util.Arrays;
import java.util.Collections;

public class TestCommand extends Command {

    public TestCommand() {
        this.name = "test";
        this.help = "Test command to test the command system";
        this.category = CommandCategory.DEFAULT.getCategory();
        this.arguments = Collections.singletonList(new IntArgument("number", true, Arrays.asList(5, 10, 15)));
    }

    @Override
    protected void onCommand(CommandEvent event) {
        event.getChannel().sendMessage("Here is your number: " + arguments.get(0).getValue().get()).queue();
    }

}
