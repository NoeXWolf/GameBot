package fr.noexwolf.gamebot.command.arguments;

import java.util.Optional;

public abstract class Argument<T> {

//    protected T t;
    protected final String name;
    protected final boolean isRequired;
    protected Optional<T> value;

    public Argument(String name, boolean isRequired) {
        this.name = name;
        this.isRequired = isRequired;
        this.value = Optional.empty();
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

    public void setArgument(String argument) throws InvalidCommandArgumentException {
        if (isRequired) {
            Optional<T> value = retrieveValue(argument);
            if (value.isEmpty()) throw new InvalidCommandArgumentException(argument, value.getClass());
            this.value = value;
        }
    }

    //    public abstract boolean isValid(String argument);

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
                .append(name)
                .append(closeSymbol);

        return builder.toString();
    }
}
