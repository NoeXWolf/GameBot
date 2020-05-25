package fr.noexwolf.gamebot.command.settings;

import fr.noexwolf.gamebot.Bot;
import fr.noexwolf.gamebot.database.DatabaseManager;
import net.dv8tion.jda.api.entities.Guild;

import javax.annotation.Nullable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;

public class GuildSettingsProvider implements com.jagrosh.jdautilities.command.GuildSettingsProvider {

    private final Guild guild;
    private final Bot bot;
    private final DatabaseManager databaseManager;

    public GuildSettingsProvider(Guild guild, Bot bot) {
        this.guild = guild;
        this.bot = bot;
        this.databaseManager = bot.getDatabaseManager();
    }

    public void setPrefix(String newPrefix) throws SQLException {
        PreparedStatement preparedStatement;
        if (getPrefix() == null) {
            preparedStatement = databaseManager.prepareStatement("INSERT INTO prefixes (guild_id, prefix) VALUES (?, ?)");
            preparedStatement.setString(1, guild.getId());
            preparedStatement.setString(2, newPrefix);
        } else {
            preparedStatement = databaseManager.prepareStatement("UPDATE prefixes SET prefix = ? WHERE guild_id = ?");
            preparedStatement.setString(1, newPrefix);
            preparedStatement.setString(2, guild.getId());
        }
        preparedStatement.executeUpdate();
    }

    public String getPrefix() {
        try {
            PreparedStatement preparedStatement = databaseManager.prepareStatement("SELECT prefix FROM prefixes WHERE guild_id = ?");
            preparedStatement.setString(1, guild.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) return resultSet.getString("prefix");
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bot.getCommandClient().getPrefix();
    }

    @Nullable
    @Override
    public Collection<String> getPrefixes() {
        return Collections.singletonList(getPrefix());
    }

}
