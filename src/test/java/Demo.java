import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

    protected WebDriver webdriver;

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        Object WebDriverManager = null;
        WebDriverManager.chromedriver().setup();
        webdriver = new ChromeDriver(options);
    }

    @Test
    public void testDemo() {
        webdriver.get("https://www.google.com");
        // Add assertions here, e.g., assert webdriver.getTitle().contains("Google");
    }

    @AfterMethod
    public void tearDown() {
        if (webdriver != null) {
            webdriver.quit();
        }
    }

}
