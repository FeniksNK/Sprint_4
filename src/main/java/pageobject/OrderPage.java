package pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OrderPage {
    private final WebDriver driver;

    private final By firstNameField = By.xpath("//input[contains(@placeholder, 'Имя')]");
    private final By lastNameField = By.xpath("//input[contains(@placeholder, 'Фамилия')]");
    private final By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStationDropdown = By.xpath(".//*[contains(text(),'Красносельская')]");
    private final By phoneField = By.xpath("//input[@placeholder='+7 (999) 999-99-99']");
    private final By nextButton = By.xpath("//button[contains(text(), 'Далее')]");
    private final By dateDropdown = By.xpath("//div[contains(@class, 'Datepicker_Datepicker')]");
    private final By rentalPeriodDropdown = By.xpath("//div[contains(@class, 'Select_Select__1NC7B') and contains(@class, 'Order_RentalPeriodSelect')]");
    private final By finalOrderButton = By.xpath("//button[contains(text(), 'Заказать')]");
    private final By successMessage = By.xpath("//div[contains(@class, 'Modal_ModalHeader') and text()='Заказ оформлен!']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillOrderFirstForm(String firstName, String lastName, String address, String phone) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(phoneField).sendKeys(phone);
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
    public String getSuccessMessageText() {
        return driver.findElement(successMessage).getText();
    }
    public void fillOrderSecondForm(String firstName, String lastName, String address, String phone) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(phoneField).sendKeys(phone);
    }
}
