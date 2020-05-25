package fr.noexwolf.gamebot.utils;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class Checker {

    private final EventWaiter eventWaiter;
    private Map<String, Runnable> actions;
    private final Runnable onTimedOut;
    private final boolean deleteMessageWhenReact;

    public Checker(Runnable onAccepted, Runnable onRefused, Runnable onTimedOut, boolean deleteMessageWhenReact, EventWaiter eventWaiter) {
        this.eventWaiter = eventWaiter;
        actions = new HashMap<>();
        actions.put("\u2705", onAccepted);
        actions.put("\u274c", onRefused);
        this.onTimedOut = onTimedOut;
        this.deleteMessageWhenReact = deleteMessageWhenReact;
    }

    public void check(Message message) {
        actions.forEach((key, value) -> message.addReaction(key).queue());
        eventWaiter.waitForEvent(
                MessageReactionAddEvent.class,
                event -> event.getMessageId().equals(message.getId()) && !event.getUserId().equals(event.getJDA().getSelfUser().getId()) && actions.containsKey(event.getReactionEmote().getEmoji()),
                event -> {
                    if (deleteMessageWhenReact) message.delete().queue();
                    actions.get(event.getReactionEmote().getEmoji()).run();
                },
                1, TimeUnit.MINUTES, onTimedOut
        );
    }

}
