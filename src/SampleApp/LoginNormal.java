package SampleApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginNormal {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Chrome is Opened");

        driver.get("http://uitestingplayground.com/sampleapp");
        System.out.println(driver.getTitle());

        String name = "Rahayu";
        driver.findElement(By.name("UserName")).sendKeys(name);
        driver.findElement(By.name("Password")).sendKeys("pwd");
        driver.findElement(By.id("login")).click();

        String successMessage = driver.findElement(By.id("loginstatus")).getText();
        System.out.println(successMessage);
        Assert.assertEquals(successMessage,"Welcome, "+name+"!");

        Thread.sleep(3000);
        driver.close();
    }
}
