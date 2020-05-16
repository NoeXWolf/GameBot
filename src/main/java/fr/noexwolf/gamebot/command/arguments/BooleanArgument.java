package fr.noexwolf.gamebot.command.arguments;

import java.util.List;
import java.util.Optional;

public class BooleanArgument extends Argument<Boolean> {

    public BooleanArgument(String name, boolean isRequired) {
        super(name, isRequired);
    }

    public BooleanArgument(String name, boolean isRequired, List<Boolean> possibleValues) {
        super(name, isRequired, possibleValues);
    }

    @Override
    protected Optional<Boolean> retrieveValue(String argument) {
        if (Boolean.parseBoolean(argument) || argument.equalsIgnoreCase("false")) {
            return Optional.of(Boolean.parseBoolean(argument));
        }
        return Optional.empty();
    }

}
