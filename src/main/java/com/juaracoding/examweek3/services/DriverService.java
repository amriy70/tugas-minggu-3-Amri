package com.juaracoding.examweek3.services;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverService {

    protected AndroidDriver driver;
    private UiAutomator2Options options;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        setOptions();
        setDriver();
        driver.hideKeyboard();
    }

    @AfterMethod // Tambahkan ini
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    
    public void setDriver() throws MalformedURLException {
        driver = new AndroidDriver (new URL(" http://127.0.0.1:4723"), options);

    }

    public void setOptions() {
        options = new UiAutomator2Options();
        options.setCapability("appium:deviceName", "FYNBYLEQZXFAYH65");
        options.setCapability("platformName", "Android");
        options.setCapability("appium:automationName", "UiAutomator2");
        options.setCapability("appium:appium:appPackage", "com.swaglabsmobileapp");
        options.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
    }

    public AndroidDriver getDriver () {
        return driver;
    }
    
}
