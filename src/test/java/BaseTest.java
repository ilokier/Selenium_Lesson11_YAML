import Configuration.AppProperties;
import Models.BrowserEnvironment;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BaseTest {
    protected static WebDriver driver;
    private static Logger log = LoggerFactory.getLogger("BaseTest.class");
    protected static BrowserEnvironment browserEnvironment;
    private static AppProperties appProperties;

    @BeforeAll
    static void beforeAll() {
        appProperties = AppProperties.getInstance();
        browserEnvironment = new BrowserEnvironment();
        driver = browserEnvironment.getDriver();
        log.info("<<<<<Driver initialized>>>");
        driver.get(System.getProperty("appUrl"));
    }

    @AfterAll
    static void quit() {
        driver.quit();
        log.debug("<<<<<<driver closed properly>>>>>");
    }
}
