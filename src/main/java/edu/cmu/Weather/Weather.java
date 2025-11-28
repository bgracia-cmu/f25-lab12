package edu.cmu.Weather;

// BG: 1. Violates Usability API design principle (U2, U7)
// BG: since it uses a boolean flag to indicate unit preference instead of a more explicit approach
// BG: as well as mixing unit conversion logic within the getter method.
// BG: 2. The getter was wrong since it converted to mm when the flag indicated inches.

public class Weather {
    private WeatherService weatherService;

    /**
     * Retrieves the rainfall measurement over the last 24 hours from the weather service in inches.
     * @return the rainfall amount in inches.
     */
    public double getRainfallInches() {
        double mmRainfall = weatherService.getRainfall();
        double inRainfall = mmRainfall / 25.4;

        return inRainfall;
    }

    /**
     * Retrieves the rainfall measurement over the last 24 hours from the weather service in millimeters.
     * @return the rainfall amount in millimeters.
     */
    public double getRainfallMm() {
        double mmRainfall = weatherService.getRainfall();

        return mmRainfall;
    }
}
