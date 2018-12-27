package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class databaseCustomerProperties {

       private String URL;
       private String USER;
       private String PASSWORD;

       public databaseCustomerProperties(){
           InputStream inputStream = getClass().getClassLoader().getResourceAsStream(
                   "databaseCustomer.properties");

           Properties properties = new Properties();
           try {
               properties.load(inputStream);
           } catch (IOException e) {
               System.out.println("can't lod properties");
           }

           URL = properties.getProperty("database.url");
           USER = properties.getProperty("database.user");
           PASSWORD = properties.getProperty("database.password");
       }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
}
