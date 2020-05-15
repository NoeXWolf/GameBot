package fr.noexwolf.gamebot.command.arguments;

import java.util.Optional;

public class StringArgument extends Argument<String> {

    public StringArgument(String name, boolean isRequired) {
        super(name, isRequired);
    }

    @Override
    protected Optional<String> retrieveValue(String argument) {
        return Optional.of(argument);
    }

}
