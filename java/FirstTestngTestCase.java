import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class FirstTestngTestCase {
    WebDriver driver;
@Test(priority = 1)
   void openBrowser(){

       WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       driver.get("https://demo.nopcommerce.com/");
       System.out.println("Open Web page");
   }
@Test(priority = 2)
   void logIn(){
       driver.findElement(By.className("ico-login")).click();
       driver.findElement(By.id("Email")).sendKeys("my123@gmail.com");
       driver.findElement(By.id("Password")).sendKeys("123456");
       driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
       System.out.println("Lod in successfully");
   }
   @Test(priority = 3)
   void logOut(){
       driver.close();


   }
}
