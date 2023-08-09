package ru.netology.geo;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoServiceImplTest {
    @Test
    void testLocalHost() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp("127.0.0.1");
        assertEquals(null, location.getCity());
        assertEquals(null, location.getCountry());
        assertEquals(null, location.getStreet());
        assertEquals(0, location.getBuiling());
    }
    @Test
    void testLocationByIpRu() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp("172.0.0.1");
        assertEquals("Moscow", location.getCity());
        assertEquals(Country.RUSSIA, location.getCountry());
        assertEquals(null, location.getStreet());
        assertEquals(0, location.getBuiling());
    }
    @Test
    void testLocationByIpUSA() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp("96.0.0.1");
        assertEquals("New York", location.getCity());
        assertEquals(Country.USA, location.getCountry());
        assertEquals(null, location.getStreet());
        assertEquals(0, location.getBuiling());
    }
}
