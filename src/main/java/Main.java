import com.sun.jndi.ldap.sasl.LdapSasl;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

       /* System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");*/


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lcwaikiki.com/tr-TR/TR/giris");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector(".login-form__link")).click();

        driver.findElement(By.cssSelector(".ym-disable-keys.TLeaf-Mask")).sendKeys("asdsds@com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.cssSelector("#RegisterFormView_Password")).sendKeys("As213");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.cssSelector(".button.bc-blue.register-button-link.submit-button")).click();

        String errorMsg = driver.findElement(By.cssSelector(".field-validation-error #RegisterFormView_RegisterEmail-error")).getText();
        System.out.println(errorMsg);
        String pErrormsg = driver.findElement(By.cssSelector(".field-validation-error #RegisterFormView_Password-error")).getText();
        System.out.println(pErrormsg);

    }
}