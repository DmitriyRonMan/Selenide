import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    public static String setLocalDate(int day) {
        String date = LocalDate.now().plusDays(day).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldTestForDay3() {
        $("[data-test-id=city] .input__control").setValue("Оренбург");
        $("[data-test-id=date] .input__control").doubleClick().sendKeys(setLocalDate(3));
        $("[data-test-id=name] .input__control").setValue("Пушкин Александр");
        $("[data-test-id=phone] .input__control").setValue("+79878723624");
        $("[data-test-id=agreement]").click();
        $(".button__content").click();
        $("[data-test-id=notification] .notification__title").shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-test-id=notification] .notification__content").shouldHave(Condition.text("Встреча успешно забронирована на " + setLocalDate(3)));
    }

    @Test
    void shouldTestForDay4() {
        $("[data-test-id=city] .input__control").setValue("Оренбург");
        $("[data-test-id=date] .input__control").doubleClick().sendKeys(setLocalDate(4));
        $("[data-test-id=name] .input__control").setValue("Пушкин Александр");
        $("[data-test-id=phone] .input__control").setValue("+79878723624");
        $("[data-test-id=agreement]").click();
        $(".button__content").click();
        $("[data-test-id=notification] .notification__title").shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-test-id=notification] .notification__content").shouldHave(Condition.text("Встреча успешно забронирована на " + setLocalDate(4)));
    }

    @Test
    void shouldTestForDay10() {
        $("[data-test-id=city] .input__control").setValue("Оренбург");
        $("[data-test-id=date] .input__control").doubleClick().sendKeys(setLocalDate(10));
        $("[data-test-id=name] .input__control").setValue("Пушкин Александр");
        $("[data-test-id=phone] .input__control").setValue("+79878723624");
        $("[data-test-id=agreement]").click();
        $(".button__content").click();
        $("[data-test-id=notification] .notification__title").shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-test-id=notification] .notification__content").shouldHave(Condition.text("Встреча успешно забронирована на " + setLocalDate(10)));
    }

    @Test
    void shouldTestForDay365() {
        $("[data-test-id=city] .input__control").setValue("Оренбург");
        $("[data-test-id=date] .input__control").doubleClick().sendKeys(setLocalDate(365));
        $("[data-test-id=name] .input__control").setValue("Пушкин Александр");
        $("[data-test-id=phone] .input__control").setValue("+79878723624");
        $("[data-test-id=agreement]").click();
        $(".button__content").click();
        $("[data-test-id=notification] .notification__title").shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-test-id=notification] .notification__content").shouldHave(Condition.text("Встреча успешно забронирована на " + setLocalDate(365)));
    }
}
