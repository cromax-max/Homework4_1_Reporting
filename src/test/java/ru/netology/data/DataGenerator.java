package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    public static CardDeliveryFormData generateFormData(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return new CardDeliveryFormData(
                faker.address().city(),
                faker.name().fullName(),
                faker.numerify("['+7(9##)###-##-##']"));
    }

    public static String date() {
        return LocalDate.now()
                .plusDays(new Faker().random().nextInt(3, 100))
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
