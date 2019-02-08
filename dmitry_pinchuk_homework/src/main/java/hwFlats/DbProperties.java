package hwFlats;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DbProperties {
    private String url;
    private String user;
    private String password;

    public DbProperties() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("db.properties");
        Properties props = new Properties();
        try {
            props.load(is);

        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        url = props.getProperty("db.url");
        user = props.getProperty("db.user");
        password = props.getProperty("db.password");
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
