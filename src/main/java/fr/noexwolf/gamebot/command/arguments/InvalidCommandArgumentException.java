package fr.noexwolf.gamebot.command.arguments;

public class InvalidCommandArgumentException extends Exception {

    public InvalidCommandArgumentException(String value, Class<?> argumentClass) {
        super("Argument " + value + " is not valid for type " + argumentClass.getName() + ".");
    }

}
