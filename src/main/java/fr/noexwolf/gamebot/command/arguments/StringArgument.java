package fr.noexwolf.gamebot.command.arguments;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class StringArgument extends Argument<String> {

    public StringArgument(String name, boolean isRequired) {
        super(name, isRequired);
    }

    public StringArgument(String name, boolean isRequired, List<String> possibleValues) {
        super(name, isRequired, possibleValues);
    }

    @Override
    protected Optional<String> retrieveValue(String argument) {
        return Optional.of(argument);
    }

}
