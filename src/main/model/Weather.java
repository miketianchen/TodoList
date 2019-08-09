package model;

public class Weather {
    private String weatherTemp;
    private String weatherId;
    private String weatherInfo;

    public Weather (String weatherTemp, String weatherId, String weatherInfo) {
        this.weatherTemp = weatherTemp;
        this.weatherId = weatherId;
        this.weatherInfo = weatherInfo;
    }

    public void setWeatherTemp(String weatherTemp) {
        this.weatherTemp = weatherTemp;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public void setWeatherInfo(String weatherInfo) {
        this.weatherInfo = weatherInfo;
    }

    public String getWeatherTemp() {
        return weatherTemp;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public String getWeatherInfo() {
        return weatherInfo;
    }
}
