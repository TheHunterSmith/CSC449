public class Thermostat {
    private double currentTargetTemperature;
    private double minTemp;
    private double maxTemp;
    private double preferredTemperature;
    public Thermostat(double minTemp, double maxTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.currentTargetTemperature = (minTemp + maxTemp) / 2; // Default
        this.preferredTemperature = currentTargetTemperature;
    }
    public void setTargetTemperature(double newTemperature) {
        if (newTemperature < minTemp) {
            this.currentTargetTemperature = minTemp;
        } else if (newTemperature > maxTemp) {
            this.currentTargetTemperature = maxTemp;
        } else {
            this.currentTargetTemperature = newTemperature;
        }
    }
    public double getCurrentTargetTemperature() {
        return currentTargetTemperature;
    }
    // Preferred Temperature to save
    public void setPreferredTemperature(double preferredTemperature) {
        if (preferredTemperature >= minTemp && preferredTemperature <= maxTemp) {
            this.preferredTemperature = preferredTemperature;
        } else {
            System.out.println("Warning: Preferred temperature " + preferredTemperature + " is out of range.");
        }
    }
    // Method to get the stored preferred temperature
    public double getPreferredTemperature() {
        return preferredTemperature;
    }
    // Method to "restart" and load the preferred temperature (simulates loading from persistence)
    public void restartAndLoadPreferences() {
        // Just assume the preferredTemperature was "saved" and now we "load" it.
        this.currentTargetTemperature = this.preferredTemperature;
    }
}