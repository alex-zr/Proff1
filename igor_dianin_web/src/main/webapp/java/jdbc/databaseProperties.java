package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class databaseProperties {

    private String URL;
    private String USER;
    private String PASSWORD;

    public databaseProperties() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("database.properties");

        Properties props = new Properties();
        try {
            props.load(is);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

        URL = props.getProperty("database.url");
        USER = props.getProperty("database.user");
        PASSWORD = props.getProperty("database.password");
    }

    public String getURL() {
        return URL;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }
}
