package scooter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageobject.MainPage;
import pageobject.OrderPage;

public class OrderScooterBottomButtonTest extends BaseTest {
    MainPage mainPage;
    @Before
    public void init() {
        mainPage = new MainPage(driver);
    }
    @Test
    public void testOrderScooterBottomButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBottomOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillOrderSecondForm("Ирина", "Петрова", "Кантемиров 32", "+79091233579");
        orderPage.selectMetroStation("Красносельская");
        orderPage.clickNextButton();

        orderPage.selectDate("Сегодня");
        orderPage.selectRentalPeriod("на сутки");
        orderPage.clickFinalOrderButton();

        String message = orderPage.getSuccessMessageText();
        Assert.assertEquals("Заказ оформлен!", message);
    }
}
