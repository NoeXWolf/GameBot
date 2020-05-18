package fr.noexwolf.gamebot.command.commands.defaults;

import com.jagrosh.jdautilities.command.CommandEvent;
import fr.noexwolf.gamebot.Bot;
import fr.noexwolf.gamebot.command.Command;
import fr.noexwolf.gamebot.command.CommandCategory;
import fr.noexwolf.gamebot.properties.PropertiesManager;
import net.dv8tion.jda.api.EmbedBuilder;

public class SupportCommand extends Command {

    public SupportCommand(Bot bot) {
        super(bot);
        this.name = "support";
        this.help = "Support GameBot";
        this.category = CommandCategory.DEFAULT.getCategory();
    }

    @Override
    protected void onCommand(CommandEvent event) {
        PropertiesManager propertiesManager = bot.getPropertiesManager();

        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle("GameBot - Support")
                .setDescription("Here are some ways you can support GameBot")
                .setThumbnail(event.getJDA().getSelfUser().getAvatarUrl())
                .addField("UpVote on Discord Bot List", propertiesManager.getProperty("dbl-link"), false)
                .addField("Donate on Tipeee", propertiesManager.getProperty("donation-link"), false);

        event.getChannel().sendMessage(embedBuilder.build()).queue();
    }

}
