import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestPat {

    protected WebDriver driver;
    protected PaymentBlock paymentBlock;
    protected final String url = "https://www.mts.by/";

    @BeforeEach
    protected void beforeTest() {
        DriverSetup();
        driver.get(url);
        paymentBlock = new PaymentBlock(driver);
        paymentBlock.cookiesDecline();
    }

    public PaymentBlock getPaymentBlock() {
        return paymentBlock;
    }

    public void DriverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterEach
    protected void afterTest() {
        driver.quit();
    }

}
