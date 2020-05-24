package fr.noexwolf.gamebot.command.settings;

import com.jagrosh.jdautilities.command.GuildSettingsProvider;
import fr.noexwolf.gamebot.Bot;
import net.dv8tion.jda.api.entities.Guild;

import java.sql.PreparedStatement;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GuildSettingsProviderImpl implements GuildSettingsProvider {

    private final Guild guild;
    private final Bot bot;

    public GuildSettingsProviderImpl(Guild guild, Bot bot) {
        this.guild = guild;
        this.bot = bot;
    }

//    @Override
//    public Collection<String> getPrefixes() {
//
//    }

}
