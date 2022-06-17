package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class NegativeLoginTesti {

    BrcPage brcPage;

    @Test
    public void yanlisEmailDogruSifre() {
        brcPage = new BrcPage();
        //TEST= YANLIŞ EMAİL ADRES DOĞRU ŞİFRE İLE GİREMEME

        //1- https://www.bluerentalcars.com/ bu url ye git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //2- anasayfadaki login butonuna bas
        brcPage.loginButonu.click();

        //3- login aşaasında email adress kısmına yanlış maili gir "client@bluerentalcars.com"
        brcPage.emailKutusu.sendKeys(ConfigReader.getProperty("brcWrongEmail"));

        //4- login aşamasında password kısmına doğru şifreyi gir "12345"
        brcPage.passwordKutusu.sendKeys(ConfigReader.getProperty("brcValidPassword"));

        //5- giris butonuna tiklayiniz
        brcPage.ikinciLoginButonu.click();

        //6- giremediğini kontrol etmek için sağ ustte gelen yazının "invalid credentials" oldugunu kontrol edelim.
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(brcPage.basarisizGirisMsj));
        Assert.assertTrue(brcPage.basarisizGirisMsj.isDisplayed());




    }
}
