import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;

@Epic("Web Testing")
@Feature("Landing Page Validation")
public class Demo {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
    }

    @Test
    @Story("Google landing page")
    @Owner("qa-team")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Opens Google and validates page title")
    public void testGoogleLandingPage() {
        driver.get("https://www.google.com");
        assert driver.getTitle().contains("Google");
    }

    @Test
    @Story("GitHub landing page")
    @Owner("qa-team")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Opens GitHub and validates page title")
    public void testGitHubLandingPage() {
        driver.get("https://github.com");
        assert driver.getTitle().contains("GitHub");
    }

    @Test
    @Story("Stack Overflow landing page")
    @Owner("qa-team")
    @Severity(SeverityLevel.NORMAL)
    @Description("Opens Stack Overflow and validates page title")
    public void testStackOverflowLandingPage() {
        driver.get("https://stackoverflow.com");
        assert driver.getTitle().contains("Stack Overflow");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}