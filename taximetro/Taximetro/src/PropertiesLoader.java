import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public static String getProperty(String propertyKey) {

        InputStream input = null;
        Properties prop = new Properties();

        try {

            input = new FileInputStream("config.properties");

            prop.load(input);

            return prop.getProperty(propertyKey);

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}