import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNGHomework {
    WebDriver driver;

    @Test(priority = 1)

    void webBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        System.out.println("Open Web page");

    }

    @Test(priority = 2)
    void openRegisterPage(){
        driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);

        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")).click();
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Tester");
        driver.findElement(By.id("LastName")).sendKeys("Software");
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("10");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("April");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1984");
        driver.findElement(By.id("Email")).sendKeys("abc45@gmail.com");
        driver.findElement(By.id("Company")).sendKeys("NHS");
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");
        driver.findElement(By.id("register-button")).click();
               }
        @Test(priority = 3)
         void logIn(){
            WebDriverWait wait = new WebDriverWait(driver,25);
            wait.until(ExpectedConditions.titleContains("nopCommerce demo store"));
          driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
          driver.findElement(By.id("Email")).sendKeys("abc45@gmail.com");
          driver.findElement(By.id("Password")).sendKeys("123456");
          driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
          System.out.println("Log in successfully");
      }
      @Test(priority = 4)
      void logOutPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
        Thread.sleep(1000);
        String actualhomepage = driver.getTitle();
        String expactedhomepage = "nopCommerce demo store";
        if (actualhomepage.equals(expactedhomepage)){
            System.out.println("Home page is correct");
        }
        else {
            System.out.println("Home page is not correct");
        }
          }
          @Test(priority = 5)
          void closeBrowser(){
               driver.close();
              System.out.println("Browser successfully close");
          }

      }


