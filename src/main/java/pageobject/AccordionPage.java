package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.Assert;

import java.util.List;

public class AccordionPage {
    private final WebDriver driver;

    // Локаторы
    private final By accordionSection = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]");
    private final By accordionButtons = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[1]");
    private final By accordionTexts = By.xpath("//*[@id=\"accordion__panel-16\"]");

    public AccordionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToAccordion() {
        WebElement accordionSectionElement = driver.findElement(accordionSection);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", accordionSectionElement);
    }

    public void checkAllAccordionTexts() {
        List<WebElement> accordionButtonsElements = driver.findElements(accordionButtons);
        for(WebElement button : accordionButtonsElements) {
            button.click();
            WebElement text = button.findElement(accordionTexts);
            Assert.assertTrue(text.isDisplayed());
        }
    }
}
