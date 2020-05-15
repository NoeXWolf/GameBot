package fr.noexwolf.gamebot.command.arguments;

import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Optional;

public class TextChannelArgument extends Argument<TextChannel> {

    public TextChannelArgument(String name, boolean isRequired) {
        super(name, isRequired);
    }

    @Override
    protected Optional<TextChannel> retrieveValue(String argument) {
        return Optional.empty();
        // TODO
    }

}
