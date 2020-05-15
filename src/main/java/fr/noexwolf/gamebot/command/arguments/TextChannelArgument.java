package fr.noexwolf.gamebot.command.arguments;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Optional;
import java.util.regex.Pattern;

public class TextChannelArgument extends PatternArgument<TextChannel> {

    public TextChannelArgument(String name, boolean isRequired) {
        super(name, isRequired, Message.MentionType.CHANNEL.getPattern());
    }

    @Override
    protected TextChannel getTFromArgument(String argument) {
        return null; // TODO
    }
}
