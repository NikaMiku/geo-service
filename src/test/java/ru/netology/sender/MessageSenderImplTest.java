package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.i18n.LocalizationServiceImplTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MessageSenderImplTest{


    @Mock
    private GeoServiceImpl geoService;
    @Mock
    private LocalizationServiceImpl localizationService;
    @InjectMocks
    private MessageSenderImpl messageSender;
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void TestRussianServiceSendMassage() {
        setup();
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        when(geoService.byIp("172.0.32.11")).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать!");
        Map<String, String> headers = new HashMap<>();
        headers.put("x-real-ip", "172.0.32.11");
        String result = messageSender.send(headers);
        assertEquals("Добро пожаловать!", result);
    }

    @Test
    void TestUSAServiceSendMassage() {
        setup();
        MessageSenderImpl messageSender1 = new MessageSenderImpl(geoService, localizationService);
        when(geoService.byIp("96.44.183.149")).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        when(localizationService.locale(Country.USA)).thenReturn("Welcome!");
        Map<String,String> headers = new HashMap<>();
        headers.put("x-real-ip", "96.44.183.149");
        String result = messageSender.send(headers);
        assertEquals("Welcome!", result);
    }
}
