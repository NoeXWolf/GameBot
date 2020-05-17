package fr.noexwolf.gamebot.command.commands.defaults;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.menu.Paginator;
import fr.noexwolf.gamebot.Bot;
import fr.noexwolf.gamebot.command.Command;
import fr.noexwolf.gamebot.command.CommandCategory;
import fr.noexwolf.gamebot.command.arguments.StringArgument;
import net.dv8tion.jda.api.EmbedBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class HelpCommand extends Command {


    public HelpCommand(Bot bot) {
        super(bot);
        this.name = "help";
        this.help = "Browse all commands with their descriptions and usages";
        this.arguments = Collections.singletonList(new StringArgument("category", false/*,
                Arrays.stream(CommandCategory.values())
                        .map(category -> category.getCategory().getName())
                        .collect(Collectors.toList())*/
        ));
        this.category = CommandCategory.DEFAULT.getCategory();
    }

    @Override
    protected void onCommand(CommandEvent event) {
        Optional<String> optionalCategoryArgument = (Optional<String>) arguments.get(0).getValue();
        EmbedBuilder embedBuilder = new EmbedBuilder();

        if (optionalCategoryArgument.isPresent()) {
            Optional<Category> optionalCategory = CommandCategory.getCategoryFromName(optionalCategoryArgument.get());

            if (optionalCategory.isPresent()) {
                Category category = optionalCategory.get();
                embedBuilder.setTitle("Commands - " + category.getName());

                List<Command> commands = event.getClient().getCommands().stream()
                        .filter(command -> command.getCategory().getName().equalsIgnoreCase(category.getName()))
                        .map(command -> (Command) command)
                        .collect(Collectors.toList());

                if (!commands.isEmpty()) {
                    embedBuilder.setDescription("Help for commands of " + category.getName() + " category");
                    for (Command command : commands) {
                        embedBuilder.addField(command.getName(), "**" + command.getHelp() + "**\nUsage: `" + command.getUsage() + "`", false);
                    }
                } else {
                    embedBuilder.setDescription("This category doesn't contain any command.");
                }
                event.getChannel().sendMessage(embedBuilder.build()).queue();
                return;
            }
            event.getChannel().sendMessage(event.getAuthor().getAsMention() + ", category **'" + optionalCategoryArgument.get() + "'** doesn't exist.").queue();
            return;
        }

        embedBuilder.setTitle("Commands - Categories")
                .setDescription("Here is different categories of help.\nTo browse commands of a specific category, use `+help <category>`");

        Arrays.stream(CommandCategory.values())
                .forEach(category -> embedBuilder.addField(category.getCategory().getName(), category.getDescription(), false));

        event.getChannel().sendMessage(embedBuilder.build()).queue();

    }

}
