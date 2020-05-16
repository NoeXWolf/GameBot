package fr.noexwolf.gamebot.command.arguments;

import java.util.List;
import java.util.Optional;

public class IntArgument extends Argument<Integer> {

    public IntArgument(String name, boolean isRequired) {
        super(name, isRequired);
    }

    public IntArgument(String name, boolean isRequired, List<Integer> possibleValues) {
        super(name, isRequired, possibleValues);
    }

    @Override
    protected Optional<Integer> retrieveValue(String argument) {
        try {
            return Optional.of(Integer.parseInt(argument));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

}
