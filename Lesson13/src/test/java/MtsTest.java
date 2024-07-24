import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest extends TestPat {
    public static WebDriver driver;
    private final String number = "297777777";
    private final String sum = "300";
    private final String email = "test-box@mail.ru";
    private final String url = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

    @Test
    @Description("Проверка названия блока")
    void moduleNameTest() {
        assertEquals("Онлайн пополнение\nбез комиссии", getPaymentBlock().getBlockName(), "Тест на название блока провален");
    }

    @Test
    @Description("Проверка ссылки")
    void linkTest() {
        assertEquals(url, getPaymentBlock().getLinkUrl(),
                "Тест ссылки провален");
        getPaymentBlock().getBack();
    }

    @Test
    @Description("Проверка логотипов платежных систем")
    void logosTest(){
        assertEquals(5, getPaymentBlock().logosQuant(), "Тест на логотипы провален");
    }

    @Test
    @Description("Проверка кнопки плвтежного блока")
    void continueButtonTest() {
        PaymentBlock Sender = getPaymentBlock().iFrameSend(number, sum, email);
        getPaymentBlock().waiting();
        assertEquals(sum + ".00 BYN", Sender.getPaymentConfirmTitleText(),
                "Тест на кнопку платежного блока провален");

    }

}
