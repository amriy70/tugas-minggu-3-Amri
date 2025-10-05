package com.juaracoding.examweek3.authentications;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.juaracoding.examweek3.screens.InventoryScreen;
import com.juaracoding.examweek3.screens.LoginScreen;
import com.juaracoding.examweek3.services.DriverService;

public class AddToCartTest extends DriverService{

    //Data Test
    private String Username = "standard_user";
    private String Password = "secret_sauce";
    private String expectedCount = "1";

    @Test
    public void verifyAddToCartFunctionality() {

    // inisialisai page Object
        LoginScreen loginscreen = new LoginScreen(driver);
        InventoryScreen inventoryscreen = new InventoryScreen (driver);
        
    // Login menggunakan username dan password
        loginscreen.login(Username, Password);

    // Klik 'Add to Cart' pada screen product
        inventoryscreen.addProductToCart();

    // Verifikasi expected result 1 (icon keranjang = 1)
        String actualCount = inventoryscreen.getCartIconCount();
        System.out.println(" Memverifikasi Ikon Keranjang. Actual Count: " + actualCount);
        Assert.assertEquals(actualCount, expectedCount, "Verifikasi GAGAL: Ikon keranjang tidak menunjukkan angka " + expectedCount + ".");

        // Verifikasi expected result 2 (tombol = remove)
        System.out.println(" Memverifikasi Tombol produk berubah menjadi 'Remove'.");
        Assert.assertTrue(inventoryscreen.verifyButtonTextIsRemove(), 
                          "Verifikasi GAGAL: Tombol 'Add to Cart' tidak berubah menjadi 'Remove'.");
    }
}
