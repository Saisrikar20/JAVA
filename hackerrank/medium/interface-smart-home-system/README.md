# Interface - Smart Home System

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Context: In a smart home, different devices need to be controlled and monitored through a centralized system. Each device can perform common functions like turning on/off and providing status updates. The smart home system requires an interface to define these functions and allows for the implementation of multiple device types.

Program Specifications

Create an interface named SmartDevice:

- Define the following methods: void turnOn(); void turnOff(); String getStatus();

Create two classes that implement the SmartDevice interface

- Class SmartLight: Member variables: String name, boolean isOn Implement the turnOn, turnOff, and getStatus methods.
- Class SmartThermostat: Member variables: String name, int temperature, boolean isOn Implement the turnOn, turnOff, and getStatus methods.

Create a class named Main:

- In the main method, create instances of SmartLight and SmartThermostat.
- Demonstrate the functionality of turning on and off each device.
- Display the status of each device.

 **Input Format** 

- Name of the smart light.
- Name of the smart thermostat.
- Initial temperature for the thermostat.

 **Constraints** 

NA

 **Output Format** 

- Actions performed on each device (turning on/off).
- Status of each device after the actions.

 **Sample Input 0** 

```
Bedroom Light
Main Thermostat
20

```

 **Sample Output 0** 

```
Enter the name of the smart light: Enter the name of the smart thermostat: Enter the initial temperature for the thermostat: Turning on the light: Bedroom Light
Bedroom Light is now ON.
Turning off the light: Bedroom Light
Bedroom Light is now OFF.
Turning on the thermostat: Main Thermostat
Main Thermostat is now ON. Temperature set to 20��C.
Turning off the thermostat: Main Thermostat
Main Thermostat is now OFF.

Device Status:
Bedroom Light: OFF
Main Thermostat: OFF

```

 **Sample Input 1** 

```
Kitchen Light
Kitchen Thermostat
18

```

 **Sample Output 1** 

```
Enter the name of the smart light: Enter the name of the smart thermostat: Enter the initial temperature for the thermostat: Turning on the light: Kitchen Light
Kitchen Light is now ON.
Turning off the light: Kitchen Light
Kitchen Light is now OFF.
Turning on the thermostat: Kitchen Thermostat
Kitchen Thermostat is now ON. Temperature set to 18��C.
Turning off the thermostat: Kitchen Thermostat
Kitchen Thermostat is now OFF.

Device Status:
Kitchen Light: OFF
Kitchen Thermostat: OFF

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-15T15:23:57.938Z  

```java
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

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/interface-smart-home-system/problem)