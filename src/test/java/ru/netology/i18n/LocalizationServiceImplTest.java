package ru.netology.i18n;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalizationServiceImplTest {
    @Test
    void testLocale() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String text = localizationService.locale(Country.RUSSIA);
        assertEquals("Добро пожаловать", text);
    }
}
