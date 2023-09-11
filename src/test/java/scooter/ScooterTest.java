package scooter;

import org.junit.Before;
import org.junit.Test;
import pageobject.MainPage;
import pageobject.OrderPage;
import pageobject.AccordionPage;

public class ScooterTest extends BaseTest {
    MainPage mainPage;
    @Before
    public void init() {
        mainPage = new MainPage(driver);
    }
    @Test
    public void testAccordion() {
        AccordionPage accordionPage = new AccordionPage(driver);
        accordionPage.scrollToAccordion();
        accordionPage.checkAllAccordionTexts();
    }

    @Test
    public void testOrderScooterTopButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickTopOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillOrderFirstForm();
        orderPage.selectMetroStation("Красносельская");
        orderPage.clickNextButton();

        orderPage.selectDate("Сегодня");
        orderPage.selectRentalPeriod("на сутки");
        orderPage.clickFinalOrderButton();

        orderPage.checkSuccessMessageDisplayed();
    }

    @Test
    public void testOrderScooterBottomButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBottomOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillOrderSecondForm();
        orderPage.selectMetroStation("Красносельская");
        orderPage.clickNextButton();

        orderPage.selectDate("Сегодня");
        orderPage.selectRentalPeriod("на сутки");
        orderPage.clickFinalOrderButton();

        orderPage.checkSuccessMessageDisplayed();
    }
}