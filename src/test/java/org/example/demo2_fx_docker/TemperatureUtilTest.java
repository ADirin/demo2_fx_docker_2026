package org.example.demo2_fx_docker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureUtilTest {

    @Test
    void testCelsiusToFahrenheit_zero() {
        assertEquals(32.0,
                TemperatureUtil.celsiusToFahrenheit(0),
                0.001);
    }

    @Test
    void testCelsiusToFahrenheit_positive() {
        assertEquals(212.0,
                TemperatureUtil.celsiusToFahrenheit(100),
                0.001);
    }

    @Test
    void testCelsiusToFahrenheit_negative() {
        assertEquals(14.0,
                TemperatureUtil.celsiusToFahrenheit(-10),
                0.001);
    }
}
