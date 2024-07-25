import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class IFrame extends PagePattern {
    public IFrame(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//iframe[@class = \"bepaid-iframe\"]")
    private WebElement iframe;

    @FindBy(xpath = "(//div[@class='pay-description__cost']/span)[1]")
    private WebElement paymentConfirmTitle;

    @FindBy(xpath = "(//div[@class='pay-description__text']/span)[1]")
    private WebElement titleNumber;

    @FindBy(className = "header__close-icon")
    private WebElement closeButton;

    @FindBy(xpath = "//button[@class='colored disabled']")
    private WebElement payButton;

    @FindBy(xpath = "//label[@class = 'ng-tns-c46-1 ng-star-inserted']")
    private WebElement cardNumber;

    @FindBy(xpath = "//label[@class = 'ng-tns-c46-4 ng-star-inserted']")
    private WebElement validDate;

    @FindBy(xpath = "//label[@class = 'ng-tns-c46-3 ng-star-inserted']")
    private WebElement ownerName;

    @FindBy(xpath = "//label[@class = 'ng-tns-c46-5 ng-star-inserted']")
    private WebElement CVC;

    @FindBy(xpath = "//div[@class='cards-brands ng-tns-c46-1']//img")
    private List<WebElement> logos;

    public String getPaymentText() {
        waiting();
        return paymentConfirmTitle.getText();
    }

    public int logosQuant() {
        return logos.size();
    }

    public List<String> getPlaceholders() {
        waiting();
        List<String> placeholders = new ArrayList<>();
        placeholders.add(paymentConfirmTitle.getText());
        placeholders.add(titleNumber.getText());
        placeholders.add(cardNumber.getText());
        placeholders.add(validDate.getText());
        placeholders.add(ownerName.getText());
        placeholders.add(CVC.getText());
        placeholders.add(payButton.getText());
        return placeholders;
    }

    public void closeIframe() {
        closeButton.click();
        getWebDriver().switchTo().defaultContent();
    }

}
