package web.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommonClient {

    protected String baseHost;
    protected String hostProperty;

    protected Map<String, String> headers = new HashMap<>();

    protected CommonClient() {
    }

    protected CommonClient(Map<String, String> headers) {
        this.headers = headers;
    }

    protected void loadHost(){
        Properties prop = new Properties();
        try {
            prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("backendConfig.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.baseHost = prop.getProperty(this.hostProperty);
    }
}
