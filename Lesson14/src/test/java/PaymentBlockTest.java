import jdk.jfr.Description;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentBlockTest extends TestPattern {

    @ParameterizedTest
    @Description("Проверка плейсхолдеров")
    @ValueSource(strings = {"phone", "internet", "instalment", "arrears"})
    void placeholdersTest(String type) {
        List<String> placeholders;
        //Пытался реалищовать через switch, но он выдавал ошибку теста - происходил сдвиг значений...
        if (type == "phone") {
            placeholders = getPaymentBlock().checkPlaceholderText(type);
            assertEquals("Номер телефона", placeholders.get(0),
                    "Тест плейсхолдера поля номера провален при типе оплаты: " + type);
            assertEquals("Сумма", placeholders.get(1),
                    "Тест плейсхолдера поля суммы провален при типе оплаты: " + type);
            assertEquals("E-mail для отправки чека", placeholders.get(2),
                    "Тест плейсхолдера поля почты провален при типе оплаты: " + type);
        } else if (type == "internet") {
            placeholders = getPaymentBlock().checkPlaceholderText(type);
            assertEquals("Номер телефона", placeholders.get(0),
                    "Тест плейсхолдера поля номера провален при типе оплаты: " + type);
            assertEquals("Сумма", placeholders.get(1),
                    "Тест плейсхолдера поля суммы провален при типе оплаты: " + type);
            assertEquals("E-mail для отправки чека", placeholders.get(2),
                    "Тест плейсхолдера поля почты провален при типе оплаты: " + type);
        } else if (type == "instalment") {
            placeholders = getPaymentBlock().checkPlaceholderText(type);
            assertEquals("Номер счета на 44", placeholders.get(0),
                    "Тест плейсхолдера поля номера провален при типе оплаты: " + type);
            assertEquals("Сумма", placeholders.get(1),
                    "Тест плейсхолдера поля суммы провален при типе оплаты: " + type);
            assertEquals("E-mail для отправки чека", placeholders.get(2),
                    "Тест плейсхолдера поля почты провален при типе оплаты: " + type);
        } else if (type == "arrears") {
            placeholders = getPaymentBlock().checkPlaceholderText(type);
            assertEquals("Номер счета на 2073", placeholders.get(0),
                    "Тест плейсхолдера поля номера провален при типе оплаты: " + type);
            assertEquals("Сумма", placeholders.get(1),
                    "Тест плейсхолдера поля суммы провален при типе оплаты: " + type);
            assertEquals("E-mail для отправки чека", placeholders.get(2),
                    "Тест плейсхолдера поля почты провален при типе оплаты: " + type);
        }
    }

}
