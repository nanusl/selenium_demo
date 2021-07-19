import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class AutoLoginTestCase {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/nanusl/develop/ChromeDriver/chromedriver");
        driver = new ChromeDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("http:///");
        driver.findElement(By.id("textfield-1011-inputEl")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("textfield-1011-inputEl")).sendKeys("nanguoqiang123");
        Thread.sleep(2000);
        driver.findElement(By.id("textfield-1010-inputEl")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("textfield-1010-inputEl")).sendKeys("nanguoqiang");
        Thread.sleep(2000);
        driver.findElement(By.id("textfield-1010-inputRow")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("button-1013-btnIconEl")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"component-1028\"]/div[2]/p/a[5]")).click();
        driver.findElement(By.id("textfield-1010-inputEl")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("textfield-1010-inputEl")).sendKeys("nanguoqiang");
        Thread.sleep(2000);
        driver.findElement(By.id("textfield-1011-inputEl")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("textfield-1011-inputEl")).sendKeys("nanguoqiang123");
        Thread.sleep(2000);
        driver.findElement(By.id("button-1013-btnIconEl")).click();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(22000);
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
