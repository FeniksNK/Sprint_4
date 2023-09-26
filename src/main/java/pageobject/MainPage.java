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
    private final By orderButtonTop = By.xpath("//button[contains(@class, 'Header_Button')]");
    private final By orderButtonBottom = By.xpath("//div[contains(@class, 'Order_ButtonContainer')]//button[contains(@class, 'Button_Button')]");

    public void clickTopOrderButton() {
        driver.findElement(orderButtonTop).click();
    }
    public void clickBottomOrderButton() {
        driver.findElement(orderButtonBottom).click();
    }

}
