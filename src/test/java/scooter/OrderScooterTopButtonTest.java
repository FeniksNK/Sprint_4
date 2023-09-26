package scooter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageobject.MainPage;
import pageobject.OrderPage;

public class OrderScooterTopButtonTest extends BaseTest {
    MainPage mainPage;
    @Before
    public void init() {
        mainPage = new MainPage(driver);
    }
    @Test
    public void testOrderScooterTopButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickTopOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillOrderFirstForm("Иван", "Иванов", "Ленинградский 80к1", "+79091234568");
        orderPage.selectMetroStation("Красносельская");
        orderPage.clickNextButton();

        orderPage.selectDate("Сегодня");
        orderPage.selectRentalPeriod("на сутки");
        orderPage.clickFinalOrderButton();

        String message = orderPage.getSuccessMessageText();
        Assert.assertEquals("Заказ оформлен!", message);
    }
}
