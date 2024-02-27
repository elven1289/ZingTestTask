package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

/***
 * This class is used to provide driver instances for classes used in testing
 * It setups browserstack configuration from either prepared values
 * or from browserstack.yaml that is used to provide certain properties
 */
public class BrowserStackDriverProvider {

    public static BrowserStackDriverProvider provider = new BrowserStackDriverProvider();
    private static AndroidDriver driver;
    private String userName;
    private String accessKey;
    private UiAutomator2Options options;
    private Map<String, Object> browserStackYamlMap;
    private final String USER_DIR = "user.dir";

    /**
     * The method is used to standardize tearDown process
     * Invoke driver.quit() to indicate that the test is completed.
     * Otherwise, it will appear as timed out on BrowserStack.
     */
    public static void tearDown() {
        driver.quit();
        driver = null;
    }

    /**
     * This is sole point for the user to request driver instance from provider.
     * Will initialize driver if it is not initialized
     *
     * @return instance of a driver
     */
    public static AndroidDriver getDriver() {
        if (driver == null) {
            provider.setUp();
        }
        return driver;
    }

    /**
     * Constructor that is used to init singleton instance of provider
     */
    private BrowserStackDriverProvider() {
        File file = new File(System.getProperty(USER_DIR) + "/browserstack.yml");
        browserStackYamlMap = convertYamlFileToMap(file, new HashMap<>());
    }

    /**
     * Internal method that is used to setup instance of a driver
     */
    private void setUp() {
        options = new UiAutomator2Options();
        userName = System.getenv("BROWSERSTACK_USERNAME") != null ? System.getenv("BROWSERSTACK_USERNAME") : (String) browserStackYamlMap.get("userName");
        accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY") != null ? System.getenv("BROWSERSTACK_ACCESS_KEY") : (String) browserStackYamlMap.get("accessKey");
        options.setCapability("appium:app", "bs://sample.app");
        options.setCapability("appium:deviceName", "Samsung Galaxy S22 Ultra");
        options.setCapability("appium:platformVersion", "12.0");
        try {
            driver = new AndroidDriver(new URL(String.format("https://%s:%s@hub.browserstack.com/wd/hub", userName, accessKey)), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, Object> convertYamlFileToMap(File yamlFile, Map<String, Object> map) {
        try {
            InputStream inputStream = Files.newInputStream(yamlFile.toPath());
            Yaml yaml = new Yaml();
            Map<String, Object> config = yaml.load(inputStream);
            map.putAll(config);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Malformed browserstack.yml file - %s.", e));
        }
        return map;
    }
}
