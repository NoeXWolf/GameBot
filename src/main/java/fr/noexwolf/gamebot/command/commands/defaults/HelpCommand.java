package fr.noexwolf.gamebot.command.commands.defaults;

import com.jagrosh.jdautilities.command.CommandEvent;
import fr.noexwolf.gamebot.command.Command;
import fr.noexwolf.gamebot.command.CommandCategory;
import fr.noexwolf.gamebot.command.arguments.StringArgument;
import net.dv8tion.jda.api.EmbedBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class HelpCommand extends Command {

    public HelpCommand() {
        this.name = "help";
        this.help = "Browse all commands with their descriptions and usages";
        this.arguments = Collections.singletonList(new StringArgument("category", false));
//        this.category = CommandCategory.DEFAULT;
    }

    @Override
    protected void onCommand(CommandEvent event) {
//        StringArgument categoryArgument = (StringArgument) arguments.get(0);
//        Stream<CommandCategory> categoriesStream = Arrays.stream(CommandCategory.values());
//
//        if (categoryArgument.getValue().isEmpty()) {
//            EmbedBuilder builder = new EmbedBuilder()
//                    .setTitle("Help categories");
//
//            categoriesStream.forEach(category -> builder.addField(category.getName(), category.getDescription(), false));
//            event.getChannel().sendMessage(builder.build()).queue();
//
//            return;
//        }
//
//        categoriesStream
//                .filter(category -> category.getName().equalsIgnoreCase(categoryArgument.getValue().get()))
//                .findAny()
//                .ifPresent(category -> {
//                    EmbedBuilder builder = new EmbedBuilder()
//                            .setTitle(category.getDescription());
//                    event.getClient().getCommands().stream()
//                            .filter(command -> command.getCategory() == category)
//                });
    }

}
