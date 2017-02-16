package Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import framework.driver.WebDriverFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Julia on 19.12.2016.
 */
public class Test1 {
    protected WebDriver driver;
    @BeforeMethod
    @Parameters({ "browserName" })
    public void setup(String browserName) throws Exception {
      driver = WebDriverFactory.getInstance(browserName);
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws Exception{
        driver.get("http://toolsqa.com/automation-practice-form/");
        driver.findElement(By.id("sex-1")).click();
        driver.findElement(By.id("datepicker")).sendKeys("25.10.1969");
        driver.findElement(By.id("profession-0")).click();
        driver.findElement(By.id("submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe("http://toolsqa.com/automation-practice-form/?firstname=&lastname=&sex=Female&profession=Manual+Tester&photo=&continents=Asia&submit="));
        //  Reporter.log("The actual URL is " + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), "http://toolsqa.com/automation-practice-form/?firstname=&lastname=&sex=Female&profession=Manual+Tester&photo=&continents=Asia&submit=");

    }
}
