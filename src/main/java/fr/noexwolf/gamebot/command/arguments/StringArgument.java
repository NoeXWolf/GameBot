package fr.noexwolf.gamebot.command.arguments;

import java.util.List;
import java.util.Optional;

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

    @Override
    public boolean isValid(String value) {
        for (String possibleValue : possibleValues) {
            if (value.equalsIgnoreCase(possibleValue)) return true;
        }
        return false;
    }

}
