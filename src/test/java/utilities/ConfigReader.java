package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    static{
        String dosyaYolu = "configurations.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            properties = new Properties();
            properties.load(fis);

            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static String getProperty(String key){
        /*
          test method'undan yolladigimiz string key degerini alip
          Properties class'indan getProperty( ) method'unu kullanarak
          bu key'e ait value'u bize getirdi
         */

        return properties.getProperty(key);
    }
}
