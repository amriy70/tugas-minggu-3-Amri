package com.juaracoding.examweek3.authentications;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.juaracoding.examweek3.screens.InventoryScreen;
import com.juaracoding.examweek3.screens.LoginScreen;
import com.juaracoding.examweek3.services.DriverService;

public class LoginTest extends DriverService{
    
     @Test
    public void loginPositiveTest() {
        // Driver sudah diinisialisasi oleh DriverService.setup()
        LoginScreen loginscreen = new LoginScreen(driver);
        InventoryScreen inventoryScreen = new InventoryScreen(driver);

        // Langsung panggil login, tidak perlu fillUsername/fillPassword terpisah
        loginscreen.login("standard_user", "secret_sauce");
        
        // Verifikasi berhasil login dengan mengecek header
        Assert.assertEquals(inventoryScreen.getHeaderText(), "PRODUCTS", "Verifikasi GAGAL: Tidak berhasil masuk ke halaman Produk.");
    }
}
