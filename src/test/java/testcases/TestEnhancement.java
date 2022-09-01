package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestEnhancement {
    FirefoxDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void test() {
        WebElement link = driver.findElement(By.linkText("Gmail"));

        int x = link.getRect().getX();
        int y = link.getRect().getY();

        Actions action = new Actions(driver);
        action.moveByOffset(x, y).click().perform();

        Assert.assertTrue(true);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
