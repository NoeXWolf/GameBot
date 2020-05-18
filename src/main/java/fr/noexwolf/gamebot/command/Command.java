package fr.noexwolf.gamebot.command;

import com.jagrosh.jdautilities.command.CommandEvent;
import fr.noexwolf.gamebot.Bot;
import fr.noexwolf.gamebot.command.arguments.Argument;
import fr.noexwolf.gamebot.command.arguments.InvalidCommandArgumentException;
import fr.noexwolf.gamebot.command.arguments.MissingCommandArgumentException;

import java.util.Collections;
import java.util.List;

public abstract class Command extends com.jagrosh.jdautilities.command.Command {

    protected List<Argument<?>> arguments = Collections.emptyList();

    protected final Bot bot;

    public Command(Bot bot) {
        this.bot = bot;
    }

    public final String getUsage() {
        StringBuilder builder = new StringBuilder()
                .append(bot.getCommandClient().getPrefix())
                .append(this.name);
        arguments.forEach(argument -> builder.append(' ').append(argument));
        return builder.toString();
    }

    @Override
    protected final void execute(CommandEvent event) {
        String[] arguments = event.getArgs().split(" ");
        for (int i = 0; i < arguments.length; i++) {
            if (this.arguments.size() <= i) break;
            try {
                Argument<?> argument = this.arguments.get(i);
                argument.setArgument(arguments[i]);
            } catch (InvalidCommandArgumentException | MissingCommandArgumentException e) {
                event.getChannel().sendMessage(event.getAuthor().getAsMention() + ", you have not correctly used the command `" + this.name + "`.\n" +
                        "Here is the right usage: `" + getUsage() + "`.").queue();
                return;
            }
        }
        onCommand(event);
    }

    protected abstract void onCommand(CommandEvent event);

}
