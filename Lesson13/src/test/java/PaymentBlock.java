import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PaymentBlock extends PagePat{

    public PaymentBlock(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[6]/main/div/div[2]/div/div[2]/button[2]")
    private WebElement cookiesDec;

    @FindBy(xpath = "//div[@class=\"pay__wrapper\"]//h2")
    private WebElement blockName;

    @FindBy(xpath = "//div[@class=\"pay__wrapper\"]//a")
    private WebElement link;

    @FindBy(xpath = "//div[@class='pay__partners']//img")
    private List<WebElement> logos;

    @FindBy(xpath = "//input[@id=\"connection-phone\"]")
    private WebElement paymentNumber;

    @FindBy(xpath = "//input[@id=\"connection-sum\"]")
    private WebElement paymentSum;

    @FindBy(xpath = "//input[@id=\"connection-email\"]")
    private WebElement paymentEmail;

    @FindBy(xpath = "//div[@class=\"pay__forms\"]//form[@class=\"pay-form opened\"]//button[@class=\"button button__default \"]")
    private WebElement continueButton;

    @FindBy(xpath = "//iframe[@class = \"bepaid-iframe\"]")
    private WebElement iframe;

    @FindBy(xpath = "(//div[@class='pay-description__cost']/span)[1]")
    private WebElement paymentConfirmTitle;

    public void cookiesDecline() {
        waiting();
        cookiesDec.click();
    }

    public String getBlockName() {
        return blockName.getText();
    }

    public int logosQuant() {
        return logos.size();
    }

    public String getLinkUrl() {
        link.click();
        return getWebDriver().getCurrentUrl();
    }

    public PaymentBlock iFrameSend(String number, String sum, String email) {
        paymentNumber.sendKeys(number);
        paymentSum.sendKeys(sum);
        paymentEmail.sendKeys(email);
        continueButton.click();
        waiting();
        getWebDriver().switchTo().frame(iframe);
        return new PaymentBlock(getWebDriver());
    }

    public String getPaymentConfirmTitleText(){
        waiting();
        return paymentConfirmTitle.getText();
    }

    public void getBack() {
        getWebDriver().navigate().back();
    }

}
