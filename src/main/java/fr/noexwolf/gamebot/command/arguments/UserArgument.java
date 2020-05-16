package fr.noexwolf.gamebot.command.arguments;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

import java.util.List;

public class UserArgument extends PatternArgument<User> {

    public UserArgument(String name, boolean isRequired) {
        super(name, isRequired, Message.MentionType.USER.getPattern());
    }

    public UserArgument(String name, boolean isRequired, List<User> possibleValues) {
        super(name, isRequired, Message.MentionType.USER.getPattern(), possibleValues);
    }

    @Override
    protected User getTFromArgument(String argument) {
        return null; // TODO
    }

}
