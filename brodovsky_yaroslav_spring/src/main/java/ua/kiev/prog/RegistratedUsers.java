package ua.kiev.prog;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Scope("singleton")
public class RegistratedUsers {
    private static Map<String, String> users = new ConcurrentHashMap<>();

    public static void newUser(String login, String password) {
        users.put(login, password);
    }

    public static String getPassword(String login) {
        return users.get(login);
    }

    public static int checkLogin(String login) {
        if (users.get(login) != null) {
            return 0;
        }

        return 1;
    }
}
