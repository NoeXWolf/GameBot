package fr.noexwolf.gamebot.command.arguments;

import net.dv8tion.jda.api.entities.Member;

import java.util.Optional;

public class MemberArgument extends Argument<Member> {

    public MemberArgument(String name, boolean isRequired) {
        super(name, isRequired);
    }

    @Override
    protected Optional<Member> retrieveValue(String argument) {
        return Optional.empty();
        // TODO
    }

}
