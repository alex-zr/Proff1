package prog.kiev.ua.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class AuthData {
    private String login;
    private String password;

    public AuthData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String toJSON() {
        Gson gson = new GsonBuilder().create();

        return gson.toJson(this);
    }

    public int sendData(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection)
                obj.openConnection();

        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            String json = toJSON();
            os.write(json.getBytes(StandardCharsets.UTF_8));

            return conn.getResponseCode();
        }

    }
}
