package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.Assertions;



public class AppSignIn {
    WebDriver driver;
    public static void main(String[] args) throws Exception {
        AppSignIn app = new AppSignIn();
        app.openBrowser();
        app.signinTest();
        app.closeBrowser();
    }

    public void openBrowser() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RIN\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        this.driver = new ChromeDriver(options); // Use the driver field of the App class
        driver.get("https://violet.vn/");
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://violet.vn/";
        Assertions.assertEquals(expectedURL, actualURL, "URL mismatch");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Thư viện trực tuyến ViOLET";
        Assertions.assertEquals(expectedTitle, actualTitle, "Title mismatch"); 
        Thread.sleep(10000);   
    }

    public void signinTest() {
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tlinh123456789");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("abc123123");
        WebElement remember_account = driver.findElement(By.id("remember"));
        remember_account.click();
        WebElement login = driver.findElement(By.name("commit"));
        login.submit();
        
    }

    public void closeBrowser() {
        driver.quit();
    }
}