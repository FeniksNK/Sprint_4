package pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OrderPage {
    private final WebDriver driver;

    private final By firstNameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]");
    private final By lastNameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]");
    private final By addressField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]");
    private final By metroStationDropdown = By.xpath(".//*[contains(text(),'Красносельская')]");
    private final By phoneField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]");
    private final By nextButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");
    private final By dateDropdown = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[1]");
    private final By rentalPeriodDropdown = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]");
    private final By finalOrderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    private final By successMessage = By.xpath("/html/body/div/div/div[2]/div[5]");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    public void fillOrderFirstForm() {
        driver.findElement(firstNameField).sendKeys("Иван");
        driver.findElement(lastNameField).sendKeys("Иванов");
        driver.findElement(addressField).sendKeys("Ленинградский проспект 80к1");
        driver.findElement(phoneField).sendKeys("+79091234567");
    }

    public void selectMetroStation(String stationName) {
        Select select = new Select(driver.findElement(metroStationDropdown));
        select.selectByVisibleText(stationName);
    }
    public void selectDate(String date) {
        driver.findElement(dateDropdown).click();
        driver.findElement(By.xpath("//div[contains(@aria-label, '" + date +"')]")).click();
    }
    public void selectRentalPeriod(String period) {
        Select select = new Select(driver.findElement(rentalPeriodDropdown));
        select.selectByVisibleText(period);
    }
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    public void clickFinalOrderButton() {
        driver.findElement(finalOrderButton).click();
    }
    public void checkSuccessMessageDisplayed() {
        Assert.assertTrue(driver.findElement(successMessage).isDisplayed());
    }
    public void fillOrderSecondForm() {
        driver.findElement(firstNameField).sendKeys("Ирина");
        driver.findElement(lastNameField).sendKeys("Копцева");
        driver.findElement(addressField).sendKeys("Ленинградский проспект 80");
        driver.findElement(phoneField).sendKeys("+79031234560");
    }
}
