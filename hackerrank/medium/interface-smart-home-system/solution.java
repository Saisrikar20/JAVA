import java.util.*;

interface SmartDevice {
    void turnOn();
    void turnOff();
    String getStatus();
}

class SmartLight implements SmartDevice {
    String name;
    boolean isOn;

    SmartLight(String name) {
        this.name = name;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(name + " is now ON.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(name + " is now OFF.");
    }

    public String getStatus() {
        return name + ": " + (isOn ? "ON" : "OFF");
    }
}

class SmartThermostat implements SmartDevice {
    String name;
    int temperature;
    boolean isOn;

    SmartThermostat(String name, int temperature) {
        this.name = name;
        this.temperature = temperature;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(name + " is now ON. Temperature set to "
                + temperature + "\u00B0C.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(name + " is now OFF.");
    }

    public String getStatus() {
        return name + ": " + (isOn ? "ON" : "OFF");
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name of the smart light: ");
        String lightName = sc.nextLine();

        System.out.print("Enter the name of the smart thermostat: ");
        String thermostatName = sc.nextLine();

        System.out.print("Enter the initial temperature for the thermostat: ");
        int temperature = sc.nextInt();

        SmartLight light = new SmartLight(lightName);
        SmartThermostat thermostat =
                new SmartThermostat(thermostatName, temperature);

        System.out.println("Turning on the light: " + lightName);
        light.turnOn();

        System.out.println("Turning off the light: " + lightName);
        light.turnOff();

        System.out.println("Turning on the thermostat: " + thermostatName);
        thermostat.turnOn();

        System.out.println("Turning off the thermostat: " + thermostatName);
        thermostat.turnOff();

        System.out.println();
        System.out.println("Device Status:");
        System.out.println(light.getStatus());
        System.out.println(thermostat.getStatus());

        sc.close();
    }
}
