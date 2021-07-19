import com.google.common.collect.Maps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author 南来
 * @version V1.0
 * @Description
 * @date 2019-03-15 14:35
 */
public class AutoLogin {

    public static void main(String[] args) throws InterruptedException {
        WebDriver chromeDriver = getWebDriver();

        WebDriver.Options manage = chromeDriver.manage();
        manage.deleteAllCookies();

        manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        chromeDriver.get("http:///");

        chromeDriver.findElement(By.xpath("//*[@id=\"textfield-1010-inputEl\"]")).sendKeys("nanguoqiang");
        chromeDriver.findElement(By.xpath("//*[@id=\"textfield-1011-inputEl\"]")).sendKeys("nanguoqiang123");
        chromeDriver.findElement(By.xpath("//*[@id=\"button-1013\"]")).click();

        /*        // 获取当前页面句柄
        String handle = chromeDriver.getWindowHandle();
        // 获取所有页面的句柄，并循环判断不是当前的句柄 然后切换到子窗体
        for (String handles : chromeDriver.getWindowHandles()) {
            if (handles.equals(handle))
                continue;
            chromeDriver.switchTo().window(handles);
        }

        // 由于登录输入框在frame中，还需要先切换进入frame，否则，也找不到输入框的
        chromeDriver.switchTo().frame(chromeDriver.findElement(By.xpath("//*[@id='ptlogin_iframe']")));*/

        //移动到底部
        //((JavascriptExecutor) chromeDriver).executeScript("window.scrollTo(0, document.body.scrollHeight)");


        // Thread.sleep(15000);
        // chromeDriver.quit();
    }

    private static WebDriver getWebDriver() {
        ChromeOptions options = getChromeOptions();
        return new ChromeDriver(options);
    }

    private static ChromeOptions getChromeOptions() {
        System.setProperty("webdriver.chrome.driver", "/Users/nanusl/develop/ChromeDriver/chromedriver");

        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = Maps.newHashMap();
        // 不加载图片
        prefs.put("profile.managed_default_content_settings.images", 2);

        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "test-type", "--ignore-certificate-errors"));
        return options;
    }
}