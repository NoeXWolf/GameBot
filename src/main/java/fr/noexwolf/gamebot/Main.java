package fr.noexwolf.gamebot;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) {
        try {
            new Bot(System.getenv("GAMEBOT_TOKEN")).start();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
