package fr.noexwolf.gamebot.command.arguments;

import java.util.Optional;

public abstract class Argument<T> {

    protected T t;
    protected final String name;
    protected final boolean isRequired;

    public Argument(String name, boolean isRequired) {
        this.name = name;
        this.isRequired = isRequired;
    }

    public String getName() {
        return name;
    }

    public boolean isRequired() {
        return isRequired;
    }

//    public abstract boolean isValid(String argument);

    protected abstract Optional<T> retrieveValue(String argument);

    public T getValue(String argument) throws InvalidCommandArgumentException {
        Optional<T> value = retrieveValue(argument);
        if (value.isEmpty()) throw new InvalidCommandArgumentException(argument, t.getClass());
        return value.get();
    }

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
                .append(name)
                .append(closeSymbol);

        return builder.toString();
    }
}
