package fr.noexwolf.gamebot.command;

import com.jagrosh.jdautilities.command.CommandEvent;
import fr.noexwolf.gamebot.command.arguments.Argument;
import fr.noexwolf.gamebot.command.arguments.InvalidCommandArgumentException;

import java.util.Collections;
import java.util.List;

public abstract class Command extends com.jagrosh.jdautilities.command.Command {

    protected List<Argument> arguments = Collections.emptyList();

    public final String getUsage() {
        StringBuilder builder = new StringBuilder()
                .append(this.name);
        arguments.forEach(argument -> builder.append(' ').append(argument));
        return builder.toString();
    }

    @Override
    protected final void execute(CommandEvent event) {
        String[] arguments = event.getArgs().split(" ");
        for (int i = 0; i < arguments.length; i++) {
            try {
                this.arguments.get(i).setArgument(arguments[i]);
            } catch (InvalidCommandArgumentException e) {
                event.getChannel().sendMessage(event.getAuthor() + ", you have not correctly used the command `" + this.name + "`\n" +
                        "Here is the right usage: `" + getUsage() + "`.");
                return;
            }
        }
    }

    protected abstract void execute(CommandEvent event, List<Argument> arguments);
}
