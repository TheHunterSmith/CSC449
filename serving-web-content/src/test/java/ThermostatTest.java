import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThermostatTest {

    @Test
    public void testSetTargetTemperatureValidInput() {
        // Setup
        Thermostat thermostat = new Thermostat(65.0, 88.0);
        thermostat.setTargetTemperature(75.0);

        // Action
        thermostat.setTargetTemperature(45.0);

        // Assertion
        assertEquals(65.0, thermostat.getCurrentTargetTemperature(), "Target temperature should be set to the valid input.");
    }

    @Test
    public void testRememberPreferencesAfterRestart() {
        // Setup
        Thermostat thermostat = new Thermostat(60.0, 90.0);
        double initialPreferredTemp = 72.5;
        thermostat.setPreferredTemperature(initialPreferredTemp);
        thermostat.setTargetTemperature(80.0);

        // Action - Simulate a restart
        thermostat.restartAndLoadPreferences();

        // Assertion
        assertEquals(initialPreferredTemp, thermostat.getCurrentTargetTemperature(),
                "After restart, the current target temperature should revert to the preferred temperature.");

        // Optional: Add another assertion to ensure the preferred temperature itself is still remembered
        assertEquals(initialPreferredTemp, thermostat.getPreferredTemperature(),
                "The preferred temperature should still be remembered correctly.");
    }
}