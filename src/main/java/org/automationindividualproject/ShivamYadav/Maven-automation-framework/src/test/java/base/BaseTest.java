package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Base class for UI tests.
 * Manages TestNG lifecycle and a protected WebDriver instance used by test classes.
 */
public class BaseTest {

    /**
     * Shared WebDriver instance for tests. Initialized in {@link #setUp()} and
     * closed in {@link #tearDown()}.
     */
    protected static WebDriver driver; 

    /**
     * Initialize the WebDriver (Chrome), set timeouts, maximize window,
     * and navigate to the application login page.
     */
    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


    }

    /**
     * Quit the WebDriver to clean up resources after each test.
     */
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public void onSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onSuccess'");
    }

}
