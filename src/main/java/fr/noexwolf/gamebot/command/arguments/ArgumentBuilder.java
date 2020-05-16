package fr.noexwolf.gamebot.command.arguments;

import java.util.List;

public class ArgumentBuilder {

    private String name;
    private boolean isRequired;

    public ArgumentBuilder() {

    }

    public ArgumentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ArgumentBuilder setRequired(boolean isRequired) {
        this.isRequired = isRequired;
        return this;
    }

    public StringArgument buildAsStringArgument() {
        return new StringArgument(name, isRequired);
    }

    public IntArgument buildAsIntArgument() {
        return new IntArgument(name, isRequired);
    }

    public FloatArgument buildAsFloatArgument() {
        return new FloatArgument(name, isRequired);
    }

    public BooleanArgument buildAsBooleanArgument() {
        return new BooleanArgument(name, isRequired);
    }

    public TextChannelArgument buildAsTextChannelArgument() {
        return new TextChannelArgument(name, isRequired);
    }

    public UserArgument buildAsUserArgument() {
        return new UserArgument(name, isRequired);
    }

}
