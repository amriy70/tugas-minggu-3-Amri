package com.juaracoding.examweek3.screens;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class InventoryScreen {

    private AndroidDriver driver;
    private By header = AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");
    
    // Tombol 'ADD TO CART' (untuk produk pertama)
    private By addToCartButton = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]");
    
    // Tombol 'REMOVE' (untuk produk pertama, setelah diklik)
    private By removeButton = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]"); 
    
    // Icon Cart Count (lebih spesifik)
    private By cartIconCount = AppiumBy.xpath("//android.widget.TextView[@text=\"1\"]");


    public InventoryScreen(AndroidDriver driver) {
        this.driver = driver;
        this.driver.manage ().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // Mengklik tombol 'ADD TO CART'
    public void addProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    // Mengambil jumlah barang di keranjang
    public String getCartIconCount() {
        // Menggunakan explicit wait untuk memastikan count muncul
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartIconCount)).getText();
    }

    // Verifikasi tombol berubah menjadi 'Remove'
    public boolean verifyButtonTextIsRemove(){
        // Cek apakah tombol remove muncul/terlihat
        return driver.findElement(removeButton).isDisplayed();
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }
}
