package fr.noexwolf.gamebot.command.commands.defaults;

import com.jagrosh.jdautilities.command.CommandEvent;
import fr.noexwolf.gamebot.Bot;
import fr.noexwolf.gamebot.command.Command;
import fr.noexwolf.gamebot.command.CommandCategory;
import fr.noexwolf.gamebot.command.arguments.StringArgument;
import fr.noexwolf.gamebot.command.settings.GuildSettingsProvider;
import fr.noexwolf.gamebot.utils.Checker;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;

import java.sql.SQLException;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

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
            Checker checker = new Checker(
                    () -> changePrefix(newPrefix, event),
                    () -> event.getChannel().sendMessage("Prefix changing refused.").queue(),
                    () -> event.getChannel().sendMessage("Prefix changing timed out.").queue(),
                    true,
                    bot.getEventWaiter()
            );
            event.getChannel().sendMessage(event.getAuthor().getAsMention() + ", are you sure that you want to change GameBot's prefix for this server to `" + newPrefix + "` ?\n" +
                    "You will have to perform commands like that: `" + newPrefix + "help`.").queue(checker::check);
            return;
        }
        event.getChannel().sendMessage(event.getAuthor().getAsMention() + ", the prefix `" + newPrefix + "` is too long (1 - 10 characters).").queue();
    }

    private void changePrefix(String newPrefix, CommandEvent event) {
        try {
            ((GuildSettingsProvider) event.getClient().getSettingsManager().getSettings(event.getGuild())).setPrefix(newPrefix);
            event.getChannel().sendMessage(event.getAuthor().getAsMention() + ", you successfully set GameBot's prefix for this server to `" + newPrefix + "`.\n" +
                    "You now have to perform commands like that: `" + newPrefix + "help`.").queue();
        } catch (SQLException e) {
            e.printStackTrace();
            event.getChannel().sendMessage(event.getAuthor().getAsMention() + ", something went wrong during prefix changing.\n" +
                    "Please report this incident to support server : " + bot.getPropertiesManager().getProperty("support-server")).queue();
        }
    }

}
