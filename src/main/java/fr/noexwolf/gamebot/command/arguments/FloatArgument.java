package fr.noexwolf.gamebot.command.arguments;

import java.util.List;
import java.util.Optional;

public class FloatArgument extends Argument<Float> {

    public FloatArgument(String name, boolean isRequired) {
        super(name, isRequired);
    }

    public FloatArgument(String name, boolean isRequired, List<Float> possibleValues) {
        super(name, isRequired, possibleValues);
    }

    @Override
    protected Optional<Float> retrieveValue(String argument) {
        try {
            return Optional.of(Float.parseFloat(argument));
        } catch (NumberFormatException ignored) {
            return Optional.empty();
        }
    }

}
