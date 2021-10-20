package ru.netology;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryFormTest {

    CardDeliveryFormData data;

    @BeforeEach
    void setUp() {
        data = DataGenerator.generateFormData("ru");
        open("http://localhost:9999/");
    }

    @Test
    void shouldSubmitCardDeliveryForm() {
        $("[data-test-id='city'] input").setValue(data.getCity());
        $("[data-test-id='date'] .input__control")
                .setValue("'\ue009' + '\ue003'")
                .setValue(data.getDate());
        $("[data-test-id='name'] input").setValue(data.getName());
        $("[data-test-id='phone'] input").setValue(data.getPhone());
        $("[data-test-id='agreement'] .checkbox__box").click();
        $(byText("Запланировать")).click();
        $("[data-test-id='success-notification'] .notification__content")
                .shouldHave(text("Встреча успешно запланирована на " + data.getDate()))
                .shouldBe(visible);
        $("[data-test-id='date'] .input__control")
                .setValue("'\ue009' + '\ue003'")
                .setValue(DataGenerator.date());
        $(byText("Запланировать")).click();
        $("[data-test-id='replan-notification'] .notification__content")
                .shouldHave(text("У вас уже запланирована встреча на другую дату. Перепланировать?"))
                .shouldBe(visible);
    }

    @AfterEach
    void clearBrowser() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }
}
