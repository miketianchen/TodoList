import model.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherTest {

    String weatherTemp = "0";
    String weatherId = "800";
    String weatherInfo = "Cloudy";

    Weather testWeather;

    @BeforeEach
    public void setup() {
        testWeather = new Weather(weatherTemp, weatherId, weatherInfo);
    }

    @Test
    public void testGetters() {
        String temp = testWeather.getWeatherTemp();
        assertEquals(temp, weatherTemp);

        String id = testWeather.getWeatherId();
        assertEquals(id, weatherId);

        String info = testWeather.getWeatherInfo();
        assertEquals(info, weatherInfo);
    }

    @Test
    public void testSetters() {
        testWeather.setWeatherTemp("9");
        testWeather.setWeatherId("900");
        testWeather.setWeatherInfo("Sunny");

        assertFalse(testWeather.getWeatherTemp().equals(weatherTemp));
        assertFalse(testWeather.getWeatherId().equals(weatherId));
        assertFalse(testWeather.getWeatherInfo().equals(weatherInfo));
    }
}
