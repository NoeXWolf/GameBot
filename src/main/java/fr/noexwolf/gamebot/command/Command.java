package fr.noexwolf.gamebot.command;

import com.jagrosh.jdautilities.command.CommandEvent;
import fr.noexwolf.gamebot.command.arguments.Argument;
import fr.noexwolf.gamebot.command.arguments.InvalidCommandArgumentException;

import java.util.Collections;
import java.util.List;

public abstract class Command extends com.jagrosh.jdautilities.command.Command {

    protected List<Argument<?>> arguments = Collections.emptyList();
    protected CommandCategory category = CommandCategory.DEFAULT;

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
                Argument<?> argument = this.arguments.get(i);
                argument.setArgument(arguments[i]);
            } catch (InvalidCommandArgumentException e) {
                event.getChannel().sendMessage(event.getAuthor().getAsMention() + ", you have not correctly used the command `" + this.name + "`.\n" +
                        "Here is the right usage: `" + event.getClient().getPrefix() + getUsage() + "`.").queue();
                return;
            }
        }
        onCommand(event);
    }

    protected abstract void onCommand(CommandEvent event);
}
