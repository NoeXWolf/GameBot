package fr.noexwolf.gamebot.command.commands.defaults;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.menu.Paginator;
import fr.noexwolf.gamebot.Bot;
import fr.noexwolf.gamebot.command.Command;
import fr.noexwolf.gamebot.command.CommandCategory;
import fr.noexwolf.gamebot.command.arguments.StringArgument;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class HelpCommand extends Command {

    private final Paginator.Builder paginatorBuilder;

    public HelpCommand(Bot bot) {
        super(bot);
        this.name = "help";
        this.help = "Browse all commands with their descriptions and usages";
        this.arguments = Collections.singletonList(new StringArgument("category", false,
                Arrays.stream(CommandCategory.values())
                        .map(category -> category.getCategory().getName())
                        .collect(Collectors.toList())
        ));
        this.category = CommandCategory.DEFAULT.getCategory();

        this.paginatorBuilder = new Paginator.Builder()
                .setColumns(1)
                .setItemsPerPage(10)
                .showPageNumbers(true)
                .waitOnSinglePage(false)
                .setEventWaiter(bot.getEventWaiter())
                .setTimeout(1, TimeUnit.MINUTES);
    }

    @Override
    protected void onCommand(CommandEvent event) {
        Optional<String> optionalCategory = (Optional<String>) arguments.get(0).getValue();
        if (optionalCategory.isPresent()) {
            String category = optionalCategory.get();
            event.getClient().getCommands().stream()
                    .filter(command -> command.getCategory().getName().equalsIgnoreCase(category))
                    .forEach(System.out::println);
        }
    }

}
