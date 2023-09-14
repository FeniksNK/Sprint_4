package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AccordionPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private static final By accordionSection = By.xpath("//div[contains(@class, 'Accordion_Accordion')]");
    private static final By accordionButtons = By.xpath("//button[contains(@class, 'Accordion_Button')]");
    private static final By accordionTexts = By.xpath("//div[contains(@class, 'Accordion_Text')]");

    public AccordionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void scrollToAccordion() {
        WebElement accordionSectionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accordionSection));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", accordionSectionElement);
    }

    public void openQuestion(String questionText) {
        String locator = String.format(questionText, accordionButtons);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        button.click();
    }

    public String getOpenedAnswerText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accordionTexts)).getText();
    }
}
