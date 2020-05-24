package fr.noexwolf.gamebot.command.commands.defaults;

import com.jagrosh.jdautilities.command.CommandEvent;
import fr.noexwolf.gamebot.Bot;
import fr.noexwolf.gamebot.command.Command;
import fr.noexwolf.gamebot.command.CommandCategory;
import fr.noexwolf.gamebot.command.arguments.StringArgument;
import net.dv8tion.jda.api.Permission;

import java.util.Collections;

public class SetPrefixCommand extends Command {

    public SetPrefixCommand(Bot bot) {
        super(bot);
        this.name = "setprefix";
        this.help = "Set GameBot's prefix for this server";
        this.userPermissions = new Permission[]{Permission.ADMINISTRATOR};
        this.arguments = Collections.singletonList(new StringArgument("new prefix", true));
        this.category = CommandCategory.DEFAULT.getCategory();
    }

    @Override
    protected void onCommand(CommandEvent event) {
        String newPrefix = (String) this.arguments.get(0).getValue().get();
        int length = newPrefix.length();
        if (length <= 10) {

            return;
        }
        event.getChannel().sendMessage(event.getAuthor().getAsMention() + ", the prefix `" + newPrefix + "` is too long (1 - 10 characters).").queue();
    }

}
