package scooter;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    @Before
    public void setUp() {

        driver = new WebDriverFactory().createDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void clean() {
        driver.quit();
    }
}
