import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public abstract class PagePat {

    private final WebDriver driver;

    public PagePat(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebDriver getWebDriver() {
        return driver;
    }

    public void waiting() {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

}
