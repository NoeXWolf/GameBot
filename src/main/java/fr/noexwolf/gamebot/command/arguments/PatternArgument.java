package fr.noexwolf.gamebot.command.arguments;

import java.util.Optional;
import java.util.regex.Pattern;

public abstract class PatternArgument<T> extends Argument<T> {

    public final Pattern pattern;

    public PatternArgument(String name, boolean isRequired, Pattern pattern) {
        super(name, isRequired);
        this.pattern = pattern;
    }

    protected abstract T getTFromArgument(String argument);

    @Override
    protected final Optional<T> retrieveValue(String argument) {
        if (pattern.matcher(argument).matches()) return Optional.of(getTFromArgument(argument));
        return Optional.empty();
    }

}
