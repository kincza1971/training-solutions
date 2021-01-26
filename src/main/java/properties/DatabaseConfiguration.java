package properties;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class DatabaseConfiguration {
    private final Properties dbProperties = new Properties();

    public String getHost(){
        return dbProperties.getProperty("host","10.80.7.213");
    }
    public String getPort() {
        return dbProperties.getProperty("port", "80");
    }
    public String getSchema() {
        return dbProperties.getProperty("schema");
    }

    public DatabaseConfiguration() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("database.properties"),StandardCharsets.UTF_8));
            dbProperties.load(br);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read properties",e);
        }
    }

    public DatabaseConfiguration(File file) {
        try {
            FileReader fr = new FileReader(file, StandardCharsets.UTF_8);
            dbProperties.load(fr);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read properties",e);
        }
    }
}
