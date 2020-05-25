package fr.noexwolf.gamebot.command.settings;

import fr.noexwolf.gamebot.Bot;
import net.dv8tion.jda.api.entities.Guild;

import javax.annotation.Nullable;

public class GuildSettingsManager implements com.jagrosh.jdautilities.command.GuildSettingsManager<GuildSettingsProvider> {

    private final Bot bot;

    public GuildSettingsManager(Bot bot) {
        this.bot = bot;
    }

    @Nullable
    @Override
    public GuildSettingsProvider getSettings(Guild guild) {
        return new GuildSettingsProvider(guild, bot);
    }

}
