package fr.noexwolf.gamebot;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import fr.noexwolf.gamebot.command.commands.TestCommand;
import fr.noexwolf.gamebot.command.commands.defaults.HelpCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;

public class Bot {

    private final JDA jda;
    private final CommandClient commandClient;
    private final EventWaiter eventWaiter;

    public Bot(String token) throws LoginException {
        commandClient = new CommandClientBuilder()
                .setPrefix("+")
                .setOwnerId("239024668411953153")
                .useHelpBuilder(false)
                .addCommands(new TestCommand(this), new HelpCommand(this))
                .build();

        eventWaiter = new EventWaiter();

        jda = JDABuilder.create(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_REACTIONS)
                .setMemberCachePolicy(MemberCachePolicy.NONE)
                .disableCache(CacheFlag.VOICE_STATE, CacheFlag.EMOTE, CacheFlag.ACTIVITY, CacheFlag.CLIENT_STATUS)
                .addEventListeners(commandClient)
                .build();
    }

    public void start() throws InterruptedException {
        jda.awaitReady();
    }

    public EventWaiter getEventWaiter() {
        return eventWaiter;
    }

    public CommandClient getCommandClient() {
        return commandClient;
    }

    public JDA getJda() {
        return jda;
    }

}
