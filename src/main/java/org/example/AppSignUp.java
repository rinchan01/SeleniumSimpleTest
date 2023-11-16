package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.Assertions;



public class AppSignUp {
    WebDriver driver;
    public static void main(String[] args) throws Exception {
        AppSignUp app = new AppSignUp();
        app.openBrowser();
        app.signupTest();
        app.closeBrowser();
    }

    public void openBrowser() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RIN\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        this.driver = new ChromeDriver(options); // Use the driver field of the App class
        driver.get("https://violet.vn/");
        WebElement link = driver.findElement(By.xpath("//*[@id=\"login\"]/div[5]/a[2]"));
        link.click();
        Thread.sleep(5000);  
        // driver.quit(); 
    }

    public void signupTest() {
        WebElement username = driver.findElement(By.id("us_username"));
        username.sendKeys("tlinh123456789");
        WebElement password = driver.findElement(By.id("us_password"));
        password.sendKeys("abc123123");
        WebElement re_password = driver.findElement(By.id("password2"));
        re_password.sendKeys("abc123123");
        WebElement name = driver.findElement(By.id("us_fullname"));
        name.sendKeys("Thái Linh");
        WebElement gender_woman = driver.findElement(By.id("us_sex_2"));
        //radio button is seleted
        gender_woman.click();
        WebElement phone = driver.findElement(By.id("us_phone"));
        phone.sendKeys("0338732666");
        WebElement email = driver.findElement(By.id("us_email"));
        email.sendKeys("lihu86877@gmail.com");
        WebElement school = driver.findElement(By.id("us_school"));
        school.sendKeys("Dai hoc Cong Nghe");
        WebElement province = driver.findElement(By.id("us_province"));
        province.sendKeys("Ha Noi");
        //check box is selected
        WebElement agreement = driver.findElement(By.id("us_term"));
        agreement.click();
        //check box is toggled on or off
        if (agreement.isSelected()) {
            System.out.println("Checkbox is Toggled On");
        } else {
            System.out.println("Checkbox is Toggled Off");
        }
        WebElement register = driver.findElement(By.name("commit"));
        register.submit();
        
    }

    public void closeBrowser() {
        driver.quit();
    }
}