import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IFrameTest extends TestPattern{
    private final String number = "297777777";
    private final String sum = "300";
    private final String email = "test-box@mail.ru";
    private final List<String> placeholdersRes = List.of(sum + ".00 BYN", "Оплата: Услуги связи Номер:375" + number,
            "Номер карты", "Срок действия", "Имя держателя (как на карте)", "CVC", "Оплатить " + sum + ".00 BYN");

    @Test
    @DisplayName("Logos")
    @Description("Проверка лого(внутри фрейма)")
    void iFrameLogosTest(){
        IFrame Sender = getPaymentBlock().iFrameSend(number, sum, email);
        getPaymentBlock().waiting();
        assertEquals(5, Sender.logosQuant(),
                "Тест лого внутри фрейма провален");
        Sender.closeIframe();
    }

    @Test
    @DisplayName("Placeholders/texts")
    @Description("Проверка плейсхолдеров и надписей фрейма")
    void iFrameTextTest(){
        IFrame Sender = getPaymentBlock().iFrameSend(number, sum, email);
        List<String> iFramePlaceholders = Sender.getPlaceholders();
        for (int i = 0; i < iFramePlaceholders.size(); i++) {
            assertEquals(Sender.getPlaceholders().get(i), placeholdersRes.get(i),
                    "Проверка тестов во фрейме провалена");
        }
        Sender.closeIframe();
    }

}
