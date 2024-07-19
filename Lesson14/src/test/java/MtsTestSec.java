import jdk.jfr.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MtsTestSec {
    public static WebDriver driver;

    @BeforeAll
    @Description("Предтестовая настройка драйвера и закрытие кукисов")
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://mts.by");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[6]/main/div/div[2]/div/div[2]/button[2]")).click();
    }

    @Order(1)
    @Test
    @Description("Проверка плейсхолдеров полей")
    void placeholdersTest(){
        driver.switchTo().defaultContent();   //Дефолтинг драйвера после тестов
        //Услуги связи
        driver.findElement(By.xpath("//button[@class=\"select__header\"]")).click();
        driver.findElement(By.xpath("//p[contains(text(),\"Услуги связи\")]")).click();

        WebElement phone1 = driver.findElement(By.xpath("//input[@id=\"connection-phone\"]"));
        String phone1Ph = phone1.getAttribute("placeholder");
        assertEquals("Номер телефона", phone1Ph);

        WebElement sum1 = driver.findElement(By.xpath("//input[@id=\"connection-sum\"]"));
        String sum1Ph = sum1.getAttribute("placeholder");
        assertEquals("Сумма", sum1Ph);

        WebElement email1 = driver.findElement(By.xpath("//input[@id=\"connection-email\"]"));
        String email1Ph = email1.getAttribute("placeholder");
        assertEquals("E-mail для отправки чека", email1Ph);

        //Домашний интернет
        driver.findElement(By.xpath("//button[@class=\"select__header\"]")).click();
        driver.findElement(By.xpath("//p[contains(text(),\"Домашний интернет\")]")).click();

        WebElement phone2 = driver.findElement(By.xpath("//input[@id=\"internet-phone\"]"));
        String phone2Ph = phone2.getAttribute("placeholder");
        assertEquals("Номер абонента", phone2Ph);

        WebElement sum2 = driver.findElement(By.xpath("//input[@id=\"internet-sum\"]"));
        String sum2Ph = sum2.getAttribute("placeholder");
        assertEquals("Сумма", sum2Ph);

        WebElement email2 = driver.findElement(By.xpath("//input[@id=\"internet-email\"]"));
        String email2Ph = email2.getAttribute("placeholder");
        assertEquals("E-mail для отправки чека", email2Ph);

        //Рассрочка
        driver.findElement(By.xpath("//button[@class=\"select__header\"]")).click();
        driver.findElement(By.xpath("//p[contains(text(),\"Рассрочка\")]")).click();

        WebElement phone3 = driver.findElement(By.xpath("//input[@id=\"score-instalment\"]"));
        String phone3Ph = phone3.getAttribute("placeholder");
        assertEquals("Номер счета на 44", phone3Ph);

        WebElement sum3 = driver.findElement(By.xpath("//input[@id=\"instalment-sum\"]"));
        String sum3Ph = sum3.getAttribute("placeholder");
        assertEquals("Сумма", sum3Ph);

        WebElement email3 = driver.findElement(By.xpath("//input[@id=\"instalment-email\"]"));
        String email3Ph = email3.getAttribute("placeholder");
        assertEquals("E-mail для отправки чека", email3Ph);

        //Задолженоость
        driver.findElement(By.xpath("//button[@class=\"select__header\"]")).click();
        driver.findElement(By.xpath("//p[contains(text(),\"Задолженность\")]")).click();

        WebElement number = driver.findElement(By.xpath("//input[@id=\"score-arrears\"]"));
        String numberPh = number.getAttribute("placeholder");
        assertEquals("Номер счета на 2073", numberPh);

        WebElement sum4 = driver.findElement(By.xpath("//input[@id=\"arrears-sum\"]"));
        String sum4Ph = sum4.getAttribute("placeholder");
        assertEquals("Сумма", sum4Ph);

        WebElement email4 = driver.findElement(By.xpath("//input[@id=\"arrears-email\"]"));
        String email4Ph = email4.getAttribute("placeholder");
        assertEquals("E-mail для отправки чека", email4Ph);
    }

    @Order(2)
    @Description("проверка фрейма подтверждения оплаты услуг связи")
    @Test
    void connectServConfTest(){
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//button[@class=\"select__header\"]")).click();
        driver.findElement(By.xpath("//p[contains(text(),\"Услуги связи\")]")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement phone = driver.findElement(By.xpath("//input[@id=\"connection-phone\"]"));
        phone.click();
        phone.sendKeys("297777777");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement amount = driver.findElement(By.xpath("//input[@id=\"connection-sum\"]"));
        amount.click();
        amount.sendKeys("300");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement email = driver.findElement(By.xpath("//input[@id=\"connection-email\"]"));
        email.click();
        email.sendKeys("test-box@mail.ru");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class=\"pay__forms\"]//form[@class=\"pay-form opened\"]//button[@class=\"button button__default \"]")).click();

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class = \"bepaid-iframe\"]"));
        driver.switchTo().frame(iframe);
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

        //Шапка с суммой оплаты
        assertEquals("300.00 BYN", driver.findElement(By.xpath("//span[contains(text(),\"300.00 BYN\")]")).getText());

        //Строка с номером телефона
        assertEquals("Оплата: Услуги связи Номер:375297777777", driver.findElement(By.xpath("//span[contains(text(),\"Оплата: Услуги связи\")]")).getText());

        //Строки заполнения полей карты
        assertEquals("Номер карты", driver.findElement(By.xpath("//label[@class=\"ng-tns-c46-1 ng-star-inserted\"]")).getText());
        assertEquals("Срок действия", driver.findElement(By.xpath("//label[@class=\"ng-tns-c46-4 ng-star-inserted\"]")).getText());
        assertEquals("CVC", driver.findElement(By.xpath("//label[@class=\"ng-tns-c46-5 ng-star-inserted\"]")).getText());
        assertEquals("Имя держателя (как на карте)", driver.findElement(By.xpath("//label[@class=\"ng-tns-c46-3 ng-star-inserted\"]")).getText());

        //Логотипы платежных систем
        assertNotNull(driver.findElement(By.xpath("//img[@src=\"assets/images/payment-icons/card-types/mastercard-system.svg\"]")));
        assertNotNull(driver.findElement(By.xpath("//img[@src=\"assets/images/payment-icons/card-types/visa-system.svg\"]")));
        assertNotNull(driver.findElement(By.xpath("//img[@src=\"assets/images/payment-icons/card-types/belkart-system.svg\"]")));
        assertNotNull(driver.findElement(By.xpath("//div[@class=\"cards-brands cards-brands_random ng-tns-c61-0 ng-star-inserted\"]//img[1]")));
        assertNotNull(driver.findElement(By.xpath("//div[@class=\"cards-brands cards-brands_random ng-tns-c61-0 ng-star-inserted\"]//img[2]")));

        //Заполняем форму карты, чтобы открыть кнопку подтверждения оплаты, потом проаеряем кнопку
        WebElement ccNumber = driver.findElement(By.xpath("//input[@id=\"cc-number\"]"));
        ccNumber.click();
        ccNumber.sendKeys("5112 2353 9556 5076");
        WebElement expirDate = driver.findElement(By.xpath("//input[@formcontrolname=\"expirationDate\"]"));
        expirDate.click();
        expirDate.sendKeys("03 / 28");
        WebElement cvc = driver.findElement(By.xpath("//input[@formcontrolname=\"cvc\"]"));
        cvc.click();
        cvc.sendKeys("526");
        WebElement holder = driver.findElement(By.xpath("//input[@formcontrolname=\"holder\"]"));
        holder.click();
        holder.sendKeys("IVAN IVANOV");

        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        assertEquals("Оплатить 300.00 BYN", driver.findElement(By.xpath("//button[@type=\"submit\"][@class=\"colored\"]")).getText());

    }

    @AfterAll
    @Description("Посттестовое закрытие драйвера")
    public static void exit(){
        driver.quit();
    }
}
