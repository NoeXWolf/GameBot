package fr.noexwolf.gamebot.command.arguments;

import java.util.Optional;

public class BooleanArgument extends Argument<Boolean> {

    public BooleanArgument(String name, boolean isRequired) {
        super(name, isRequired);
    }

    @Override
    protected Optional<Boolean> retrieveValue(String argument) {
        if (Boolean.parseBoolean(argument) || argument.equalsIgnoreCase("false")) {
            return Optional.of(Boolean.parseBoolean(argument));
        }
        return Optional.empty();
    }

}
