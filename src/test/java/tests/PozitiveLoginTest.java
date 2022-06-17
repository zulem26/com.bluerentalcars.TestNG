package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitiveLoginTest {

    BrcPage brcPage;

    @Test
    public void positiveLoginTesti() {
        brcPage = new BrcPage();

        // 1- https://www.bluerentalcars.com/ bu url ye git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        // 2- anasayfadaki login butonuna bas
        brcPage.loginButonu.click();

        // 3- login aşamasında email adress kısmına doğru maili gir "customer@bluerentalcars.com"
        brcPage.emailKutusu.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        // 4- login aşamasında password kısmına doğru şifreyi gir "12345"
        brcPage.passwordKutusu.sendKeys(ConfigReader.getProperty("brcValidPassword"));

        // 5 -email ve şifreden sonra giriş yapabilmek için alt kısımdaki  login butonu ile giriş yap
        brcPage.ikinciLoginButonu.click();

        // 6 -giriş yapıldıgını test etmek için  kullanınıcının isminin "Jordon Stark"
        // oldugunu ontrol edelim
        String expectedIsim = "Jordon Stark";
        String actualIsim = brcPage.profilIsmi.getText();

        Assert.assertEquals(actualIsim, expectedIsim);

        Driver.closeDriver();





    }
}
