package fr.noexwolf.gamebot.command.arguments;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class Argument<T> {

//    protected T t;
    protected final String name;
    protected final boolean isRequired;
    protected Optional<T> value;
    protected List<T> possibleValues;

    public Argument(String name, boolean isRequired) {
        this(name, isRequired, Collections.emptyList());
    }

    public Argument(String name, boolean isRequired, List<T> possibleValues) {
        this.name = name;
        this.isRequired = isRequired;
        this.value = Optional.empty();
        this.possibleValues = possibleValues;
    }

    public String getName() {
        return name;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public Optional<T> getValue() {
        return value;
    }

    public List<T> getPossibleValues() {
        return possibleValues;
    }

    public void setArgument(String argument) throws InvalidCommandArgumentException, MissingCommandArgumentException {
        Optional<T> optionalValue = retrieveValue(argument);
        if (optionalValue.isEmpty()) {
            if (isRequired) {
                throw new MissingCommandArgumentException(this);
            }
        } else {
            if (!isValid(optionalValue.get())) {
                throw new InvalidCommandArgumentException(argument, optionalValue.get().getClass());
            }
        }
        this.value = optionalValue;
    }

    public boolean isValid(T value) {
        return possibleValues.contains(value);
    }

    protected abstract Optional<T> retrieveValue(String argument);

    @Override
    public String toString() {
        char openSymbol = '<';
        char closeSymbol = '>';

        if (!isRequired) {
            openSymbol = '[';
            closeSymbol = ']';
        }

        StringBuilder builder = new StringBuilder()
                .append(openSymbol)
                .append(name);

        if (!possibleValues.isEmpty()) {
            builder.append(": ");
            String stringValues = possibleValues.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            builder.append(stringValues);
        }

        builder.append(closeSymbol);

        return builder.toString();
    }
}
