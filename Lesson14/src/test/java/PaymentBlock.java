import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class PaymentBlock extends PagePattern {
    public PaymentBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/div[6]/main/div/div[2]/div/div[2]/button[2]")
    private WebElement cookiesDec;

    @FindBy(className = "select__wrapper")
    private WebElement chooserButton;

    @FindBy(id = "connection-phone")
    private WebElement paymentNumber;

    @FindBy(id = "connection-sum")
    private WebElement paymentSum;

    @FindBy(id = "connection-email")
    private WebElement paymentEmail;

    @FindBy(id = "internet-phone")
    private WebElement internetNumber;

    @FindBy(id = "internet-sum")
    private WebElement internetSum;

    @FindBy(id = "internet-email")
    private WebElement internetEmail;

    @FindBy(id = "score-instalment")
    private WebElement instalmentNumber;

    @FindBy(id = "instalment-sum")
    private WebElement instalmentSum;

    @FindBy(id = "instalment-email")
    private WebElement instalmentEmail;

    @FindBy(id = "score-arrears")
    private WebElement arrearsNumber;

    @FindBy(id = "arrears-sum")
    private WebElement arrearsSum;

    @FindBy(id = "arrears-email")
    private WebElement arrearsEmail;

    @FindBy(xpath = "//div[@class=\"pay__forms\"]//form[@class=\"pay-form opened\"]//button[@class=\"button button__default \"]")
    private WebElement continueButton;

    @FindBy(xpath = "//iframe[@class = \"bepaid-iframe\"]")
    private WebElement iframe;

    void choosePaymentType(String type) {
        Actions action = new Actions(getWebDriver());
        WebElement paymentType = getWebDriver().findElement(By.xpath("//p[text()='" + type + "']"));
        chooserButton.click();
        waiting();
        action.moveToElement(paymentType)
                .click()
                .build()
                .perform();
    }

    String getPlaceholderAttr(WebElement webElement) {
        return webElement.getAttribute("placeholder");
    }

    public ArrayList<String> checkPlaceholderText(String type) {

        ArrayList<String> placeholders = new ArrayList<>();

        switch (type) {

            case ("phone"):
                choosePaymentType("Услуги связи");
                placeholders.add(getPlaceholderAttr(paymentNumber));
                placeholders.add(getPlaceholderAttr(paymentSum));
                placeholders.add(getPlaceholderAttr(paymentEmail));
                break;

            case ("internet"):
                choosePaymentType("Домашний интернет");
                placeholders.add(getPlaceholderAttr(internetNumber));
                placeholders.add(getPlaceholderAttr(internetSum));
                placeholders.add(getPlaceholderAttr(internetEmail));
                break;

            case ("instalment"):
                choosePaymentType("Рассрочка");
                placeholders.add(getPlaceholderAttr(instalmentNumber));
                placeholders.add(getPlaceholderAttr(instalmentSum));
                placeholders.add(getPlaceholderAttr(instalmentEmail));
                break;

            case ("arrears"):
                choosePaymentType("Задолженность");
                placeholders.add(getPlaceholderAttr(arrearsNumber));
                placeholders.add(getPlaceholderAttr(arrearsSum));
                placeholders.add(getPlaceholderAttr(arrearsEmail));
                break;

            default:
                break;
        }
        return placeholders;
    }

    public void cookiesDecline() {
        waiting();
        cookiesDec.click();
    }

    public IFrame iFrameSend(String number, String sum, String email) {
        paymentNumber.sendKeys(number);
        paymentSum.sendKeys(sum);
        paymentEmail.sendKeys(email);
        continueButton.click();
        waiting();
        getWebDriver().switchTo().frame(iframe);
        return new IFrame(getWebDriver());
    }

}
