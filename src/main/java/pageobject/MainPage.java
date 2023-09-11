package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static config.AppConfig.SCOOTER_APP_URL;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        driver.get(SCOOTER_APP_URL);
    }
    private final By orderButtonTop = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]");
    private final By orderButtonBottom = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");

    public void clickTopOrderButton() {
        driver.findElement(orderButtonTop).click();
    }
    public void clickBottomOrderButton() {
        driver.findElement(orderButtonBottom).click();
    }

}
