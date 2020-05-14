package fr.noexwolf.gamebot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;

public class Bot {

    private final JDA jda;

    public Bot(String token) throws LoginException {
        jda = JDABuilder.create(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_REACTIONS)
                .setMemberCachePolicy(MemberCachePolicy.NONE)
                .disableCache(CacheFlag.VOICE_STATE, CacheFlag.EMOTE, CacheFlag.ACTIVITY, CacheFlag.CLIENT_STATUS)
                .build();
    }

    public void start() throws InterruptedException {
        jda.awaitReady();
    }

}
