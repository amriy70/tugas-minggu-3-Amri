package com.juaracoding.examweek3.screens;

import java.time.Duration;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;


public class LoginScreen {

    private AndroidDriver driver;
    private By username = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]");
    private By password = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]");
    private By button = AppiumBy.xpath("//android.widget.TextView[@text=\"LOGIN\"]");
    private By errorMessage = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]");

    public LoginScreen (AndroidDriver driver){
        this.driver = driver;
        this.driver.manage ().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void fillUsername (String username) {
        driver.findElement(this.username).sendKeys(username);
    }

    public void fillPassword (String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    public void click() {
        driver.findElement(button).click();
    }

    public String getMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public void login (String username, String password) {
        fillUsername(username);
        fillPassword(password);
        click();
    }

    
}
