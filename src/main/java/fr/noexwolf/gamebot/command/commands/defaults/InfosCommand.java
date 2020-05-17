package fr.noexwolf.gamebot.command.commands.defaults;

import com.jagrosh.jdautilities.command.CommandEvent;
import fr.noexwolf.gamebot.Bot;
import fr.noexwolf.gamebot.command.Command;
import fr.noexwolf.gamebot.command.CommandCategory;
import fr.noexwolf.gamebot.properties.PropertiesManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;

import java.util.concurrent.ExecutionException;

public class InfosCommand extends Command {

    public InfosCommand(Bot bot) {
        super(bot);

        this.name = "infos";
        this.help = "Get some infos about GameBot";
        this.category = CommandCategory.DEFAULT.getCategory();
    }

    @Override
    protected void onCommand(CommandEvent event) {
        PropertiesManager propertiesManager = bot.getPropertiesManager();
        User author;

        try {
            author = event.getJDA().retrieveUserById(event.getClient().getOwnerId()).submit().get();
        } catch (InterruptedException | ExecutionException e) {
            event.getChannel().sendMessage("Something went wrong...").queue();
            return;
        }

        String serverUrl = propertiesManager.getProperty("support-server");

        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle("GameBot - Infos")
                .setDescription("Here are some infos about GameBot")
                .setThumbnail(author.getAvatarUrl())
                .setImage(event.getJDA().getSelfUser().getAvatarUrl())
                .addField("Version", "**" + propertiesManager.getProperty("version") + "**", true)
                .addField("Author", author.getAsMention(), true)
                .addField("Support Server", "**" + (serverUrl.equalsIgnoreCase("soon") ? "Soon" : "[Invitation](" + propertiesManager.getProperty("support-server") + ")") + "**", true);

        event.getChannel().sendMessage(embedBuilder.build()).queue();
    }

}
