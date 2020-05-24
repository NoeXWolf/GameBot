package fr.noexwolf.gamebot.command.settings;

import com.jagrosh.jdautilities.command.GuildSettingsManager;
import com.jagrosh.jdautilities.command.GuildSettingsProvider;
import net.dv8tion.jda.api.entities.Guild;

import javax.annotation.Nullable;

public class GuildSettingsManagerImpl implements GuildSettingsManager<GuildSettingsProvider> {

    @Nullable
    @Override
    public GuildSettingsProvider getSettings(Guild guild) {
        return null;
    }

}
