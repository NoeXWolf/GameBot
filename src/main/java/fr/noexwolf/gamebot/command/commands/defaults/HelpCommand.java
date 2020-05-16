package fr.noexwolf.gamebot.command.commands.defaults;

import com.jagrosh.jdautilities.command.CommandEvent;
import fr.noexwolf.gamebot.command.Command;
import fr.noexwolf.gamebot.command.CommandCategory;
import fr.noexwolf.gamebot.command.arguments.StringArgument;
import net.dv8tion.jda.api.EmbedBuilder;

import java.util.Arrays;
import java.util.Collections;

public class HelpCommand extends Command {

    public HelpCommand() {
        this.name = "help";
        this.help = "Browse all commands with their descriptions and usages";
        this.arguments = Collections.singletonList(new StringArgument("category", false));
        this.category = CommandCategory.DEFAULT;
    }

    @Override
    protected void onCommand(CommandEvent event) {
        if (arguments.get(0).getValue().isEmpty()) {
            EmbedBuilder builder = new EmbedBuilder()
                    .setTitle("Help categories");
            for (CommandCategory category : CommandCategory.values()) {
                builder.addField(category.getName(), category.getDescription(), false);
            }
            event.getChannel().sendMessage(builder.build()).queue();
        }
    }

}
