package fr.noexwolf.gamebot.command.arguments;

public class MissingCommandArgumentException extends Exception {

    public MissingCommandArgumentException(Argument<?> argument) {
        super("Missing argument " + argument.getName() + ".");
    }

}
