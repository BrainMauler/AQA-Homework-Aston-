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

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MtsTest {
    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[6]/main/div/div[2]/div/div[2]/button[2]")).click();   //Кукисы не едим...

    }

    @Order(1)
    @Test
    @Description("Тест на название блока")
    void blockNameTest() {
        assertEquals("Онлайн пополнение\nбез комиссии", driver.findElement(By.xpath("//div[@class=\"pay__wrapper\"]//h2")).getText(),"Тест на название блока провален");
    }

    @Order(2)
    @ParameterizedTest
    @Description("Тест на наличие логотипов платежных систем")
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void logoExistTest(String num) {
        assertNotNull(driver.findElement(By.xpath("//div[@class=\"pay__partners\"]//ul//li[" + num + "]")));
        //Здесь можно было взять любое другое утверждение, т.к. при отсутствии эл-та высший приоритет имеет
        //исключение о несущ. эл-та, сообщения с утверждений не воспроизводятся, во всяком случае, у меня так...
    }

    @Order(3)
    @Test
    @Description("Тест на проверку ссылки")
    void linkTest() {
        driver.findElement(By.xpath("//div[@class=\"pay__wrapper\"]//a")).click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl(), "Ссылка ведет не туда, куда нужно");
    }

    @Order(4)
    @Description("Тест на проверку платежной формы(поля + кнопка Продолжить)")
    void payFormTest() {
        driver.get("https://mts.by"); // В предыдущем тесте драйвер открыл другую страницу. Возвращаем на старт.

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement phone = driver.findElement(By.xpath("//input[@id=\"connection-phone\"]"));
        phone.click();
        phone.sendKeys("297777777");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement amount = driver.findElement(By.xpath("//input[@id=\"connection-sum\"]"));
        amount.click();
        amount.sendKeys("777");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement email = driver.findElement(By.xpath("//input[@id=\"connection-email\"]"));
        email.click();
        email.sendKeys("test-box@mail.ru");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement button = driver.findElement(By.xpath("//div[@class=\"pay__forms\"]//form[@class=\"pay-form opened\"]//button[@class=\"button button__default \"]"));
        button.click();

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class = \"bepaid-iframe\"]"));
        driver.switchTo().frame(iframe);
        assertEquals("777.00 BYN", driver.findElement(By.xpath("//span[contains(text(),\"700.00 BYN\")]")).getText(), "Необходимый эл-т не найден");

    }

    @AfterAll
    public static void quitDriver() {
        driver.quit();
    }

}
